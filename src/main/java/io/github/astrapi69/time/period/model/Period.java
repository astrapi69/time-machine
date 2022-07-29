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
package io.github.astrapi69.time.period.model;

import java.time.Instant;
import java.util.Objects;

/**
 * A period consists of a start and an end {@link Instant} object that represents a time range
 */
public class Period
{
	/**
	 * The start {@link Instant} object
	 */
	private final Instant start;

	/**
	 * The end {@link Instant} object
	 */
	private final Instant end;

	private Period(Instant start, Instant end)
	{
		Objects.requireNonNull(start, "start");
		Objects.requireNonNull(end, "end");
		this.start = start;
		this.end = end;
	}

	/**
	 * Factory method for create a new {@link Period} object
	 * 
	 * @param start
	 *            The start {@link Instant} object
	 * @param end
	 *            The end {@link Instant} object
	 * @return the new created {@link Period} object
	 */
	public static Period of(Instant start, Instant end)
	{
		return new Period(start, end);
	}

	/**
	 * Checks if this {@link Period} object adjoins the given {@link Period} object
	 *
	 * @param another
	 *            the {@link Period} object to check with
	 * @return true if this {@link Period} object adjoins the given {@link Period} object otherwise
	 *         false
	 */
	public boolean adjoins(Period another)
	{
		if (another == null)
			return false;
		return end.equals(another.start) ^ start.equals(another.end);
	}

	/**
	 * Checks if this {@link Period} object encloses the given {@link Period} object
	 *
	 * @param another
	 *            the {@link Period} object to check with
	 * @return true if this {@link Period} object encloses the given {@link Period} object otherwise
	 *         false
	 */
	public boolean encloses(Period another)
	{
		if (another == null)
			return false;
		return start.compareTo(another.start) <= 0 && another.end.compareTo(end) <= 0;
	}

	/**
	 * Checks if this {@link Period} object overlaps the given {@link Period} object
	 *
	 * @param another
	 *            the {@link Period} object to check with
	 * @return true if this {@link Period} object overlaps the given {@link Period} object otherwise
	 *         false
	 */
	public boolean overlaps(Period another)
	{
		if (another == null)
			return false;
		return another.equals(this)
			|| (start.compareTo(another.end) < 0 && another.start.compareTo(end) < 0);
	}

	/**
	 * Checks if this {@link Period} object is connected the given {@link Period} object
	 *
	 * @param another
	 *            the {@link Period} object to check with
	 * @return true if this {@link Period} object is connected the given {@link Period} object
	 *         otherwise false
	 */
	public boolean isConnected(Period another)
	{
		if (another == null)
			return false;
		return this.equals(another)
			|| (start.compareTo(another.end) <= 0 && another.start.compareTo(end) <= 0);
	}

	/**
	 * Checks if this {@link Period} object is after the given {@link Period} object
	 *
	 * @param period
	 *            the {@link Period} object to check with
	 * @return true if this {@link Period} object is after the given {@link Period} object otherwise
	 *         false
	 */
	public boolean isAfter(Period period)
	{
		Objects.requireNonNull(period, "period");
		return start.compareTo(period.end) >= 0 && !period.equals(this);
	}

	/**
	 * Checks if this {@link Period} object is before the given {@link Period} object
	 *
	 * @param period
	 *            the {@link Period} object to check with
	 * @return true if this {@link Period} object is before the given {@link Period} object
	 *         otherwise false
	 */
	public boolean isBefore(Period period)
	{
		return end.compareTo(period.start) <= 0 && !period.equals(this);
	}

	/**
	 * Gets the start {@link Period} object
	 * 
	 * @return the start {@link Period} object
	 */
	public Instant getStart()
	{
		return start;
	}

	/**
	 * Gets the end {@link Period} object
	 * 
	 * @return the end {@link Period} object
	 */
	public Instant getEnd()
	{
		return end;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj instanceof Period)
		{
			Period other = (Period)obj;
			return start.equals(other.start) && end.equals(other.end);
		}
		return false;
	}

}
