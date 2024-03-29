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
package io.github.astrapi69.time.period;

import java.util.Objects;

import io.github.astrapi69.time.period.model.Period;

/**
 * The class {@link PeriodExtensions} provides algorithms for compute the state of a given time
 * range to another given time range.
 */
public final class PeriodExtensions
{

	private PeriodExtensions()
	{
	}

	/**
	 * Checks if the given time range is after from the given time range to check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;|__|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is after from the given time range to check otherwise
	 *         false
	 */
	public static boolean isAfter(final Period timeRange, final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.isAfter(timeRangeToCheck);
	}

	/**
	 * Checks if the given time range is before from the given time range to check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;|&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|______|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is before from the given time range to check otherwise
	 *         false
	 */
	public static boolean isBefore(final Period timeRange, final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.isBefore(timeRangeToCheck);
	}

	/**
	 * Checks if the given time range is between the given time range to check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 *
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is between the given time range to check otherwise
	 *         false
	 */
	public static boolean isBetween(final Period timeRange, final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		boolean startIsBefore = timeRange.getStart().isBefore(timeRangeToCheck.getStart());
		boolean endIsAfter = timeRange.getEnd().isAfter(timeRangeToCheck.getEnd());
		boolean between = startIsBefore && endIsAfter;
		return between;
	}

	/**
	 * Checks if the end of the given time range is equal with the start of the given time range to
	 * check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the end of the given time range is equal with the start of the given time
	 *         range to check otherwise false
	 */
	public static boolean isBorderingOnEndToStart(final Period timeRange,
		final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().equals(timeRangeToCheck.getEnd());
	}

	/**
	 * Checks if the start of the given time range is equal with the end of the given time range to
	 * check.
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the start of the given time range is equal with the end of the given time
	 *         range to check otherwise false
	 */
	public static boolean isBorderingOnStartToEnd(final Period timeRange,
		final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getEnd().equals(timeRangeToCheck.getStart());
	}

	/**
	 * Checks if the end of the given time range is equal with the start of the given time range to
	 * check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;|<br>
	 * ------------------------<br>
	 * &nbsp;&nbsp;|____|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 *
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the end of the given time range is equal with the start of the given time
	 *         range to check otherwise false
	 */
	public static boolean isEqual(final Period timeRange, final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.equals(timeRangeToCheck);
	}

	/**
	 *
	 * Checks if the given time range is overlapping before the given time range to check with the
	 * specialty that the end of the given time range equals to the end of the given time range
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * ------------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|_______|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the end of the given time range is equal with the start of the given time
	 *         range to check otherwise false
	 */
	public static boolean isLargerAndOverlappingAndBorderingOnEnd(final Period timeRange,
		final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().isBefore(timeRangeToCheck.getStart())
			&& timeRange.getEnd().equals(timeRangeToCheck.getEnd());
	}

	/**
	 * Checks if the end of the given time range is equal with the start of the given time range to
	 * check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * ------------------------<br>
	 * &nbsp;&nbsp;|_______|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the end of the given time range is equal with the start of the given time
	 *         range to check otherwise false
	 */
	public static boolean isLargerAndOverlappingAndBorderingOnStart(final Period timeRange,
		final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().equals(timeRangeToCheck.getStart())
			&& timeRange.getEnd().isAfter(timeRangeToCheck.getEnd());
	}

	/**
	 * Checks if the given time range is overlapping before the given time range to check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;|____|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is overlapping before the given time range to check
	 *         otherwise false
	 */
	public static boolean isOverlappingAfter(final Period timeRange, final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().isAfter(timeRangeToCheck.getStart())
			&& timeRange.getEnd().isAfter(timeRangeToCheck.getEnd());
	}

	/**
	 * Checks if the given time range is overlapping after the given time range to check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|______|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is overlapping after the given time range to check
	 *         otherwise false
	 */
	public static boolean isOverlappingBefore(final Period timeRange, final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().isBefore(timeRangeToCheck.getStart())
			&& timeRange.getEnd().isBefore(timeRangeToCheck.getEnd());
	}

	/**
	 * Checks if the given time range is overlapping before and after the given time range to check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|______|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 * <br>
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the given time range is overlapping before and after the given time range to
	 *         check otherwise false
	 */
	public static boolean isOverlappingBeforeAndAfter(final Period timeRange,
		final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().isAfter(timeRangeToCheck.getStart())
			&& timeRange.getEnd().isBefore(timeRangeToCheck.getEnd());
	}

	/**
	 *
	 * Checks if the given time range is overlapping before the given time range to check with the
	 * specialty that the end of the given time range equals to the end of the given time range
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;|<br>
	 * ------------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;|_______|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 *
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the end of the given time range is equal with the start of the given time
	 *         range to check otherwise false
	 */
	public static boolean isSmallerAndOverlappingAndBorderingOnEnd(final Period timeRange,
		final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().isAfter(timeRangeToCheck.getStart())
			&& timeRange.getEnd().equals(timeRangeToCheck.getEnd());
	}

	/**
	 * Checks if the end of the given time range is equal with the start of the given time range to
	 * check
	 * <p>
	 * <br>
	 * Here is a graphical examples where the given timeRange object is the above and the
	 * timeRangeToCheck object is at the bottom <br>
	 * <br>
	 * This scenario would return <code>true</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;|<br>
	 * ------------------------<br>
	 * &nbsp;&nbsp;|_______|<br>
	 * _______________________<br>
	 * <br>
	 * This scenario would return <code>false</code> <br>
	 * <br>
	 * _______________________<br>
	 * <br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&macr;&macr;&macr;&macr;&macr;&macr;&macr;&macr;|<br>
	 * -----------------------<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|___|<br>
	 * _______________________<br>
	 *
	 *
	 * @param timeRange
	 *            the time range
	 * @param timeRangeToCheck
	 *            the time range to check
	 * @return true, if the end of the given time range is equal with the start of the given time
	 *         range to check otherwise false
	 */
	public static boolean isSmallerAndOverlappingAndBorderingOnStart(final Period timeRange,
		final Period timeRangeToCheck)
	{
		Objects.requireNonNull(timeRange);
		Objects.requireNonNull(timeRangeToCheck);
		return timeRange.getStart().equals(timeRangeToCheck.getStart())
			&& timeRange.getEnd().isBefore(timeRangeToCheck.getEnd());
	}

}
