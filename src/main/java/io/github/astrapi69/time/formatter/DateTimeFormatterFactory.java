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
package io.github.astrapi69.time.formatter;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import io.github.astrapi69.time.enumtype.DatePattern;

/**
 * The factory class {@link DateTimeFormatterFactory} provides methods for create
 * {@link DateTimeFormatter} objects
 */
public final class DateTimeFormatterFactory
{
	private DateTimeFormatterFactory()
	{
	}

	/**
	 * Factory method for create a new {@link DateTimeFormatter} object from the given string
	 * pattern
	 * 
	 * @param pattern
	 *            the pattern
	 * @return the new {@link DateTimeFormatter} object
	 */
	public static DateTimeFormatter newDateTimeFormatter(String pattern)
	{
		return newDateTimeFormatter(pattern, Locale.getDefault());
	}

	/**
	 * Factory method for create a new {@link DateTimeFormatter} object from the given string
	 * pattern and locale
	 * 
	 * @param pattern
	 *            the pattern
	 * @param locale
	 *            the locale
	 * @return the new {@link DateTimeFormatter} object
	 */
	public static DateTimeFormatter newDateTimeFormatter(String pattern, Locale locale)
	{
		return DateTimeFormatter.ofPattern(pattern, locale);
	}

	/**
	 * Factory method for create a new {@link DateTimeFormatter} object from the given string
	 * pattern and default locale
	 * 
	 * @param pattern
	 *            the pattern
	 * @return the new {@link DateTimeFormatter} object
	 */
	public static DateTimeFormatter newDateTimeFormatter(DatePattern pattern)
	{
		return newDateTimeFormatter(pattern.getPattern(), Locale.getDefault());
	}

}
