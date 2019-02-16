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
package de.alpharogroup.time.gap;

import static org.testng.AssertJUnit.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.meanbean.factories.ObjectCreationException;
import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link TimeGapExtensions}
 */
public class TimeGapExtensionsTest
{

	/**
	 * Test method for {@link TimeGapExtensions#isAfterTimeGap(LocalDate, LocalDate, ChronoUnit)}
	 */
	@Test
	public void testIsAfterTimeGap()
	{
		boolean actual;
		boolean expected;
		LocalDate dateStart;
		LocalDate dateEnd;

		dateStart = LocalDate.of(2018, Month.APRIL, 30);
		dateEnd = LocalDate.of(2018, Month.MAY, 1);

		actual = TimeGapExtensions.isAfterTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = false;
		assertEquals(expected, actual);

		dateEnd = LocalDate.of(2018, Month.APRIL, 29);
		actual = TimeGapExtensions.isAfterTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = false;
		assertEquals(expected, actual);

		dateEnd = LocalDate.of(2018, Month.MAY, 2);
		actual = TimeGapExtensions.isAfterTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link TimeGapExtensions#isBeforeTimeGap(LocalDate, LocalDate, ChronoUnit)}
	 */
	@Test
	public void testIsBeforeTimeGap()
	{
		boolean actual;
		boolean expected;
		LocalDate dateStart;
		LocalDate dateEnd;

		dateStart = LocalDate.of(2018, Month.AUGUST, 1);
		dateEnd = LocalDate.of(2018, Month.JULY, 31);

		actual = TimeGapExtensions.isBeforeTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = false;
		assertEquals(expected, actual);

		dateEnd = LocalDate.of(2018, Month.AUGUST, 2);
		actual = TimeGapExtensions.isBeforeTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = false;
		assertEquals(expected, actual);

		dateEnd = LocalDate.of(2018, Month.JULY, 30);
		actual = TimeGapExtensions.isBeforeTimeGap(dateStart, dateEnd, ChronoUnit.DAYS);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link TimeGapExtensions}
	 */
	@Test(expectedExceptions = { BeanTestException.class, ObjectCreationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(TimeGapExtensions.class);
	}
}

