package de.alpharogroup.time.query;

import static org.testng.AssertJUnit.assertEquals;

import java.time.LocalDate;

import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link NextEasternQuery}
 */
public class NextEasternQueryTest
{

	/**
	 * Test method for {@link NextEasternQuery#queryFrom(java.time.temporal.TemporalAccessor)}
	 */
	@Test
	public final void testQueryFrom()
	{
		LocalDate actual;
		LocalDate expected;
		LocalDate valentinsDay;
		LocalDate thanksgivingDay;

		valentinsDay = LocalDate.of(2019, 2, 14);
		actual = valentinsDay.query(new NextEasternQuery());
		expected = LocalDate.of(2019, 4, 21);
		assertEquals(actual, expected);

		thanksgivingDay = LocalDate.of(2019, 11, 28);
		actual = thanksgivingDay.query(new NextEasternQuery());
		expected = LocalDate.of(2020, 4, 12);
		assertEquals(actual, expected);
	}

}

