package de.alpharogroup.time.convert;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StringDateParserExtensionsTest
{

	@Test void parse()
	{
		LocalDateTime actual;
		LocalDateTime expected;
		String stringDate;
		String pattern;
		// new scenario
		stringDate = "21:41, 13.9.2020";
		pattern = "HH:mm, dd.M.yyyy";
		actual = StringDateParserExtensions.parse(stringDate, pattern);
		expected = LocalDateTime.of(2020, 9, 13,21,41);

		assertEquals(expected, actual);
		// new scenario
		stringDate = "21:41, 13.10.2020";
		actual = StringDateParserExtensions.parse(stringDate, pattern);
		expected = LocalDateTime.of(2020, 10, 13,21,41);

		assertEquals(expected, actual);
	}
}
