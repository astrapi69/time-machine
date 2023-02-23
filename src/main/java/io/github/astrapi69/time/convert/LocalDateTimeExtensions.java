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

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * The class {@link LocalDateTimeExtensions} provides methods for convert {@link LocalDateTime}
 * objects
 */
public class LocalDateTimeExtensions
{

	/**
	 * Converts the given {@link LocalDateTime} to a {@link XMLGregorianCalendar} object
	 *
	 * @param localDateTime
	 *            the {@link LocalDateTime} object
	 * @return The {@link XMLGregorianCalendar} object
	 * @throws DatatypeConfigurationException
	 *             is thrown if the implementation is not available or cannot be instantiated
	 */
	public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDateTime localDateTime)
		throws DatatypeConfigurationException
	{
		Objects.requireNonNull(localDateTime);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(localDateTime.toString());
	}

	/**
	 * Converts the given {@link LocalDateTime} to a legacy {@link Date} object
	 *
	 * @param localDateTime
	 *            the {@link LocalDateTime} object
	 * @return The {@link Date} object
	 */
	public static Date toDate(LocalDateTime localDateTime)
	{
		return Timestamp.valueOf(localDateTime);
	}

	/**
	 * Converts the given {@link LocalDateTime} to a {@link Timestamp} object
	 *
	 * @param localDateTime
	 *            The {@link LocalDateTime} to convert
	 * @return The {@link Timestamp} object from the {@link LocalDateTime}
	 */
	public static Timestamp toTimestamp(LocalDateTime localDateTime)
	{
		return Timestamp.valueOf(localDateTime);
	}

}
