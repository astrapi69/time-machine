/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.time.interval;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.threeten.extra.Interval;

/**
 * The unit test class for the class {@link IntervalExtensions}
 */
public class IntervalExtensionsTest
{

	private boolean actual;
	private LocalDateTime endDate;

	private boolean expected;
	private DateTimeFormatter formatter;
	private LocalDateTime startDate;
	private Interval timeRange;
	private Interval timeRangeToCheck;

	/**
	 * Sets up method will be invoked before every unit test method
	 *
	 * @throws Exception
	 *             is thrown if an exception occurs
	 */
	@BeforeEach
	protected void setUp()
	{
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}

	/**
	 * Tear down method will be invoked after every unit test method
	 *
	 * @throws Exception
	 *             is thrown if an exception occurs
	 */
	@AfterEach
	protected void tearDown()
	{
		formatter = null;
	}

	/**
	 * Test method for {@link IntervalExtensions#isAfter(Interval, Interval)}
	 */
	@Test
	public void testIsAfter()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isAfter(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link IntervalExtensions#isBefore(Interval, Interval)}
	 */
	@Test
	public void testIsBefore()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isBefore(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link IntervalExtensions#isBetween(Interval, Interval)}
	 */
	@Test
	public void testIsBetween()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-08", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-10", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isBetween(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		// new scenario...
		startDate = LocalDate.parse("2007-11-08", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-07", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isBetween(timeRange, timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link IntervalExtensions#isBorderingOnEndToStart(Interval, Interval)}
	 */
	@Test
	public void testIsBorderingOnEndToStart()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isBorderingOnEndToStart(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link IntervalExtensions#isBorderingOnStartToEnd(Interval, Interval)}
	 */
	@Test
	public void testIsBorderingOnStartToEnd()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isBorderingOnStartToEnd(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link IntervalExtensions#isEqual(Interval, Interval)}
	 */
	@Test
	public void testIsEqual()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isEqual(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.equals(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link IntervalExtensions#isLargerAndOverlappingAndBorderingOnEnd(Interval, Interval)}
	 */
	@Test
	public void testIsLargerAndOverlappingAndBorderingOnEnd()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-05", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isLargerAndOverlappingAndBorderingOnEnd(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link IntervalExtensions#isLargerAndOverlappingAndBorderingOnStart(Interval, Interval)}
	 */
	@Test
	public void testIsLargerAndOverlappingAndBorderingOnStart()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(3, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isLargerAndOverlappingAndBorderingOnStart(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link IntervalExtensions#isOverlappingAfter(Interval, Interval)}
	 */
	@Test
	public void testIsOverlappingAfter()
	{
		// new scenario...
		startDate = LocalDate.parse("2019-02-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2019-01-31", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isOverlappingAfter(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isConnected(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		assertEquals(actual, expected);
		// new scenario...
		startDate = LocalDate.parse("2019-02-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2019-03-31", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isOverlappingAfter(timeRange, timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isConnected(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link IntervalExtensions#isOverlappingBefore(Interval, Interval)}
	 */
	@Test
	public void testIsOverlappingBefore()
	{
		// new scenario...
		startDate = LocalDate.parse("2019-02-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2019-02-02", formatter).atStartOfDay();
		endDate = startDate.plus(3, ChronoUnit.MONTHS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isOverlappingBefore(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isConnected(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link IntervalExtensions#isOverlappingBeforeAndAfter(Interval, Interval)}
	 */
	@Test
	public void testIsOverlappingBeforeAndAfter()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-10-01", formatter).atStartOfDay();
		endDate = startDate.plus(3, ChronoUnit.MONTHS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isOverlappingBeforeAndAfter(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isConnected(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for
	 * {@link IntervalExtensions#isSmallerAndOverlappingAndBorderingOnEnd(Interval, Interval)}
	 */
	@Test
	public void testIsSmallerAndOverlappingAndBorderingOnEnd()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isSmallerAndOverlappingAndBorderingOnEnd(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link IntervalExtensions#isSmallerAndOverlappingAndBorderingOnStart(Interval, Interval)}
	 */
	@Test
	public void testIsSmallerAndOverlappingAndBorderingOnStart()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isSmallerAndOverlappingAndBorderingOnStart(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.abuts(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link IntervalExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(IntervalExtensions.class);
	}

}
