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
package de.alpharogroup.time.convert;

import de.alpharogroup.time.enums.DatePattern;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The unit test class for the class {@link ParseDateExtensions}
 */
public class ParseDateExtensionsTest
{

	/**
	 * Test method for {@link ParseDateExtensions#parse(String, String)} 
	 */
	@Test void parseStringString()
	{
		LocalDateTime actual;
		LocalDateTime expected;
		String stringDate;
		String pattern;
		// new scenario
		stringDate = "21:41, 13.9.2020";
		pattern = "HH:mm, dd.M.yyyy";
		actual = ParseDateExtensions.parse(stringDate, pattern);
		expected = LocalDateTime.of(2020, 9, 13, 21, 41);

		assertEquals(expected, actual);
		// new scenario
		stringDate = "21:41, 13.10.2020";
		actual = ParseDateExtensions.parse(stringDate, pattern);
		expected = LocalDateTime.of(2020, 10, 13, 21, 41);

		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ParseDateExtensions#parse(String, DatePattern)} 
	 */
	@Test void parseStringDatePattern()
	{
		LocalDateTime actual;
		LocalDateTime expected;
		String stringDate;
		String pattern;
		// new scenario
		stringDate = "21:41, 13.9.2020";
		pattern = "HH:mm, dd.M.yyyy";
		actual = ParseDateExtensions.parse(stringDate, DatePattern.DOT_HH_MM_COMMA_DD_M_YYYY);
		expected = LocalDateTime.of(2020, 9, 13, 21, 41);

		assertEquals(expected, actual);
		// new scenario
		stringDate = "21:41, 13.10.2020";
		actual = ParseDateExtensions.parse(stringDate, DatePattern.DOT_HH_MM_COMMA_DD_M_YYYY);
		expected = LocalDateTime.of(2020, 10, 13, 21, 41);

		assertEquals(expected, actual);
	}
}
