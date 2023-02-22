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

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The unit test class for the class {@link XMLGregorianCalendarExtensions}
 */
class XMLGregorianCalendarExtensionsTest
{

	public static ZoneOffset toZoneOffset(Instant instant, ZoneId zoneId)
	{
		return zoneId.getRules().getOffset(instant);
	}

	/**
	 * Test method for {@link XMLGregorianCalendarExtensions#toZonedDateTime(XMLGregorianCalendar)}
	 *
	 * @throws DatatypeConfigurationException
	 *             is thrown if the implementation is not available or cannot be instantiated
	 */
	@Test
	void toZonedDateTime() throws DatatypeConfigurationException
	{
		ZonedDateTime actual;
		ZonedDateTime expected;

		actual = ZonedDateTime.now();
		expected = XMLGregorianCalendarExtensions
			.toZonedDateTime(ZonedDateTimeExtensions.toXMLGregorianCalendar(actual));
		assertEquals(expected.getDayOfMonth(), actual.getDayOfMonth());
	}

	/**
	 * Test method for {@link XMLGregorianCalendarExtensions#toOffsetDateTime(XMLGregorianCalendar)}
	 *
	 * @throws DatatypeConfigurationException
	 *             is thrown if the implementation is not available or cannot be instantiated
	 */
	@Test
	void toOffsetDateTime() throws DatatypeConfigurationException
	{
		OffsetDateTime actual;
		OffsetDateTime expected;

		actual = OffsetDateTime.now();
		expected = XMLGregorianCalendarExtensions
			.toOffsetDateTime(OffsetDateTimeExtensions.toXMLGregorianCalendar(actual));
		assertEquals(expected.getDayOfMonth(), actual.getDayOfMonth());
	}

	/**
	 * Test method for {@link XMLGregorianCalendarExtensions#toLocalDateTime(XMLGregorianCalendar)}
	 *
	 * @throws DatatypeConfigurationException
	 *             is thrown if the implementation is not available or cannot be instantiated
	 */
	@Test
	void toLocalDateTime() throws DatatypeConfigurationException
	{
		LocalDateTime actual;
		LocalDateTime expected;

		actual = LocalDateTime.now();
		expected = XMLGregorianCalendarExtensions
			.toLocalDateTime(LocalDateTimeExtensions.toXMLGregorianCalendar(actual));
		assertEquals(expected.getDayOfMonth(), actual.getDayOfMonth());
	}

	/**
	 * Test method for {@link XMLGregorianCalendarExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XMLGregorianCalendarExtensions.class);
	}
}
