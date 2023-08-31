package io.github.astrapi69.time.period.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The unit test class for the class {@link Period}
 */
public class PeriodTest
{
	private boolean actual;
	private LocalDateTime endDate;

	private DateTimeFormatter formatter;
	private LocalDateTime startDate;
	private Period timeRange;

	/**
	 * Sets up method will be invoked before every unit test method
	 */
	@BeforeEach
	protected void setUp()
	{
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}

	/**
	 * Tear down method will be invoked after every unit test method
	 */
	@AfterEach
	protected void tearDown()
	{
		formatter = null;
	}

	/**
	 * Test method for {@link Period#equals(Object)}
	 */
	@Test
	void testEquals()
	{
		// new scenario...
		startDate = LocalDate.parse("2007-11-03", formatter).atStartOfDay();
		endDate = startDate.plus(1, ChronoUnit.DAYS);

		timeRange = Period.of(startDate.toInstant(ZoneOffset.UTC),
			endDate.toInstant(ZoneOffset.UTC));

		actual = timeRange.equals(timeRange);
		assertTrue(actual);
		actual = timeRange.equals(startDate);
		assertFalse(actual);
	}

}
