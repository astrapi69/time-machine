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

import io.github.astrapi69.time.enumtype.DatePattern;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * The class {@link LocalDateExtensions} provides methods for convert {@link LocalDate} objects
 */
public class LocalDateExtensions
{

	/**
	 * Converts the given {@link LocalDate} to a {@link Timestamp} object
	 *
	 * @param localDate
	 *            The {@link LocalDate} to convert
	 * @return The {@link Timestamp} object from the {@link LocalDate}
	 */
	public static Timestamp toTimestamp(LocalDate localDate)
	{
		return Timestamp.valueOf(localDate.atStartOfDay());
	}

	/**
	 * Converts the given {@link Date} with the given {@link ZoneId} to a {@link LocalDate} object
	 *
	 * @param date
	 *            the date
	 * @param zone
	 *            the zone
	 * @return The {@link LocalDate} object
	 */
	public static LocalDate toLocalDate(Date date, ZoneId zone)
	{
		return date.toInstant().atZone(zone).toLocalDate();
	}

	/**
	 * Converts the given {@link LocalDate} to a {@link java.sql.Date} object
	 *
	 * @param localDate
	 *            the {@link LocalDate} object
	 * @return The {@link java.sql.Date} object
	 */
	public static java.sql.Date toSqlDate(LocalDate localDate)
	{
		return java.sql.Date.valueOf(localDate);
	}

	/**
	 * Converts the given {@link LocalDate} to a {@link String} object from the given pattern
	 *
	 * @param localDate
	 *            the {@link LocalDate} object
	 * @param pattern
	 *            the pattern
	 * @return the {@link String} object from the given pattern
	 */
	public static String toDateString(LocalDate localDate, DatePattern pattern)
	{
		return toDateString(localDate, pattern.getPattern());
	}

	/**
	 * Converts the given {@link LocalDate} to a {@link String} object from the given pattern
	 *
	 * @param localDate
	 *            the {@link LocalDate} object
	 * @param pattern
	 *            the pattern
	 * @return the {@link String} object from the given pattern
	 */
	public static String toDateString(LocalDate localDate, String pattern)
	{
		return toDateString(localDate, pattern, Locale.getDefault());
	}

	/**
	 * Converts the given {@link LocalDate} to a {@link String} object from the given pattern
	 *
	 * @param localDate
	 *            the {@link LocalDate} object
	 * @param pattern
	 *            the pattern
	 * @param locale
	 *            the locale
	 * @return the {@link String} object from the given pattern
	 */
	public static String toDateString(LocalDate localDate, String pattern, Locale locale)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
		return localDate.format(formatter);
	}

	/**
	 * Converts the given {@link LocalDate} object to a legacy {@link Date} object at the start of
	 * the day because the {@link LocalDate} object does not hold time. <br>
	 * <br>
	 * Note: The {@link Date} object holds date + time <br>
	 * <br>
	 * the {@link LocalDate} object holds only the date
	 *
	 * @param localDate
	 *            the {@link LocalDate} object
	 * @return The {@link Date} object
	 */
	public static Date toDate(LocalDate localDate)
	{
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}
