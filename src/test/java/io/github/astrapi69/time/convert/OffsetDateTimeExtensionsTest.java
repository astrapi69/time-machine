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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.date.CreateDateExtensions;

/**
 * The unit test class for the class {@link OffsetDateTimeExtensions}
 */
public class OffsetDateTimeExtensionsTest
{

	/**
	 * Test method for {@link OffsetDateTimeExtensions#toDate(OffsetDateTime)}
	 */
	@Test
	void testToDate()
	{
		Date actual;
		Date expected;
		OffsetDateTime input;
		ZoneId zoneId;
		LocalDateTime localDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.systemDefault();

		input = localDateTime.atZone(zoneId).toOffsetDateTime();
		actual = OffsetDateTimeExtensions.toDate(input);
		expected = CreateDateExtensions.newDate(2000, 9, 1);
		if (!actual.equals(expected))
		{
			java.util.logging.Logger logger = java.util.logging.Logger
				.getLogger(this.getClass().getName());
			logger.severe("  actual:" + actual + "\n" + "expected:" + expected);
		}
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link OffsetDateTimeExtensions#toZonedDateTime(OffsetDateTime)}
	 */
	@Test
	void testToZonedDateTime()
	{
		ZonedDateTime actual;
		ZonedDateTime expected;
		ZoneId zoneId;
		LocalDateTime localDateTime;
		OffsetDateTime offsetDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.of("Europe/Paris");
		offsetDateTime = OffsetDateTimeExtensions.toOffsetDateTime(localDateTime, zoneId);
		actual = OffsetDateTimeExtensions.toZonedDateTime(offsetDateTime);
		expected = ZonedDateTime.parse("2000-09-01T00:00+02:00");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link OffsetDateTimeExtensions#toOffsetDateTime(LocalDateTime, ZoneId)}
	 */
	@Test
	void testToOffsetDateTimeWithLocalDateTimeZoneId()
	{

		OffsetDateTime actual;
		OffsetDateTime expected;
		ZoneId zoneId;
		LocalDateTime localDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.of("Europe/Paris");

		actual = OffsetDateTimeExtensions.toOffsetDateTime(localDateTime, zoneId);
		expected = OffsetDateTime.parse("2000-09-01T00:00+02:00");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link OffsetDateTimeExtensions#toOffsetDateTime(LocalDateTime, ZoneOffset)}
	 */
	@Test
	void testToOffsetDateTimeWithLocalDateTimeZoneOffset()
	{

		OffsetDateTime actual;
		OffsetDateTime expected;
		ZoneOffset zoneOffSet;
		LocalDateTime localDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneOffSet = ZoneOffset.of("+02:00");

		actual = OffsetDateTimeExtensions.toOffsetDateTime(localDateTime, zoneOffSet);
		expected = OffsetDateTime.parse("2000-09-01T00:00+02:00");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link OffsetDateTimeExtensions#toTimestamp(OffsetDateTime)}
	 */
	@Test
	void testToTimestamp()
	{
		Timestamp actual;
		Timestamp expected;
		ZoneId zoneId;
		LocalDateTime localDateTime;
		OffsetDateTime offsetDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.of("Europe/Paris");
		offsetDateTime = OffsetDateTimeExtensions.toOffsetDateTime(localDateTime, zoneId);

		actual = OffsetDateTimeExtensions.toTimestamp(offsetDateTime);
		expected = LocalDateTimeExtensions.toTimestamp(localDateTime);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for show deltas between {@link OffsetDateTime} object and {@link ZonedDateTime}
	 * object
	 */
	@Test
	void testForShowDifferencesOfZonedDateTimeToOffsetDateTime()
	{
		String actual;
		String expected;
		Instant instant;
		Clock clock;
		OffsetDateTime offsetDateTime;
		ZonedDateTime zonedDateTime;
		OffsetDateTime offsetPlusSixMonths;
		ZonedDateTime zonedDateTimePlusSixMonths;
		ZoneId zoneId;
		Date date;
		long delta;

		zoneId = ZoneId.of("Europe/Berlin");
		date = CreateDateExtensions.newDate(2000, 9, 1, 0, 0, 0);
		instant = date.toInstant();

		clock = Clock.fixed(instant, zoneId);
		offsetDateTime = OffsetDateTime.now(clock);
		zonedDateTime = ZonedDateTime.now(clock);

		actual = offsetDateTime.toString();
		expected = "2000-09-01T00:00+02:00";
		assertEquals(expected, actual);

		actual = zonedDateTime.toString();
		expected = "2000-09-01T00:00+02:00[Europe/Berlin]";
		assertEquals(expected, actual);

		offsetPlusSixMonths = offsetDateTime.plusMonths(6);
		zonedDateTimePlusSixMonths = zonedDateTime.plusMonths(6);

		actual = offsetPlusSixMonths.toString();
		expected = "2001-03-01T00:00+02:00";
		assertEquals(expected, actual);

		actual = zonedDateTimePlusSixMonths.toString();
		expected = "2001-03-01T00:00+01:00[Europe/Berlin]";
		assertEquals(expected, actual);

		delta = zonedDateTimePlusSixMonths.toEpochSecond() - offsetPlusSixMonths.toEpochSecond();
		assertEquals(3600, delta);

		actual = zonedDateTimePlusSixMonths.toLocalDateTime().toString();
		expected = "2001-03-01T00:00";
		assertEquals(expected, actual);

		actual = offsetPlusSixMonths.toLocalDateTime().toString();
		expected = "2001-03-01T00:00";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ZonedDateTimeExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ZonedDateTimeExtensions.class);
	}

}
