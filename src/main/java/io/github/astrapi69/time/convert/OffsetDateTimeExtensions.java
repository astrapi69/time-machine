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

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * The class {@link OffsetDateTimeExtensions} provides methods for convert {@link OffsetDateTime}
 * objects
 */
public class OffsetDateTimeExtensions
{

	/**
	 * Converts the given {@link OffsetDateTime} to a legacy {@link Date} object
	 *
	 * @param offsetDateTime
	 *            the {@link OffsetDateTime} object
	 * @return The {@link Date} object
	 */
	public static Date toDate(OffsetDateTime offsetDateTime)
	{
		Objects.requireNonNull(offsetDateTime);
		return Date.from(offsetDateTime.toInstant());
	}

	/**
	 * Converts the given {@link OffsetDateTime} with the given {@link ZoneId} object
	 *
	 * @param offsetDateTime
	 *            the {@link OffsetDateTime} object
	 * @return The {@link ZonedDateTime} object
	 */
	public static ZonedDateTime toZonedDateTime(OffsetDateTime offsetDateTime)
	{
		Objects.requireNonNull(offsetDateTime);
		return offsetDateTime.toZonedDateTime();
	}

	/**
	 * Converts the given {@link Date} with the given {@link ZoneId} to a {@link OffsetDateTime}
	 * object
	 *
	 * @param date
	 *            the date
	 * @param zone
	 *            the zone
	 * @return The {@link OffsetDateTime} object
	 */
	public static OffsetDateTime toOffsetDateTime(Date date, ZoneId zone)
	{
		Objects.requireNonNull(date);
		Objects.requireNonNull(zone);
		return date.toInstant().atZone(zone).toOffsetDateTime();
	}
}
