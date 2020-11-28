package io.github.astrapi69.time.formatter;

import java.time.format.DateTimeFormatter;

import io.github.astrapi69.time.enums.DatePattern;

/**
 * The factory class {@link DateTimeFormatterFactory} provides methods for create
 * {@link DateTimeFormatter} objects
 */
public final class DateTimeFormatterFactory
{
	private DateTimeFormatterFactory()
	{
	}

	public static DateTimeFormatter newDateTimeFormatter(String pattern)
	{
		return DateTimeFormatter.ofPattern(pattern);
	}

	public static DateTimeFormatter newDateTimeFormatter(DatePattern pattern)
	{
		return newDateTimeFormatter(pattern.getPattern());
	}

}
