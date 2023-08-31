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

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * The class {@link XMLGregorianCalendarExtensions} provides methods for convert
 * {@link XMLGregorianCalendar} objects
 */
public class XMLGregorianCalendarExtensions
{

	/**
	 * Converts the given {@link XMLGregorianCalendar} to a {@link ZonedDateTime} object
	 *
	 * @param calendar
	 *            the {@link XMLGregorianCalendar} object
	 * @return The {@link ZonedDateTime} object
	 */
	public static ZonedDateTime toZonedDateTime(XMLGregorianCalendar calendar)
	{
		Objects.requireNonNull(calendar);
		return calendar.toGregorianCalendar().toZonedDateTime();
	}

	/**
	 * Converts the given {@link XMLGregorianCalendar} to a {@link OffsetDateTime} object
	 *
	 * @param calendar
	 *            the {@link XMLGregorianCalendar} object
	 * @return The {@link OffsetDateTime} object
	 */
	public static OffsetDateTime toOffsetDateTime(XMLGregorianCalendar calendar)
	{
		Objects.requireNonNull(calendar);
		return toZonedDateTime(calendar).toOffsetDateTime();
	}

	/**
	 * Converts the given {@link XMLGregorianCalendar} to a {@link LocalDateTime} object
	 *
	 * @param calendar
	 *            the {@link XMLGregorianCalendar} object
	 * @return The {@link LocalDateTime} object
	 */
	public static LocalDateTime toLocalDateTime(XMLGregorianCalendar calendar)
	{
		Objects.requireNonNull(calendar);
		return toZonedDateTime(calendar).toLocalDateTime();
	}
}
