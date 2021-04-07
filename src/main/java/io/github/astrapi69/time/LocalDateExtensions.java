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
package io.github.astrapi69.time;

import io.github.astrapi69.time.enums.DatePattern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The class {@link LocalDateExtensions} provides methods for convert {@link LocalDate} objects
 */
public class LocalDateExtensions {

    /**
     * Converts the given {@link LocalDate} to a {@link java.sql.Date} object
     *
     * @param localDate
     *            the {@link LocalDate} object
     * @return The {@link java.sql.Date} object
     */
    public static java.sql.Date toSqlDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    /**
     * Converts the given {@link LocalDate} to a {@link String} object from the given pattern
     *
     * @param localDate
     *            the {@link LocalDate} object
     * @param pattern
     * 			the pattern
     * @return the {@link String} object from the given pattern
     */
    public static String toDateString(LocalDate localDate, DatePattern pattern) {
        return toDateString(localDate, pattern.getPattern());
    }

    /**
     * Converts the given {@link LocalDate} to a {@link String} object from the given pattern
     *
     * @param localDate
     *            the {@link LocalDate} object
     * @param pattern
     * 			the pattern
     * @return the {@link String} object from the given pattern
     */
    public static String toDateString(LocalDate localDate, String pattern) {
        return toDateString(localDate, pattern, Locale.getDefault());
    }

    /**
     * Converts the given {@link LocalDate} to a {@link String} object from the given pattern
     *
     * @param localDate
     *            the {@link LocalDate} object
     * @param pattern
     * 			the pattern
     * @param locale
     * 			the locale
     * @return the {@link String} object from the given pattern
     */
    public static String toDateString(LocalDate localDate, String pattern, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        return localDate.format(formatter);
    }

}
