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
package io.github.astrapi69.time.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.date.CreateDateExtensions;
import io.github.astrapi69.time.enumtype.DatePattern;

/**
 * The unit test class for the class {@link LocalDateExtensions}
 */
public class LocalDateExtensionsTest
{

	/**
	 * Test method for {@link LocalDateExtensions#toTimestamp(LocalDate)}
	 */
	@Test
	public void testToTimestamp()
	{
		Timestamp actual;
		Timestamp expected;
		LocalDate test;
		test = LocalDate.of(1900, 10, 1);
		actual = LocalDateExtensions.toTimestamp(test);
		expected = Timestamp.valueOf(test.atStartOfDay());
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link LocalDateExtensions#toSqlDate(LocalDate)}
	 */
	@Test
	public void toSqlDate()
	{
		java.sql.Date actual;
		java.sql.Date expected;
		LocalDate input;
		LocalDate expectedOutput;

		input = LocalDate.of(2000, 9, 1);

		actual = LocalDateExtensions.toSqlDate(input);
		expectedOutput = LocalDate.of(2000, 9, 1);
		expected = java.sql.Date.valueOf(expectedOutput);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link LocalDateExtensions#toDateString(LocalDate, String)}
	 */
	@Test
	void testToDateString()
	{
		String actual;
		String expected;
		LocalDate input;
		Locale defaultLocale;
		// new scenario
		defaultLocale = Locale.getDefault();
		// new scenario
		input = LocalDate.of(2000, 9, 1);
		actual = LocalDateExtensions.toDateString(input, DatePattern.DDMMM);
		expected = LocalDateExtensions.toDateString(input, DatePattern.DDMMM.getPattern(),
			defaultLocale);
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.DDMM);
		expected = LocalDateExtensions.toDateString(input, DatePattern.DDMM.getPattern(),
			defaultLocale);
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.MMDD);
		expected = LocalDateExtensions.toDateString(input, DatePattern.MMDD.getPattern(),
			defaultLocale);
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.MMYY);
		expected = LocalDateExtensions.toDateString(input, DatePattern.MMYY.getPattern(),
			defaultLocale);
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.YYYY);
		expected = LocalDateExtensions.toDateString(input, DatePattern.YYYY.getPattern(),
			defaultLocale);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link LocalDateExtensions#toDateString(LocalDate, String)}
	 */
	@Test
	void testToDateStringWithLocale()
	{
		String actual;
		String expected;
		LocalDate input;
		Locale locale;
		// new scenario
		locale = Locale.GERMANY;
		input = LocalDate.of(2000, 9, 1);
		actual = LocalDateExtensions.toDateString(input, DatePattern.DDMMM.getPattern(), locale);
		expected = "01Sept.";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.DDMM.getPattern(), locale);
		expected = "0109";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.MMDD.getPattern(), locale);
		expected = "0901";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.MMYY.getPattern(), locale);
		expected = "0900";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.YYYY.getPattern(), locale);
		expected = "2000";
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link LocalDateExtensions#toDate(LocalDate)}
	 */
	@Test
	void testToDate()
	{

		Date actual;
		Date expected;
		LocalDate input;
		// new scenario
		input = LocalDate.of(2000, 9, 1);
		actual = LocalDateExtensions.toDate(input);
		expected = CreateDateExtensions.newDate(2000, 9, 1, 0, 0, 0);
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link LocalDateExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(LocalDateExtensions.class);
	}

}
