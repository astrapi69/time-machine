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
package de.alpharogroup.time.gap;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Objects;

/**
 * The class {@link TimeGapExtensions} provides methods for check time gaps
 */
public final class TimeGapExtensions
{
	private TimeGapExtensions(){}
	
	/**
	 * Checks if the given first {@link Temporal} has a time gap before the given second
	 * {@link Temporal} with the given {@link ChronoUnit}
	 *
	 * @param <T>
	 *            the generic type of the temporal
	 * @param inclusive
	 *            the temporal from where to check. Note this is handled inclusive
	 * @param otherExclusive
	 *            the other temporal. Note this is handled exclusive
	 * @param chronoUnit
	 *            the chrono unit
	 * @return true, if the given first {@link LocalDate} has a time gap before the given second
	 *         {@link LocalDate} with the given {@link ChronoUnit} otherwise false
	 */
	public static <T extends Temporal> boolean isBeforeTimeGap(final T inclusive,
		final T otherExclusive, ChronoUnit chronoUnit)
	{
		Objects.requireNonNull(inclusive);
		Objects.requireNonNull(otherExclusive);
		Objects.requireNonNull(chronoUnit);
		long between = chronoUnit.between(inclusive, otherExclusive);
		return between < -1;
	}

	/**
	 * Checks if the given first {@link LocalDate} has a time gap after the given second
	 * {@link LocalDate} with the given {@link ChronoUnit}
	 *
	 * @param <T>
	 *            the generic type of the temporal
	 *
	 * @param inclusive
	 *            the temporal from where to check. Note this is handled inclusive
	 * @param otherExclusive
	 *            the other temporal. Note this is handled exclusive
	 * @param chronoUnit
	 *            the chrono unit
	 *
	 * @return true, if the given first {@link LocalDate} has a time gap after the given second
	 *         {@link LocalDate} with the given {@link ChronoUnit} otherwise false
	 */
	public static <T extends Temporal> boolean isAfterTimeGap(final T inclusive,
		final T otherExclusive, ChronoUnit chronoUnit)
	{
		Objects.requireNonNull(inclusive);
		Objects.requireNonNull(otherExclusive);
		Objects.requireNonNull(chronoUnit);
		long between = chronoUnit.between(inclusive, otherExclusive);
		return 1 < between;
	}
}