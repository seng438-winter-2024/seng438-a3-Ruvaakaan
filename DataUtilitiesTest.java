package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DataUtilitiesTest extends DataUtilities {

	private Mockery MaxMinMockKeyed;
  	private KeyedValues MaxMinValues;
	private Mockery NegativeMockKeyed;
	private KeyedValues NegativeValues;
    private Mockery NullMockKeyed;
    private KeyedValues NullValues;
	private Mockery ValidMockKeyed;
    private KeyedValues ValidValues;
	private Mockery ZeroMockKeyed;
	private KeyedValues ZeroValues;

	@BeforeClass public static void setUpBeforeClass() throws Exception { }

	@Before
	public void setUp() {
		MaxMinMockKeyed = new Mockery(); // create the mockery object
		MaxMinValues = MaxMinMockKeyed.mock(KeyedValues.class); 
		// creates a mock of the KeyedValues object, contains the pairs (0,0),(1,1),(2,Double.MAX_VALUE),(3,-Double.MAX_VALUE)
		MaxMinMockKeyed.checking(new Expectations() {{
			allowing(MaxMinValues).getItemCount();
			will(returnValue(4));
			allowing(MaxMinValues).getKey(0);
			will(returnValue("0"));
			allowing(MaxMinValues).getKey(1);
			will(returnValue("1"));
			allowing(MaxMinValues).getKey(2);
			will(returnValue("2"));
			allowing(MaxMinValues).getKey(3);
			will(returnValue("3"));
			allowing(MaxMinValues).getValue(0);
			will(returnValue(0));
			allowing(MaxMinValues).getValue(1);
			will(returnValue(1));
			allowing(MaxMinValues).getValue(2);
			will(returnValue(Double.MAX_VALUE));
			allowing(MaxMinValues).getValue(3);
			will(returnValue(-Double.MAX_VALUE));
		}});
		NegativeMockKeyed = new Mockery(); // create the mockery object
        NegativeValues = NegativeMockKeyed.mock(KeyedValues.class); // creates a mock of the KeyedValues object, contains the pairs (0,-1),(1,2),(2,3)
        NegativeMockKeyed.checking(new Expectations() {{
            allowing(NegativeValues).getItemCount();
            will(returnValue(3));
            allowing(NegativeValues).getKey(0);
            will(returnValue("0"));
            allowing(NegativeValues).getKey(1);
            will(returnValue("1"));
            allowing(NegativeValues).getKey(2);
            will(returnValue("2"));
            allowing(NegativeValues).getValue(0);
            will(returnValue(-1));
            allowing(NegativeValues).getValue(1);
            will(returnValue(2));
            allowing(NegativeValues).getValue(2);
            will(returnValue(3));
        }});
		NullMockKeyed = new Mockery(); // create the mockery object
        NullValues = NullMockKeyed.mock(KeyedValues.class); // creates a mock of the KeyedValues object, contains the pairs where all values are null
        NullMockKeyed.checking(new Expectations() {{
            allowing(NullValues).getItemCount();
            will(returnValue(3));
            allowing(NullValues).getKey(0);
            will(returnValue("0"));
            allowing(NullValues).getKey(1);
            will(returnValue("1"));
            allowing(NullValues).getKey(2);
            will(returnValue("2"));
            allowing(NullValues).getValue(0);
            will(returnValue(null));
            allowing(NullValues).getValue(1);
            will(returnValue(null));
            allowing(NullValues).getValue(2);
            will(returnValue(null));
        }});
		ValidMockKeyed = new Mockery(); // create the mockery object
        ValidValues = ValidMockKeyed.mock(KeyedValues.class); // creates a mock of the KeyedValues object
        ValidMockKeyed.checking(new Expectations() {{
            allowing(ValidValues).getItemCount();
            will(returnValue(3));
            allowing(ValidValues).getKey(0);
            will(returnValue("0"));
            allowing(ValidValues).getKey(1);
            will(returnValue("1"));
            allowing(ValidValues).getKey(2);
            will(returnValue("2"));
            allowing(ValidValues).getValue(0);
            will(returnValue(5));
            allowing(ValidValues).getValue(1);
            will(returnValue(9));
            allowing(ValidValues).getValue(2);
            will(returnValue(2));
        }});
		ZeroMockKeyed = new Mockery(); // create the mockery object
		ZeroValues = ZeroMockKeyed.mock(KeyedValues.class); // creates a mock of the KeyedValues object
		ZeroMockKeyed.checking(new Expectations() {
			{
				allowing(ZeroValues).getItemCount();
				will(returnValue(3));
				allowing(ZeroValues).getKey(0);
				will(returnValue("0"));
				allowing(ZeroValues).getKey(1);
				will(returnValue("1"));
				allowing(ZeroValues).getKey(2);
				will(returnValue("2"));
				allowing(ZeroValues).getValue(0);
				will(returnValue(1));
				allowing(ZeroValues).getValue(1);
				will(returnValue(0)); // we set the middle value to 0 since it was seen that the first value is always
										// skipped in calculation
				allowing(ZeroValues).getValue(2);
				will(returnValue(3));
			}
		});
	}

	/**
	 * This class contains a JUnit test case for the `createNumberArray` method in the `DataUtilities` class.
	* The method tests the creation of an array containing normal and MAX/MIN_VALUEs.
	*/
	@Test
	public void testCreateNumberArrayValidData() {
		double[] data = { 1.5, Double.MAX_VALUE, -Double.MAX_VALUE, 1.2 }; // valid array with type double
		Number[] expected = { 1.5, Double.MAX_VALUE, -Double.MAX_VALUE, 1.2 }; // copy of the original array but with type number
		Number[] result = DataUtilities.createNumberArray(data); // convert the original array to new type

		// the following code prints out the converted array, you will notice that the last value is always null
		for(int j=0;j<data.length;j++) {
			System.out.println(result[j]);
		} 

		assertArrayEquals(expected, result); // check result
	}

	/*
	* This class tests the createNumberArray2D method in the DataUtilities class
	* when provided with an empty 2 dimensional array. 
	*/
	@Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray2DEmptyData() {
        DataUtilities.createNumberArray2D(new double[2][1]); // creates an empty 2 dimensional array with 1 item each to be used
    }

	/*
	* This class tests the createNumberArray2D method in the DataUtilities class
	* when one of the subarrays passed in is empty.
	*/
	@Test
    public void testCreateNumberArray2DHalfEmpty() {
        double[][] data = {{1.5, 2.0, 3.7, 1.2}, {}}; // array of type double with only 1 valid subarray
        Number[][] expected = {{1.5, 2.0, 3.7, 1.2}, {}}; // same array with type number, as it should be converted
        Number[][] result = DataUtilities.createNumberArray2D(data); // run the method to convert
        
        assertArrayEquals(expected, result); // check result
    }

	/*
	* This class tests the createNumberArray2D method in the DataUtilities class
	* when a valid 2d array is passed in.
	*/
    @Test
    public void testCreateNumberArray2DValidData() {
        double[][] data = {{1.5, 2.0, 3.7}, {4.2, 5.8, 6.1}}; // valid array with type double
        Number[][] expected = {{1.5, 2.0, 3.7}, {4.2, 5.8, 6.1}}; // expected array after conversion
        Number[][] result = DataUtilities.createNumberArray2D(data); // store the converted array

        assertArrayEquals(expected, result); // test the result
    }

	/*
	* This class tests the createNumberArray method in the DataUtilities class
	* when an empty double array is passed in
	*/
	@Test(expected = InvalidParameterException.class)
	public void testCreateNumberArrayEmptyData() {
		DataUtilities.createNumberArray(new double[1]); // test using a new empty array
	}

	/**
	 * This class contains a JUnit test case for the `getCumulativePercentages()` method in the `DataUtilities` class.
	* The method calculates cumulative percentages based on the maximum and minimum MaxMinValues provided as a `KeyedValues` object.
	*/
	@Test
	public void testGetCumulativePercentagesMaxMin() {
		double[] expected = {0, 1, Double.MAX_VALUE, 1}; // an array of the expected cumulative percentages indexed at each level
		KeyedValues result = DataUtilities.getCumulativePercentages(MaxMinValues); // get the cumulative percentages from the function being tested

		assertEquals(expected.length, result.getItemCount()); // test that the length of the returned result is the same as expected
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], result.getValue(i).doubleValue(), 0.0001); // test each cumulative percentage for each index
		}
	}

	/*
	* This class tests the exception that gets returned from the getCumulativePercentages in the DataUtilities class
	* when provided with an empty KeyedValues object
	*/
	@Test(expected = InvalidParameterException.class)
    public void testGetCumulativePercentages_EmptyData() {
        DataUtilities.getCumulativePercentages(new DefaultKeyedValues()); // creates an empty KeyedValues object to be used in testing
    }

	/*
	* This class tests the getCumulativePercentages method in the DataUtilities class
	* when provided a mocked KeyedValue object that contains a negative value
	*/
    @Test
    public void testGetCumulativePercentagesWithNegativeValues() {
        double[] expected = {-0.25, 0.25, 1.0}; // an array of the expected cumulative percentages indexed at each level
        KeyedValues result = DataUtilities.getCumulativePercentages(NegativeValues); // get the cumulative percentages from the function being tested

        assertEquals(expected.length, result.getItemCount()); // test that the length of the returned result is the same as expected
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result.getValue(i).doubleValue(), 0.0001); // test each cumulative percentage for each index
        }
	}

	/*
	* This class tests the getCumulativePercentages method in the DataUtilities class
	* when provided with a mocked KeyedValues object where all values are null. We expect that since
	* the data is invalid, the InvalidParameterException is thrown.
	*/
    @Test(expected = InvalidParameterException.class)
    public void CumulativePercentagesWithNullValue() {
        KeyedValues result = DataUtilities.getCumulativePercentages(NullValues); // get the cumulative percentages from the function being tested
        // since all values in the values should be null, we expect an exception
    }

	/*
	* This class tests the getCumulativePercentages method in the DataUtilities class
	* using a valid mocked KeyedValues object containing valid data.
	*/
    @Test
    public void testGetCumulativePercentages() {
        double[] expected = {0.3125, 0.875, 1.0}; // expected cumulative percentages
        KeyedValues result = DataUtilities.getCumulativePercentages(ValidValues); // get the cumulative percentages

        assertEquals(expected.length, result.getItemCount()); // test the length of the result
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result.getValue(i).doubleValue(), 0.0001); // test each cumulative percentage
        }
    }

	/*
	* This class tests the getCumulativePercentages method in the DataUtilities class
	* using a mocked KeyedValues object where one of the values is 0. 
	* Note: The bug in this method allows this test to pass if the first value in the KeyedValues
	* is set to 0 as getCumulativePercentages seems to ignore the first value in calculations
	*/
	@Test
	public void testGetCumulativePercentagesWithZero() {
		double[] expected = { 0.25, 0.25, 1.0 }; // expected cumulative percentages
		KeyedValues result = DataUtilities.getCumulativePercentages(ZeroValues); // get the cumulative percentages

		assertEquals(expected.length, result.getItemCount()); // test the length of the result
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], result.getValue(i).doubleValue(), 0.0001); // test each cumulative percentage
		}
	}
		
	/**
	* The tearDown method is typically employed to release resources such as closing database connections.
	* However, in our scenario, where such connections are absent, we utilize it to nullify variables.
	* While garbage collection handles this automatically, our intention here is to showcase its functionality.
	*/
	@After
	public void tearDown() {
		MaxMinMockKeyed = null;
		MaxMinValues = null;
		NegativeMockKeyed = null;
		NegativeValues = null;
		NullMockKeyed = null;
        NullValues = null;
		ValidMockKeyed = null;
        ValidValues = null;
		ZeroMockKeyed = null;
		ZeroValues = null;
	}

	@AfterClass public static void setUpAfterClass() throws Exception { }
}
