package de.alpharogroup.time.convert;

import de.alpharogroup.time.enums.DatePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class StringDateParserExtensions
{
	public static LocalDateTime parse(String stringDate, String pattern)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime localDateTime = LocalDateTime.parse(stringDate, formatter);
		return localDateTime;
	}

	public static LocalDateTime parse(String stringDate, DatePattern pattern)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.getPattern());
		LocalDateTime localDateTime = LocalDateTime.parse(stringDate, formatter);
		return localDateTime;
	}
}
