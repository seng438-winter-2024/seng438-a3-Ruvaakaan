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
	private Range invalidLengthPositiveInfinityRange;
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
	private Range pointRangeAtZero;
	private Range maxSizeRange;
	private Range rangeZeroToFive;
	private Range rangeFiveToTen;
	private Range rangeTwoToEight;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() {
		lowerBoundJustBelowMaximumRange = new Range(Double.MAX_VALUE / 2, Double.MAX_VALUE);
		lowerBoundAtMinimumRange = new Range(-Double.MAX_VALUE, 10.0);
		invalidLengthNaNRange = new Range(Double.NaN, Double.NaN);
		invalidLengthNegativeInfinityRange = new Range(Double.NEGATIVE_INFINITY, 0.0);
		invalidLengthPositiveInfinityRange = new Range(0.0, Double.POSITIVE_INFINITY);
		invalidUpperBoundNaNRange = new Range(0.0, Double.NaN);
		invalidLengthAtMinimumRange = new Range(-Double.MAX_VALUE, 0.0);
		invalidLengthAtMaximumRange = new Range(0.0, Double.MAX_VALUE);
		invalidLowerBoundNaNRange = new Range(Double.NaN, 10.0);
		lowerBoundJustAboveMinimumRange = new Range(-Double.MAX_VALUE / 2, 10.0);
		singlePointLengthRange = new Range(3.0, 3.0);
		validWithPositiveLengthRange = new Range(0.0, 10.0);
		validUpperBoundRange = new Range(0.0, 10.0);
		validLowerBoundRange = new Range(0.0, 10.0);
		upperBoundJustAboveMinimumRange = new Range(-Double.MAX_VALUE, -Double.MAX_VALUE / 2);
		upperBoundJustBelowMaximumRange = new Range(0.0, Double.MAX_VALUE / 2);
		upperBoundAtMaximumRange = new Range(0.0, Double.MAX_VALUE);
		pointRangeAtZero = new Range(0, 0);
		maxSizeRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
		rangeZeroToFive = new Range(0, 5);
		rangeFiveToTen = new Range(5, 10);
		rangeTwoToEight = new Range(2, 8);
	}

	/**
	 * This method contains a JUnit test case for the `getLowerBound()` method in
	 * the `Range` class.
	 * It gets a lower bounds near the MAX_VALUE from a `Range` object.
	 */
	@Test
	public void testLowerBoundJustBelowMaximum() {
		// Test whether the lower bound of the Range object is equal to
		// Double.MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// MAX_VALUE.
		// Therefore, we divide the MAX_VALUE by two to give us a number close to the
		// MAX_VALUE.
		assertEquals(Double.MAX_VALUE / 2, lowerBoundJustBelowMaximumRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * It gets a lower bounds near the -MAX_VALUE from a `Range` object.
	 */
	@Test
	public void testLowerBoundAtMinimum() {
		// Test whether the lower bound of the Range object is equal to
		// -Double.MAX_VALUE.
		assertEquals(-Double.MAX_VALUE, lowerBoundAtMinimumRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a NaN lower and upper
	 * bound.
	 */
	@Test
	public void testInvalidRangeLengthNaN() {
		// Test whether the length of the Range object is NaN.
		assertTrue(Double.isNaN(invalidLengthNaNRange.getLength()));
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between NEGATIVE_INFINITY and
	 * normal value.
	 */
	@Test
	public void testInvalidRangeLengthNegativeInfinity() {
		// Test whether the length of the Range object is Double.POSITIVE_INFINITY.
		assertEquals(Double.POSITIVE_INFINITY, invalidLengthNegativeInfinityRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a normal value and
	 * POSITIVE_INFINITY.
	 */
	@Test
	public void testInvalidRangeLengthPositiveInfinityTest() {
		// Test whether the length of the Range object is Double.POSITIVE_INFINITY.
		assertEquals(Double.POSITIVE_INFINITY, invalidLengthPositiveInfinityRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of NaN upper bounds from a `Range` object.
	 */
	@Test
	public void testInvalidUpperBoundNaN() {
		// Test whether the upper bound of the Range object is NaN.
		assertEquals(Double.NaN, invalidUpperBoundNaNRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a -MAX_VALUE and normal
	 * value.
	 */
	@Test
	public void testInvalidRangeLengthAtMinimumTest() {
		// Test whether the length of the Range object is equal to Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, invalidLengthAtMinimumRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between a normal values and
	 * MAX_VALUE.
	 */
	@Test
	public void testInvalidRangeLengthAtMaximumTest() {
		// Test whether the length of the Range object is equal to Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, invalidLengthAtMaximumRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a NaN lower bound in a `Range` object.
	 */
	@Test
	public void testInvalidLowerBoundNaN() {
		// Test whether the lower bound of the Range object is NaN as expected.
		assertEquals(Double.NaN, invalidLowerBoundNaNRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a value near the -MAX_VALUE in the `Range`
	 * object.
	 */
	@Test
	public void testLowerBoundJustAboveMinimum() {
		// Test whether the lower bound of the Range object is equal to -MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// -MAX_VALUE.
		// Therefore, we divide the -MAX_VALUE by two to give us a number close to the
		// -MAX_VALUE.
		assertEquals(-Double.MAX_VALUE / 2, lowerBoundJustAboveMinimumRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the getting of the length between two equal points in a
	 * `Range` object.
	 */
	@Test
	public void testSinglePointRangeLength() {
		// Test whether the length of the Range object is 0.0.
		assertEquals(0.0, singlePointLengthRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLength()` method in the
	 * `Range` class.
	 * The method tests the length between two normal points in a `Range` object.
	 */
	@Test
	public void testValidRangeWithPositiveLength() {
		// Test whether the length of the Range object is equal to 10.0.
		assertEquals(10.0, validWithPositiveLengthRange.getLength(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a normal value in a `Range` object.
	 */
	@Test
	public void testValidUpperBound() {
		// Test whether the upper bound of the Range object is equal to 10.0.
		assertEquals(10.0, validUpperBoundRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getLowerBound()` method in the
	 * `Range` class.
	 * The method tests the getting of a normal value in the `Range` object.
	 */
	@Test
	public void testValidLowerBound() {
		// Test whether the lower bound of the Range object is equal to 0.0.
		assertEquals(0.0, validLowerBoundRange.getLowerBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of value near the -MAX_VALUE in the `Range`
	 * object.
	 */
	@Test
	public void testUpperBoundJustAboveMinimum() {
		// Test whether the upper bound of the Range object is equal to -MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// -MAX_VALUE.
		// Therefore, we divide the -MAX_VALUE by two to give us a number close to the
		// -MAX_VALUE.
		assertEquals(-Double.MAX_VALUE / 2, upperBoundJustAboveMinimumRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of value near the MAX_VALUE in the `Range`
	 * object.
	 */
	@Test
	public void testUpperBoundJustBelowMaximum() {
		// Test whether the upper bound of the Range object is equal to MAX_VALUE/2.
		// Precision doesn't allow us to add or subtract small numbers from the
		// MAX_VALUE.
		// Therefore, we divide the MAX_VALUE by two to give us a number close to the
		// MAX_VALUE.
		assertEquals(Double.MAX_VALUE / 2, upperBoundJustBelowMaximumRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `getUpperBound()` method in the
	 * `Range` class.
	 * The method tests the getting of MAX_VALUE in the `Range` object.
	 */
	@Test
	public void testUpperBoundAtMaximum() {
		// Test whether the upper bound of the Range object is equal to
		// Double.MAX_VALUE.
		assertEquals(Double.MAX_VALUE, upperBoundAtMaximumRange.getUpperBound(), 0.0001);
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * This test tests the method with an input that is just above the lower bound
	 * in the 'Range' instance.
	 */
	@Test
	public void testContainsAboveLowerBound() {
		assertTrue(validWithPositiveLengthRange.contains(0.001)); // Value just above the Lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just above the upper bound in
	 * the 'Range' instance.
	 */
	@Test
	public void testContainsAboveUpperBound() {
		assertFalse(validWithPositiveLengthRange.contains(10.001)); // Value just above the upper bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the lower bound
	 * in the 'Range' instance.
	 */
	@Test
	public void testContainsAtLowerBound() {
		assertTrue(validWithPositiveLengthRange.contains(0)); // Value at the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the upper bound
	 * in the 'Range' instance.
	 */
	@Test
	public void testContainsAtUpperBound() {
		assertTrue(validWithPositiveLengthRange.contains(10)); // Value at the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just below the lower bound in
	 * the 'Range' instance.
	 */
	@Test
	public void testContainsBelowLowerBound() {
		assertFalse(validWithPositiveLengthRange.contains(-0.001)); // Value below the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just below the upper bound in
	 * the 'Range' instance.
	 */
	@Test
	public void testContainsBelowUpperBound() {
		assertTrue(validWithPositiveLengthRange.contains(9.999)); // Value below the upper bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just above the upper bound of
	 * the range, but where the lower and upper bounds are equivalent
	 */
	@Test
	public void testContainsInputAboveRangeOfZero() {
		assertFalse(pointRangeAtZero.contains(1)); // Value above the range
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the lower and
	 * upper bounds of the range, where the lower and upper bounds are equivalent
	 */

	@Test
	public void testContainsInputAtBoundOfZeroRange() {
		assertTrue(range.contains(0)); // Value at the point range
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is just below the lower bound of
	 * the range, but where the lower and upper bounds are equivalent
	 */
	@Test
	public void testContainsInputBelowRangeOfZero() {
		assertFalse(pointRangeAtZero.contains(-1)); // Value below the range
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the upper
	 * bound, where both equal Double.MAX_VALUE
	 */
	@Test
	public void testContainsMaxRangeValueAtUpperBound() {
		assertTrue(upperBoundAtMaximumRange.contains(Double.MAX_VALUE)); // Value at the upper bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is equivalent to the upper
	 * bound, where both equal -Double.MAX_VALUE
	 */
	@Test
	public void testContainsMinRangeValueAtLowerBound() {
		assertTrue(lowerBoundAtMinimumRange.contains(Double.MAX_VALUE * -1)); // Value at the lower bound
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is greater than the lower bound
	 * of the range and less than the upper bound of the range
	 */
	@Test
	public void testContainsWithinBounds() {
		assertTrue(validWithPositiveLengthRange.contains(5)); // Value within the bounds
	}

	/**
	 * This class contains a JUnit test case for the `contains` method in the
	 * `Range` class.
	 * The test tests the method with an input that is greater than the lower bound
	 * of the range and less than the upper bound of the range,
	 * where the lower and upper bounds are -Double.MAX_VALUE and Double.MAX_VALUE
	 * respectively.
	 */

	@Test
	public void testContainsWithinBoundsMaxSizeRange() {
		assertTrue(maxSizeRange.contains(0)); // Value within the bounds
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that intersects the 'Range' instance
	 * only at the ranges lower bound.
	 */
	@Test
	public void testIntersectsCommonBoundaryLeft() {
		// Range intersects with input at 5
		assertTrue(rangeFiveToTen.intersects(0, 5));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that intersects the 'Range' instance
	 * only at the ranges upper bound.
	 */
	@Test
	public void testIntersectsCommonBoundaryRight() {
		// Range intersects with input at 5
		assertTrue(rangeZeroToFive.intersects(5, 10));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that is fully within a range that is
	 * the maximum size.
	 */
	@Test
	public void testIntersectsInputInsideMaxSizeRange() {
		// Input fully enclosed by bounds of range
		assertTrue(maxSizeRange.intersects(-100, 100));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input that is fully within the 'Range'
	 * instance.
	 */
	@Test
	public void testIntersectsInputInsideRange() {
		// Input fully enclosed by bounds of range
		assertTrue(validWithPositiveLengthRange.intersects(2, 5));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input upper bound is
	 * less than the 'Range' instance lower bound.
	 */
	@Test
	public void testIntersectsMissLeft() {
		// Upper bound of input doesn't intersect with lower bound of range
		assertFalse(rangeFiveToTen.intersects(0, 4));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input lower bound is
	 * more than the 'Range' instances upper bound.
	 */

	@Test
	public void testIntersectsMissRight() {
		// Lower bound of input doesn't intersect with upper bound of range
		assertFalse(rangeZeroToFive.intersects(10, 20));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input upper bound is
	 * greater than the 'Range' instances lower bound,
	 * however the input lower bound is still less than the 'Range' instances lower
	 * bound, hence a partial overlap.
	 */

	@Test
	public void testIntersectsPartialOverlapLeft() {
		// Partial Overlap on the left side of the range with the input
		assertTrue(rangeZeroToFive.intersects(3, 7));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the input lower bound is
	 * less than the 'Range' instances upper bound,
	 * however the input upper bound is still more than the 'Range' instances upper
	 * bound, hence a partial overlap.
	 */
	@Test
	public void testIntersectsPartialOverlapRight() {
		// Partial Overlap on the left side of the range with the input
		assertTrue(rangeFiveToTen.intersects(8, 12));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range that entirely encompasses the
	 * lower and upper bounds of the 'Range' instance,
	 * however the lower and upper bounds of the 'Range' instance are equivalent.
	 */
	@Test
	public void testIntersectsPointRangeInsideInput() {
		// Single point range enclosed by input
		assertTrue(pointRangeAtZero.intersects(-2, 2));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the lower and upper
	 * bounds for the input range are the same,
	 * which are equal to the lower and upper bounds of the 'Range' instance.
	 */

	@Test
	public void testIntersectsPointRangePointInputHit() {
		// Point range equivalent to input point range
		assertTrue(pointRangeAtZero.intersects(0, 0));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the lower and upper
	 * bounds for the input range are the same.
	 * The 'Range' instance is also a range where the lower and upper bounds are
	 * equivalent. In this case, the 'Range'
	 * instances lower and upper bounds are more than those input into the function.
	 */
	@Test
	public void testIntersectsPointRangePointInputMissLeft() {
		// Point range at 0 point range at -1 to the left
		assertFalse(pointRangeAtZero.intersects(-1, -1));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range where the lower and upper
	 * bounds for the input range are the same.
	 * The 'Range' instance is also a range where the lower and upper bounds are
	 * equivalent. In this case, the 'Range'
	 * instances lower and upper bounds are less than those input into the function.
	 */

	@Test
	public void testIntersectsPointRangePointInputMissRight() {
		// Point range at 0 misses point range at 1 to the right
		assertFalse(pointRangeAtZero.intersects(1, 1));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range that fully encloses the 'Range'
	 * instances
	 * lower and upper bounds.
	 */

	@Test
	public void testIntersectsRangeInsideInput() {
		// Input fully encompasses range
		assertTrue(rangeTwoToEight.intersects(0, 10));
	}

	/**
	 * This class contains a JUnit test case for the `intersects` method in the
	 * `Range` class.
	 * The test tests the method with an input range that is from the most negative
	 * to most positive number,
	 * where the 'Range' instances lower and upper bounds are fully within this
	 * input range.
	 */
	@Test
	public void testIntersectsRangeInsideMaxSizeInput() {
		// range intersects with largest possible input range
		assertTrue(validWithPositiveLengthRange.intersects(-1 * Double.MAX_VALUE, Double.MAX_VALUE));
	}

	/**
	 * The tearDown method is typically employed to release resources such as
	 * closing database connections.
	 * However, in our scenario, where such connections are absent, we utilize it to
	 * nullify variables.
	 * While garbage collection handles this automatically, our intention here is to
	 * showcase its functionality.
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
		pointRangeAtZero = null;
		maxSizeRange = null;
		rangeZeroToFive = null;
		rangeFiveToTen = null;
		rangeTwoToEight = null;
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
	}
}
