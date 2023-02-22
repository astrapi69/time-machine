/**
 * The MIT License
 * <p>
 * Copyright (C) 2015 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.time.convert;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * The class {@link DateExtensions} provides methods for convert {@link Date} objects
 */
public class DateExtensions
{

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
	 * Converts the given {@link Date} with the given {@link ZoneId} to a {@link LocalDateTime}
	 * object
	 *
	 * @param date
	 *            the date
	 * @param zone
	 *            the zone
	 * @return The {@link LocalDateTime} object
	 */
	public static LocalDateTime toLocalDateTime(Date date, ZoneId zone)
	{
		return date.toInstant().atZone(zone).toLocalDateTime();
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
		return toOffsetDateTime(date, zone.getRules().getOffset(date.toInstant()));
	}

	/**
	 * Converts the given {@link Date} with the given {@link ZoneOffset} to a {@link OffsetDateTime}
	 * object
	 *
	 * @param date
	 *            the date
	 * @param zoneOffset
	 *            the zone offset
	 * @return The {@link OffsetDateTime} object
	 */
	public static OffsetDateTime toOffsetDateTime(Date date, ZoneOffset zoneOffset)
	{
		Objects.requireNonNull(date);
		Objects.requireNonNull(zoneOffset);
		return date.toInstant().atOffset(zoneOffset);
	}

	/**
	 * Converts the given {@link Date} with the given {@link ZoneId} to a {@link ZonedDateTime}
	 * object
	 *
	 * @param date
	 *            the date
	 * @param zone
	 *            the zone
	 * @return The {@link ZonedDateTime} object
	 */
	public static ZonedDateTime toZonedDateTime(Date date, ZoneId zone)
	{
		return OffsetDateTimeExtensions
			.toZonedDateTime(DateExtensions.toOffsetDateTime(date, zone));
	}

	public static ZoneOffset toZoneOffset(Instant instant, ZoneId zoneId)
	{
		return zoneId.getRules().getOffset(instant);
	}
}
