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

import static org.testng.AssertJUnit.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.meanbean.factories.ObjectCreationException;
import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.threeten.extra.Interval;

/**
 * The unit test class for the class {@link IntervalExtensions}
 */
public class IntervalExtensionsTest
{

	boolean actual;
	LocalDateTime endDate;

	boolean expected;
	DateTimeFormatter formatter;
	LocalDateTime startDate;
	Interval timeRange;
	Interval timeRangeToCheck;

	/**
	 * Sets up method will be invoked before every unit test method
	 *
	 * @throws Exception
	 *             is thrown if an exception occurs
	 */
	@BeforeMethod
	protected void setUp() throws Exception
	{
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}

	/**
	 * Tear down method will be invoked after every unit test method
	 *
	 * @throws Exception
	 *             is thrown if an exception occurs
	 */
	@AfterMethod
	protected void tearDown() throws Exception
	{
		formatter = null;
	}

	/**
	 * Test method for {@link IntervalExtensions#isBetween(Interval, Interval)}
	 */
	@Test(enabled = true)
	public void testIsBetween()
	{
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
	}

	/**
	 * Test method for {@link IntervalExtensions#isOverlappingAfter(Interval, Interval)}
	 */
	@Test(enabled = true)
	public void testIsOverlappingAfter()
	{
		// new scenario...
		startDate = LocalDate.parse("2019-02-01", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRange = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2019-02-02", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRangeToCheck = Interval.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = IntervalExtensions.isOverlappingAfter(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link IntervalExtensions#isOverlappingBefore(Interval, Interval)}
	 */
	@Test(enabled = true)
	public void testIsOverlappingBefore()
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

		actual = IntervalExtensions.isOverlappingBefore(timeRange, timeRangeToCheck);
		expected = true;
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

		actual = IntervalExtensions.isOverlappingBefore(timeRange, timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link IntervalExtensions#isOverlappingBeforeAndAfter(Interval, Interval)}
	 */
	@Test(enabled = true)
	public void testIsOverlappingBeforeAndAfter()
	{
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

	}

	/**
	 * Test method for {@link IntervalExtensions}
	 */
	@Test(expectedExceptions = { BeanTestException.class, ObjectCreationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(IntervalExtensions.class);
	}

}
