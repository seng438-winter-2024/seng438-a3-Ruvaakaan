package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {

	private Range lowerBoundJustBelowMaximumRange;
	private Range lowerBoundAtMinimumRange;
	private Range invalidLengthNaNRange;
	private Range invalidLengthNegativeInfinityRange;
	private Range	invalidLengthPositiveInfinityRange;
	private Range invalidUpperBoundNaNRange;
	private Range invalidLengthAtMinimumRange;
	private Range invalidLengthAtMaximumRange;
	private Range invalidLowerBoundNaNRange;
	private Range lowerBoundJustAboveMinimumRange;
	private Range singlePointLengthRange;
	private Range validWithPositiveLengthRange;
	private Range validUpperBoundRange;
	private Range validLowerBoundRange;
	private Range upperBoundJustAboveMinimumRange;
	private Range upperBoundJustBelowMaximumRange;
	private Range upperBoundAtMaximumRange;

	@BeforeClass public static void setUpBeforeClass() throws Exception { }

	@Before
	public void setUp() {
		lowerBoundJustBelowMaximumRange = new Range(Double.MAX_VALUE/2, Double.MAX_VALUE);
		lowerBoundAtMinimumRange = new Range(-Double.MAX_VALUE, 10.0);
		invalidLengthNaNRange = new Range(Double.NaN, Double.NaN); 
		invalidLengthNegativeInfinityRange = new Range(Double.NEGATIVE_INFINITY, 0.0);
		invalidLengthPositiveInfinityRange = new Range(0.0, Double.POSITIVE_INFINITY);
		invalidUpperBoundNaNRange = new Range(0.0, Double.NaN); 
		invalidLengthAtMinimumRange = new Range(-Double.MAX_VALUE, 0.0);
		invalidLengthAtMaximumRange = new Range(0.0, Double.MAX_VALUE);
		invalidLowerBoundNaNRange = new Range(Double.NaN, 10.0);
		lowerBoundJustAboveMinimumRange = new Range(-Double.MAX_VALUE/2, 10.0);
		singlePointLengthRange = new Range(3.0, 3.0);
		validWithPositiveLengthRange = new Range(0.0, 10.0);
		validUpperBoundRange = new Range(0.0, 10.0);
		validLowerBoundRange = new Range(0.0, 10.0);
		upperBoundJustAboveMinimumRange = new Range(-Double.MAX_VALUE, -Double.MAX_VALUE/2);
		upperBoundJustBelowMaximumRange = new Range(0.0, Double.MAX_VALUE/2);
		upperBoundAtMaximumRange = new Range(0.0, Double.MAX_VALUE);
	}

	/**
	* This method contains a JUnit test case for the `getLowerBound()` method in the `Range` class.
	* It gets a lower bounds near the MAX_VALUE from a `Range` object.
	*/
	@Test
	public void testLowerBoundJustBelowMaximum() {
		// Test whether the lower bound of the Range object is equal to Double.MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the MAX_VALUE.
		// Therefore, we divide the MAX_VALUE by two to give us a number close to the MAX_VALUE.
		assertEquals(Double.MAX_VALUE/2, lowerBoundJustBelowMaximumRange.getLowerBound(), 0.0001); 
	}

	/**
	* This class contains a JUnit test case for the `getLowerBound()` method in the `Range` class.
	* It gets a lower bounds near the -MAX_VALUE from a `Range` object.
	*/
	@Test
	public void testLowerBoundAtMinimum() {
		// Test whether the lower bound of the Range object is equal to -Double.MAX_VALUE.
		assertEquals(-Double.MAX_VALUE, lowerBoundAtMinimumRange.getLowerBound(), 0.0001); 
	}

	/**
  * This class contains a JUnit test case for the `getLength()` method in the `Range` class.
  * The method tests the getting of the length between a NaN lower and upper bound.
  */
	@Test
	public void testInvalidRangeLengthNaN() {
		// Test whether the length of the Range object is NaN.
		assertTrue(Double.isNaN(invalidLengthNaNRange.getLength()));
	}

	/**
	* This class contains a JUnit test case for the `getLength()` method in the `Range` class.
  * The method tests the getting of the length between NEGATIVE_INFINITY and normal value.
	*/
	@Test
	public void testInvalidRangeLengthNegativeInfinity() {
		// Test whether the length of the Range object is Double.POSITIVE_INFINITY.
		assertEquals(Double.POSITIVE_INFINITY, invalidLengthNegativeInfinityRange.getLength(), 0.0001);
	}

	/**
  * This class contains a JUnit test case for the `getLength()` method in the `Range` class.
  * The method tests the getting of the length between a normal value and POSITIVE_INFINITY.
  */
	@Test
	public void testInvalidRangeLengthPositiveInfinityTest() {
		// Test whether the length of the Range object is Double.POSITIVE_INFINITY.
		assertEquals(Double.POSITIVE_INFINITY, invalidLengthPositiveInfinityRange.getLength(), 0.0001);
	}

	/**
  * This class contains a JUnit test case for the `getUpperBound()` method in the `Range` class.
  * The method tests the getting of NaN upper bounds from a `Range` object.
  */
	@Test
	public void testInvalidUpperBoundNaN() {
		// Test whether the upper bound of the Range object is NaN.
		assertEquals(Double.NaN, invalidUpperBoundNaNRange.getUpperBound(), 0.0001);
	}

	/**
  * This class contains a JUnit test case for the `getLength()` method in the `Range` class.
  * The method tests the getting of the length between a -MAX_VALUE and normal value.
  */
	@Test
	public void testInvalidRangeLengthAtMinimumTest() {
		// Test whether the length of the Range object is equal to Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, invalidLengthAtMinimumRange.getLength(), 0.0001);
	}

	/**
  * This class contains a JUnit test case for the `getLength()` method in the `Range` class.
  * The method tests the getting of the length between a normal values and MAX_VALUE.
  */
	@Test
	public void testInvalidRangeLengthAtMaximumTest() {
		// Test whether the length of the Range object is equal to Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, invalidLengthAtMaximumRange.getLength(), 0.0001);
	}

	/**
  * This class contains a JUnit test case for the `getLowerBound()` method in the `Range` class.
  * The method tests the getting of a NaN lower bound in a `Range` object.
  */
	@Test
	public void testInvalidLowerBoundNaN() {
		// Test whether the lower bound of the Range object is NaN as expected.
		assertEquals(Double.NaN, invalidLowerBoundNaNRange.getLowerBound(), 0.0001);
	}

	/**
	* This class contains a JUnit test case for the `getLowerBound()` method in the `Range` class.
	* The method tests the getting of a value near the -MAX_VALUE in the `Range` object.
	*/
	@Test
	public void testLowerBoundJustAboveMinimum() {
		// Test whether the lower bound of the Range object is equal to -MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the -MAX_VALUE.
		// Therefore, we divide the -MAX_VALUE by two to give us a number close to the -MAX_VALUE.
		assertEquals(-Double.MAX_VALUE/2, lowerBoundJustAboveMinimumRange.getLowerBound(), 0.0001);
	}
	
	/**
  * This class contains a JUnit test case for the `getLength()` method in the `Range` class.
  * The method tests the getting of the length between two equal points in a `Range` object.
  */
	@Test
	public void testSinglePointRangeLength() {
		// Test whether the length of the Range object is 0.0.
		assertEquals(0.0, singlePointLengthRange.getLength(), 0.0001);
	}

	/**
  * This class contains a JUnit test case for the `getLength()` method in the `Range` class.
  * The method tests the length between two normal points in a `Range` object.
  */
	@Test
	public void testValidRangeWithPositiveLength() {
		// Test whether the length of the Range object is equal to 10.0.
		assertEquals(10.0, validWithPositiveLengthRange.getLength(), 0.0001); 
	}

	/**
  * This class contains a JUnit test case for the `getUpperBound()` method in the `Range` class.
  * The method tests the getting of a normal value in a `Range` object.
  */
	@Test
	public void testValidUpperBound() {
		// Test whether the upper bound of the Range object is equal to 10.0.
		assertEquals(10.0, validUpperBoundRange.getUpperBound(), 0.0001); 
	}

	/**
  * This class contains a JUnit test case for the `getLowerBound()` method in the `Range` class.
  * The method tests the getting of a normal value in the `Range` object.
  */
	@Test
	public void testValidLowerBound() {
		// Test whether the lower bound of the Range object is equal to 0.0.
		assertEquals(0.0, validLowerBoundRange.getLowerBound(), 0.0001); 
	}

	/**
  * This class contains a JUnit test case for the `getUpperBound()` method in the `Range` class.
  * The method tests the getting of value near the -MAX_VALUE in the `Range` object.
  */
	@Test
	public void testUpperBoundJustAboveMinimum() {
		// Test whether the upper bound of the Range object is equal to -MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the -MAX_VALUE.
		// Therefore, we divide the -MAX_VALUE by two to give us a number close to the -MAX_VALUE.
		assertEquals(-Double.MAX_VALUE/2, upperBoundJustAboveMinimumRange.getUpperBound(), 0.0001); 
	}

	/**
  * This class contains a JUnit test case for the `getUpperBound()` method in the `Range` class.
  * The method tests the getting of value near the MAX_VALUE in the `Range` object.
  */
	@Test
	public void testUpperBoundJustBelowMaximum() {
		// Test whether the upper bound of the Range object is equal to MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the MAX_VALUE.
		// Therefore, we divide the MAX_VALUE by two to give us a number close to the MAX_VALUE.
		assertEquals(Double.MAX_VALUE/2, upperBoundJustBelowMaximumRange.getUpperBound(), 0.0001); 
	}

	/**
  * This class contains a JUnit test case for the `getUpperBound()` method in the `Range` class.
  * The method tests the getting of MAX_VALUE in the `Range` object.
  */
	@Test
	public void testUpperBoundAtMaximum() {
		// Test whether the upper bound of the Range object is equal to Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, upperBoundAtMaximumRange.getUpperBound(), 0.0001);
	}

	/**
	* The tearDown method is typically employed to release resources such as closing database connections.
	* However, in our scenario, where such connections are absent, we utilize it to nullify variables.
	* While garbage collection handles this automatically, our intention here is to showcase its functionality.
	*/
	@After
	public void tearDown() {
		lowerBoundJustBelowMaximumRange = null;
		lowerBoundAtMinimumRange = null;
		invalidLengthNaNRange = null;
		invalidLengthNegativeInfinityRange = null;
		invalidLengthPositiveInfinityRange = null;
		invalidUpperBoundNaNRange = null;
		invalidLengthAtMinimumRange = null;
		invalidLengthAtMaximumRange = null;
		invalidLowerBoundNaNRange = null;
		lowerBoundJustAboveMinimumRange = null;
		singlePointLengthRange = null;
		validWithPositiveLengthRange = null;
		validUpperBoundRange = null;
		validLowerBoundRange = null;
		upperBoundJustAboveMinimumRange = null;
		upperBoundJustBelowMaximumRange = null;
		upperBoundAtMaximumRange = null;
	}

	@AfterClass public static void setUpAfterClass() throws Exception { }
}
