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
package io.github.astrapi69.time;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.time.enums.DatePattern;

/**
 * The unit test class for the class {@link LocalDateExtensions}
 */
public class LocalDateExtensionsTest
{

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
		expected = Date.valueOf(expectedOutput);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link LocalDateExtensions#toDateString(LocalDate, String)}
	 */
	@Test
	@Disabled
	void testToDateString()
	{
		String actual;
		String expected;
		LocalDate input;
		// new scenario
		input = LocalDate.of(2000, 9, 1);
		actual = LocalDateExtensions.toDateString(input, DatePattern.DDMMM);
		expected = "01Sep.";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.DDMM);
		expected = "0109";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.MMDD);
		expected = "0901";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.MMYY);
		expected = "0900";
		assertEquals(expected, actual);

		// new scenario
		actual = LocalDateExtensions.toDateString(input, DatePattern.YYYY);
		expected = "2000";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link LocalDateExtensions#toDateString(LocalDate, String)}
	 */
	@Test
	@Disabled
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
		System.err.println(actual);
		expected = "01Sep.";
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

}
