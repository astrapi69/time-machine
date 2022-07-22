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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import de.alpharogroup.date.CreateDateExtensions;

/**
 * The unit test class for the class {@link ZonedDateTimeExtensions}
 */
public class ZonedDateTimeExtensionsTest
{

	/**
	 * Test method for {@link ZonedDateTimeExtensions#toDate(ZonedDateTime)}
	 */
	@Test
	// @Disabled // disabled because of fail only on github-action
	void testToDate()
	{
		Date actual;
		Date expected;
		ZonedDateTime input;
		ZoneId zoneId;
		LocalDateTime localDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.systemDefault();

		input = ZonedDateTime.of(localDateTime, zoneId);
		actual = ZonedDateTimeExtensions.toDate(input);
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
	 * Test method for {@link ZonedDateTimeExtensions#toZonedDateTime(LocalDateTime, ZoneId)}
	 */
	@Test
	void testToZonedDateTime()
	{
		ZonedDateTime actual;
		ZonedDateTime expected;
		ZoneId zoneId;
		LocalDateTime localDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.of("Europe/Paris");

		actual = ZonedDateTimeExtensions.toZonedDateTime(localDateTime, zoneId);
		expected = ZonedDateTime.parse("2000-09-01T00:00+02:00[Europe/Paris]");
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
