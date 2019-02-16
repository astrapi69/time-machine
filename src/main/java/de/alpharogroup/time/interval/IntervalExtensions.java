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
package de.alpharogroup.time.interval;

import org.threeten.extra.Interval;

import lombok.experimental.UtilityClass;

/**
 * The class {@link IntervalExtensions} provides algorithms for compute if a given time range is
 * between of two points of time.
 */
@UtilityClass
public final class IntervalExtensions
{

	/**
	 * Checks if the given time range is between the given time range to check
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is between the given time range to check otherwise
	 *         false
	 */
	public static boolean isBetween(final Interval timeRange, final Interval timeRangeToCheck)
	{
		return ((timeRange.getStart() != null
			&& timeRange.getStart().isBefore(timeRangeToCheck.getStart()))
			&& (timeRange.getEnd() != null
				&& timeRange.getEnd().isAfter(timeRangeToCheck.getEnd())));
	}

	/**
	 * Checks if the given time range is overlapping before the given time range to check.
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is overlapping before the given time range to check
	 *         otherwise false
	 */
	public static boolean isOverlappingBefore(final Interval timeRange,
		final Interval timeRangeToCheck)
	{
		return ((timeRange.getStart() != null
			&& timeRange.getStart().isAfter(timeRangeToCheck.getStart()))
			&& (timeRange.getEnd() != null
				&& timeRange.getEnd().isAfter(timeRangeToCheck.getEnd())));
	}

	/**
	 * Checks if the given time range is overlapping after the given time range to check.
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is overlapping after the given time range to check
	 *         otherwise false
	 */
	public static boolean isOverlappingAfter(final Interval timeRange,
		final Interval timeRangeToCheck)
	{
		return ((timeRange.getStart() != null
			&& timeRange.getStart().isBefore(timeRangeToCheck.getStart()))
			&& (timeRange.getEnd() != null
				&& timeRange.getEnd().isBefore(timeRangeToCheck.getEnd())));
	}

	/**
	 * Checks if the given time range is overlapping before and after the given time range to check.
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is overlapping before and after the given time range to
	 *         check otherwise false
	 */
	public static boolean isOverlappingBeforeAndAfter(final Interval timeRange,
		final Interval timeRangeToCheck)
	{
		return ((timeRange.getStart() != null
			&& timeRange.getStart().isAfter(timeRangeToCheck.getStart()))
			&& (timeRange.getEnd() != null
				&& timeRange.getEnd().isBefore(timeRangeToCheck.getEnd())));
	}

}
