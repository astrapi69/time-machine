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
package io.github.astrapi69.time.gap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

/**
 * The unit test class for the class {@link TimeGapExtensions}
 */
public class TimeGapExtensionsTest
{


	/**
	 * Test method for {@link TimeGapExtensions#isAfterTimeGap(Temporal, Temporal, ChronoUnit)}
	 */
	@Test
	public void testIsAfterTimeGap()
	{
		boolean actual;
		boolean expected;
		Temporal timeStart;
		Temporal timeEnd;
		// new scenario with LocalTime...
		timeStart = LocalTime.of(10, 0);
		timeEnd = LocalTime.of(10, 0);

		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.MINUTES);
		expected = false;
		assertEquals(expected, actual);

		timeEnd = LocalTime.of(10, 1);
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.MINUTES);
		assertEquals(expected, actual);

		timeEnd = LocalTime.of(10, 2);
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.MINUTES);
		expected = true;
		assertEquals(expected, actual);
		// new scenario with LocalTime...
		timeStart = LocalTime.of(10, 0);
		timeEnd = LocalTime.of(10, 30);

		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.HOURS);
		expected = false;
		assertEquals(expected, actual);

		timeEnd = LocalTime.of(11, 0);
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.HOURS);
		assertEquals(expected, actual);

		timeEnd = LocalTime.of(12, 0);
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.HOURS);
		expected = true;
		assertEquals(expected, actual);
		// new scenario with LocalDate...
		timeStart = LocalDate.of(2018, Month.APRIL, 30);
		timeEnd = LocalDate.of(2018, Month.MAY, 1);

		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.DAYS);
		expected = false;
		assertEquals(expected, actual);

		timeEnd = LocalDate.of(2018, Month.APRIL, 29);
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.DAYS);
		assertEquals(expected, actual);

		timeEnd = LocalDate.of(2018, Month.MAY, 2);
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.DAYS);
		expected = true;
		assertEquals(expected, actual);
		// new scenario with LocalDateTime...
		timeStart = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 30), LocalTime.of(10, 0));
		timeEnd = LocalDateTime.of(LocalDate.of(2018, Month.MAY, 1), LocalTime.of(10, 0));

		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.DAYS);
		expected = false;
		assertEquals(expected, actual);

		timeEnd = LocalDateTime.of(LocalDate.of(2018, Month.APRIL, 29), LocalTime.of(10, 0));
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.DAYS);
		assertEquals(expected, actual);

		timeEnd = LocalDateTime.of(LocalDate.of(2018, Month.MAY, 2), LocalTime.of(10, 0));
		actual = TimeGapExtensions.isAfterTimeGap(timeStart, timeEnd, ChronoUnit.DAYS);
		expected = true;
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link TimeGapExtensions#isBeforeTimeGap(Temporal, Temporal, ChronoUnit)}
	 */
	@Test
	public void testIsBeforeTimeGap()
	{
		boolean actual;
		boolean expected;
		Temporal dateStart;
		Temporal dateEnd;

		dateStart = LocalDate.of(2018, Month.AUGUST, 1);
		dateEnd = LocalDate.of(2018, Month.JULY, 31);

		actual = TimeGapExtensions.isBeforeTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = false;
		assertEquals(expected, actual);

		dateEnd = LocalDate.of(2018, Month.AUGUST, 2);
		actual = TimeGapExtensions.isBeforeTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		assertEquals(expected, actual);

		dateEnd = LocalDate.of(2018, Month.JULY, 30);
		actual = TimeGapExtensions.isBeforeTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link TimeGapExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(TimeGapExtensions.class);
	}
}

