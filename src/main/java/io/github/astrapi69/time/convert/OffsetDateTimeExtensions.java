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

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
	 * Converts the given {@link OffsetDateTime} to a {@link ZonedDateTime} object
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
	 * Converts the given {@link LocalDateTime} with the given {@link ZoneId} to a
	 * {@link OffsetDateTime} object
	 *
	 * @param localDateTime
	 *            the date
	 * @param zone
	 *            the zone id
	 * @return The {@link OffsetDateTime} object
	 */
	public static OffsetDateTime toOffsetDateTime(LocalDateTime localDateTime, ZoneId zone)
	{
		Objects.requireNonNull(localDateTime);
		Objects.requireNonNull(zone);
		return localDateTime.atZone(zone).toOffsetDateTime();
	}

	/**
	 * Converts the given {@link LocalDateTime} with the given {@link ZoneOffset} to a
	 * {@link OffsetDateTime} object
	 *
	 * @param localDateTime
	 *            the date
	 * @param zoneOffset
	 *            the zone offset
	 * @return The {@link OffsetDateTime} object
	 */
	public static OffsetDateTime toOffsetDateTime(LocalDateTime localDateTime,
		ZoneOffset zoneOffset)
	{
		Objects.requireNonNull(localDateTime);
		Objects.requireNonNull(zoneOffset);
		return localDateTime.atOffset(zoneOffset);
	}

	/**
	 * Converts the given {@link OffsetDateTime} to a {@link Timestamp} object
	 *
	 * @param offsetDateTime
	 *            the {@link OffsetDateTime} object
	 * @return The {@link ZonedDateTime} object
	 */
	public static Timestamp toTimestamp(OffsetDateTime offsetDateTime)
	{
		Objects.requireNonNull(offsetDateTime);
		LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
		return Timestamp.valueOf(localDateTime);
	}

	/**
	 * Converts the given {@link OffsetDateTime} to a {@link XMLGregorianCalendar} object
	 *
	 * @param offsetDateTime
	 *            the {@link OffsetDateTime} object
	 * @return The {@link XMLGregorianCalendar} object
	 * @throws DatatypeConfigurationException
	 *             is thrown if the implementation is not available or cannot be instantiated
	 */
	public static XMLGregorianCalendar toXMLGregorianCalendar(OffsetDateTime offsetDateTime)
		throws DatatypeConfigurationException
	{
		return DatatypeFactory.newInstance()
			.newXMLGregorianCalendar(GregorianCalendar.from(toZonedDateTime(offsetDateTime)));
	}
}
