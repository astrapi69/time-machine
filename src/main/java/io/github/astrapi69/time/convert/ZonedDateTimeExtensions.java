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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * The class {@link ZonedDateTimeExtensions} provides methods for convert {@link LocalDateTime}
 * objects
 */
public class ZonedDateTimeExtensions
{

	/**
	 * Converts the given {@link ZonedDateTime} to a legacy {@link Date} object
	 *
	 * @param zonedDateTime
	 *            the {@link ZonedDateTime} object
	 * @return The {@link Date} object
	 */
	public static Date toDate(ZonedDateTime zonedDateTime)
	{
		return Date.from(zonedDateTime.toInstant());
	}

	/**
	 * Converts the given {@link LocalDateTime} with the given {@link ZoneId} object
	 *
	 * @param localDateTime
	 *            the {@link LocalDateTime} object
	 * @param zoneId
	 *            the {@link ZoneId} object
	 * @return The {@link ZonedDateTime} object
	 */
	public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId)
	{
		return ZonedDateTime.of(localDateTime, zoneId);
	}
}