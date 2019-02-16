package de.alpharogroup.time.query;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * The class {@link NextEasternQuery} provides a query method for resolve the eastern Sunday from
 * the given {@link TemporalAccessor}. For an example see the unit tests
 */
public class NextEasternQuery implements TemporalQuery<LocalDate>
{

	/**
	 * Gets the eastern date from the given year
	 *
	 * @param year
	 *            the year
	 * @return the eastern date from the given year
	 */
	private LocalDate getEasternDateInYear(int year)
	{
		final int easternSundayNumber = computeEasternSundayNumber(year);
		final int month = easternSundayNumber / 31;
		final int day = easternSundayNumber % 31 + 1;
		return LocalDate.of(year, month, day);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocalDate queryFrom(TemporalAccessor temporal)
	{
		LocalDate date = LocalDate.from(temporal);
		LocalDate currentYearEasternSunday = getEasternDateInYear(date.getYear());

		Period periodToCurrentYearEasternSunday = Period.between(date, currentYearEasternSunday);

		if (periodToCurrentYearEasternSunday.isNegative()
			|| periodToCurrentYearEasternSunday.isZero())
		{
			return getEasternDateInYear(date.getYear() + 1);
		}
		else
		{
			return currentYearEasternSunday;
		}
	}

	/**
	 * Computes the number from eastern sunday for the given year. Year should be greater the 1583.
	 *
	 * @param year
	 *            The year to compute the number from eastern sunday.
	 * @return The number from eastern sunday.
	 */
	private int computeEasternSundayNumber(final int year)
	{
		final int i = year % 19;
		final int j = year / 100;
		final int k = year % 100;
		final int l = (19 * i + j - j / 4 - (j - (j + 8) / 25 + 1) / 3 + 15) % 30;
		final int m = (32 + 2 * (j % 4) + 2 * (k / 4) - l - k % 4) % 7;
		return (l + m - 7 * ((i + 11 * l + 22 * m) / 451) + 114);
	}
}
