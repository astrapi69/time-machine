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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import de.alpharogroup.time.enums.DatePattern;

/**
 * The class {@link ParseDateExtensions} provides methods for parse a date {@link String} objects to
 * the new time objects
 */
public final class ParseDateExtensions
{

	/**
	 * Parses the String date to a {@link LocalDateTime} object
	 *
	 * @param stringDate
	 *            The Date as String
	 * @param pattern
	 *            The pattern for the Date to parse
	 * @return The parsed {@link LocalDateTime} object
	 */
	public static LocalDateTime parse(String stringDate, String pattern)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime localDateTime = LocalDateTime.parse(stringDate, formatter);
		return localDateTime;
	}

	/**
	 * Parses the String date to a {@link LocalDateTime} object
	 *
	 * @param stringDate
	 *            The Date as String
	 * @param pattern
	 *            The pattern for the Date to parse
	 * @return The parsed {@link LocalDateTime} object
	 */
	public static LocalDateTime parse(String stringDate, DatePattern pattern)
	{
		return parse(stringDate, pattern.getPattern());
	}

}
