package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DataUtilitiesTest extends DataUtilities {

	private Mockery createNumberArrayValidDataMockKeyed;
  private KeyedValues createNumberArrayValidDataValues;

	@BeforeClass public static void setUpBeforeClass() throws Exception { }

	@Before
	public void setUp() {
		createNumberArrayValidDataMockKeyed = new Mockery(); // create the mockery object
		createNumberArrayValidDataValues = createNumberArrayValidDataMockKeyed.mock(KeyedValues.class); 
		// creates a mock of the KeyedValues object, contains the pairs (0,0),(1,1),(2,Double.MAX_VALUE),(3,-Double.MAX_VALUE)
		createNumberArrayValidDataMockKeyed.checking(new Expectations() {{
			allowing(createNumberArrayValidDataValues).getItemCount();
			will(returnValue(4));
			allowing(createNumberArrayValidDataValues).getKey(0);
			will(returnValue("0"));
			allowing(createNumberArrayValidDataValues).getKey(1);
			will(returnValue("1"));
			allowing(createNumberArrayValidDataValues).getKey(2);
			will(returnValue("2"));
			allowing(createNumberArrayValidDataValues).getKey(3);
			will(returnValue("3"));
			allowing(createNumberArrayValidDataValues).getValue(0);
			will(returnValue(0));
			allowing(createNumberArrayValidDataValues).getValue(1);
			will(returnValue(1));
			allowing(createNumberArrayValidDataValues).getValue(2);
			will(returnValue(Double.MAX_VALUE));
			allowing(createNumberArrayValidDataValues).getValue(3);
			will(returnValue(-Double.MAX_VALUE));
		}});
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

  /**
  * This class contains a JUnit test case for the `getCumulativePercentages()` method in the `DataUtilities` class.
  * The method calculates cumulative percentages based on the maximum and minimum createNumberArrayValidDataValues provided as a `KeyedValues` object.
  */
	@Test
	public void testGetCumulativePercentagesMaxMin() {
		double[] expected = {0, 1, Double.MAX_VALUE, 1}; // an array of the expected cumulative percentages indexed at each level
		KeyedValues result = DataUtilities.getCumulativePercentages(createNumberArrayValidDataValues); // get the cumulative percentages from the function being tested

		assertEquals(expected.length, result.getItemCount()); // test that the length of the returned result is the same as expected
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], result.getValue(i).doubleValue(), 0.0001); // test each cumulative percentage for each index
		}
	}

	/**
	* The tearDown method is typically employed to release resources such as closing database connections.
	* However, in our scenario, where such connections are absent, we utilize it to nullify variables.
	* While garbage collection handles this automatically, our intention here is to showcase its functionality.
	*/
	@After
	public void tearDown() {
		createNumberArrayValidDataMockKeyed = null;
		createNumberArrayValidDataValues = null;
	}

	@AfterClass public static void setUpAfterClass() throws Exception { }
}
