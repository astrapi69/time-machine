package io.github.astrapi69.time.formatter;

import io.github.astrapi69.time.enums.DatePattern;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The factory class {@link DateTimeFormatterFactory} provides methods for create
 * {@link DateTimeFormatter} objects
 */
public final class DateTimeFormatterFactory {
    private DateTimeFormatterFactory() {
    }

    public static DateTimeFormatter newDateTimeFormatter(String pattern) {
        return newDateTimeFormatter(pattern, Locale.getDefault());
    }

    public static DateTimeFormatter newDateTimeFormatter(String pattern, Locale locale) {
        return DateTimeFormatter.ofPattern(pattern, locale);
    }

    public static DateTimeFormatter newDateTimeFormatter(DatePattern pattern) {
        return newDateTimeFormatter(pattern.getPattern(), Locale.getDefault());
    }

}
