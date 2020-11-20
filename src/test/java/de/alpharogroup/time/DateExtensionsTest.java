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
package de.alpharogroup.time;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

import de.alpharogroup.date.CreateDateExtensions;

/**
 * The unit test class for the class {@link DateExtensions}
 */
public class DateExtensionsTest
{

	/**
	 * Test method for {@link DateExtensions#toLocalDateTime(Date, ZoneId)}
	 */
	@Test
	void toLocalDateTime()
	{
		LocalDateTime actual;
		LocalDateTime expected;
		Date date;

		// new scenario
		date = CreateDateExtensions.newDate(2000, 9, 1);
		actual = DateExtensions.toLocalDateTime(date, ZoneId.systemDefault());
		expected = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DateExtensions#toLocalDate(Date, ZoneId)}
	 */
	@Test
	void toLocalDate()
	{
		LocalDate actual;
		LocalDate expected;
		Date date;

		// new scenario
		date = CreateDateExtensions.newDate(2000, 9, 1);
		actual = DateExtensions.toLocalDate(date, ZoneId.systemDefault());
		expected = LocalDate.of(2000, 9, 1);
		assertEquals(expected, actual);
	}
}
