package io.github.astrapi69.time.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import de.alpharogroup.date.CreateDateExtensions;
import io.github.astrapi69.time.LocalDateTimeExtensions;

/**
 * The unit test class for the class {@link ZonedDateTimeExtensions}
 */
public class ZonedDateTimeExtensionsTest
{

	/**
	 * Test method for {@link ZonedDateTimeExtensions#toDate(ZonedDateTime)}
	 */
	@Test
	//@Disabled // temporary disabled because of fail only on github-action
	void testToDate()
	{
		Date actual;
		Date expected;
		ZonedDateTime input;
		ZoneId zoneId;
		LocalDateTime localDateTime;

		localDateTime = LocalDateTime.of(2000, 9, 1, 0, 0, 0);
		zoneId = ZoneId.of("Europe/Paris");

		input = ZonedDateTime.of(localDateTime, zoneId);
		actual = ZonedDateTimeExtensions.toDate(input);
		expected = CreateDateExtensions.newDate(2000, 9, 1);
		if(!actual.equals(expected)) {
			java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
			logger.severe(
				"  actual:"+actual + "\n"+
				"expected:"+expected);
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

}
