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
package io.github.astrapi69.time.period;

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

import io.github.astrapi69.time.period.model.Period;

/**
 * The unit test class for the class {@link PeriodExtensionsTest}
 */
public class PeriodExtensionsTest
{

	private boolean actual;
	private LocalDateTime endDate;

	private boolean expected;
	private DateTimeFormatter formatter;
	private LocalDateTime startDate;
	private Period timeRange;
	private Period timeRangeToCheck;

	/**
	 * Sets up method will be invoked before every unit test method
	 */
	@BeforeEach
	protected void setUp()
	{
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}

	/**
	 * Tear down method will be invoked after every unit test method
	 */
	@AfterEach
	protected void tearDown()
	{
		formatter = null;
	}

	/**
	 * Test method for {@link PeriodExtensions#isAfter(Period, Period)}
	 */
	@Test
	public void testIsAfter()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isAfter(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isAfter(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * Test method for {@link PeriodExtensions#isBefore(Period, Period)}
	 */
	@Test
	public void testIsBefore()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isBefore(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isBefore(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for {@link PeriodExtensions#isBetween(Period, Period)}
	 */
	@Test
	public void testIsBetween()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-08", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-10", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isBetween(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-07", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isBetween(timeRange, timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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

		// new scenario...
		startDate = LocalDate.parse("2007-11-08", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-07", formatter).atStartOfDay();
		endDate = startDate.plus(10, ChronoUnit.MONTHS);
		// timeRangeToCheck => 2007-11-07 till 2008-09-07
		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isBetween(timeRange, timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * Test method for {@link PeriodExtensions#isBorderingOnEndToStart(Period, Period)}
	 */
	@Test
	public void testIsBorderingOnEndToStart()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isBorderingOnEndToStart(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * Test method for {@link PeriodExtensions#isBorderingOnStartToEnd(Period, Period)}
	 */
	@Test
	public void testIsBorderingOnStartToEnd()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isBorderingOnStartToEnd(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * Test method for {@link PeriodExtensions#isEqual(Period, Period)}
	 */
	@Test
	public void testIsEqual()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isEqual(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.equals(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.encloses(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * {@link PeriodExtensions#isLargerAndOverlappingAndBorderingOnEnd(Period, Period)}
	 */
	@Test
	public void testIsLargerAndOverlappingAndBorderingOnEnd()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-05", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isLargerAndOverlappingAndBorderingOnEnd(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * {@link PeriodExtensions#isLargerAndOverlappingAndBorderingOnStart(Period, Period)}
	 */
	@Test
	public void testIsLargerAndOverlappingAndBorderingOnStart()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(3, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isLargerAndOverlappingAndBorderingOnStart(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * Test method for {@link PeriodExtensions#isOverlappingAfter(Period, Period)}
	 */
	@Test
	public void testIsOverlappingAfter()
	{
		// new scenario...
		startDate = LocalDate.parse("2019-02-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2019-01-31", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isOverlappingAfter(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isConnected(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		assertEquals(actual, expected);
		// new scenario...
		startDate = LocalDate.parse("2019-02-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2019-03-31", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isOverlappingAfter(timeRange, timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

		actual = timeRange.isConnected(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link PeriodExtensions#isOverlappingBefore(Period, Period)}
	 */
	@Test
	public void testIsOverlappingBefore()
	{
		// new scenario...
		startDate = LocalDate.parse("2019-02-01", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.MONTHS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2019-02-02", formatter).atStartOfDay();
		endDate = startDate.plus(3, ChronoUnit.MONTHS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isOverlappingBefore(timeRange, timeRangeToCheck);
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
	 * Test method for {@link PeriodExtensions#isOverlappingBeforeAndAfter(Period, Period)}
	 */
	@Test
	public void testIsOverlappingBeforeAndAfter()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-01", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.MONTHS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-10-01", formatter).atStartOfDay();
		endDate = startDate.plus(3, ChronoUnit.MONTHS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isOverlappingBeforeAndAfter(timeRange, timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.isConnected(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.overlaps(timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
		expected = false;
		assertEquals(actual, expected);

	}

	/**
	 * Test method for
	 * {@link PeriodExtensions#isSmallerAndOverlappingAndBorderingOnEnd(Period, Period)}
	 */
	@Test
	public void testIsSmallerAndOverlappingAndBorderingOnEnd()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isSmallerAndOverlappingAndBorderingOnEnd(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * {@link PeriodExtensions#isSmallerAndOverlappingAndBorderingOnStart(Period, Period)}
	 */
	@Test
	public void testIsSmallerAndOverlappingAndBorderingOnStart()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		startDate = LocalDate.parse("2007-11-04", formatter).atStartOfDay();
		endDate = startDate.plus(2, ChronoUnit.DAYS);

		timeRangeToCheck = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = PeriodExtensions.isSmallerAndOverlappingAndBorderingOnStart(timeRange,
			timeRangeToCheck);
		expected = true;
		assertEquals(actual, expected);

		actual = timeRange.adjoins(timeRangeToCheck);
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
	 * Test method for {@link PeriodExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(PeriodExtensions.class);
	}

}
