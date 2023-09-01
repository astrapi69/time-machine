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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.date.CreateDateExtensions;

/**
 * The unit test class for the class {@link DateExtensions}
 */
public class DateExtensionsTest
{

	/**
	 * Test method for {@link DateExtensions#toLocalDate(Date, ZoneId)}
	 */
	@Test
	void toLocalDate()
	{
		LocalDate actual;
		LocalDate expected;
		Date date;

		// new scenario
		date = CreateDateExtensions.newDate(2000, 9, 1);
		actual = DateExtensions.toLocalDate(date, ZoneId.systemDefault());
		expected = LocalDate.of(2000, 9, 1);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DateExtensions#toLocalDateTime(Date, ZoneId)}
	 */
	@Test
	void toLocalDateTime()
	{
		LocalDateTime actual;
		LocalDateTime expected;
		Date date;

		// new scenario
		date = CreateDateExtensions.newDate(2000, 9, 1);
		actual = DateExtensions.toLocalDateTime(date, ZoneId.systemDefault());
		expected = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DateExtensions#toOffsetDateTime(Date, ZoneId)
	 */
	@Test
//	@Disabled("not working on github-actions because of server location")
	void testToOffsetDateTimeWithDateAndZoneId()
	{

		OffsetDateTime actual;
		OffsetDateTime expected;
		ZoneId zoneId;
		Date date;

		date = CreateDateExtensions.newDate(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.of("Europe/Paris");

		actual = DateExtensions.toOffsetDateTime(date, zoneId);
		expected = OffsetDateTime.parse("2000-09-01T00:00+02:00");
		System.err.println("ZoneId.systemDefault():" + ZoneId.systemDefault() );
		System.err.println(actual + "::" + expected);
		System.err.println("actual:"+actual + "\nexpected:" + expected);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DateExtensions#toOffsetDateTime(Date, ZoneId)
	 */
	@Test
	@Disabled("not working on github-actions because of servers location")
	void testToOffsetDateTimeWithDateAndZoneOffset()
	{
		OffsetDateTime actual;
		OffsetDateTime expected;
		Date date;
		ZoneOffset zoneOffset;

		date = CreateDateExtensions.newDate(2000, 9, 1, 0, 0, 0);

		zoneOffset = DateExtensions.toZoneOffset(date.toInstant(), ZoneId.of("Europe/Berlin"));

		actual = DateExtensions.toOffsetDateTime(date, zoneOffset);
		expected = OffsetDateTime.parse("2000-09-01T00:00+02:00");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DateExtensions#toZonedDateTime(Date, ZoneId)}
	 */
	@Test
	@Disabled("not working on github-actions because of servers location")
	void testToZonedDateTimeFromDateAndZoneId()
	{

		ZonedDateTime actual;
		ZonedDateTime expected;
		ZoneId zoneId;
		Date date;

		date = CreateDateExtensions.newDate(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.of("Europe/Paris");

		actual = DateExtensions.toZonedDateTime(date, zoneId);
		expected = ZonedDateTime.parse("2000-09-01T00:00+02:00");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DateExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DateExtensions.class);
	}

}
