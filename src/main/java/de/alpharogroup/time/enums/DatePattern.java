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
package de.alpharogroup.time.enums;

/**
 * The enum class {@link DatePattern} provides several date patterns with the property pattern
 */
public enum DatePattern
{

	/**
	 * Dateformat in String. Current value:"yyyy-MM-dd'T'HH:mm:ss"
	 */
	YYYY_MM_DD_T_HH_MM_SS("yyyy-MM-dd'T'HH:mm:ss"),

	/**
	 * Dateformat in String. Current value:"EEEE MMM dd, yyyy"
	 */
	EEEE_MMM_DD_YYYY("EEEE MMM dd, yyyy"),

	/**
	 * Dateformat in String. Current value:"dd-MMM-yy"
	 */
	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd hh:mm:ss"),

	/**
	 * Dateformat in String. Current value:"dd-MMM-yy"
	 */
	DD_MMM_YY("dd-MMM-yy"),

	/**
	 * Dateformat in String. Current value:"yyyy.MM.dd.HH.mm.ss"
	 */
	DOT_YYYY_MM_DD_HH_MM_SS("yyyy.MM.dd.HH.mm.ss"),

	/**
	 * Dateformat in String. Current value:"EEE MMM dd hh:mm:ss z yyyy"
	 */
	EEE_MMM_DD_HH_MM_SS_Z_YYYY("EEE MMM dd hh:mm:ss z yyyy"),

	/**
	 * Dateformat in String. Current value:"yyyy-MM-dd hh:mm:ss.S"
	 */
	YYYY_MM_DD_HH_MM_SS_S("yyyy-MM-dd hh:mm:ss.S"),

	/**
	 * Dateformat in String. Current value:"dd.MM"
	 */
	DOT_DD_MM("dd.MM"),

	/**
	 * Dateformat in String. Current value:"yyyyMMddHHmmss"
	 */
	YYYYMMDDHHMMSS("yyyyMMddHHmmss"),

	/**
	 * Dateformat in String. Current value:"HH:mm:ss"
	 */
	UHH_MM_SS("HH:mm:ss"),

	/**
	 * Dateformat in String. Current value:"HH:mm:ss"
	 */
	UHH_MM("HH:mm"),

	/**
	 * Dateformat in String. Current value:"hh:mm:ss"
	 */
	LHH_MM_SS("hh:mm:ss"),

	/**
	 * Dateformat in String. Current value:"dd.MM.yyyy"
	 */
	DOT_DD_MM_YYYY("dd.MM.yyyy"),

	/**
	 * Dateformat in String. Current value:"dd.MM.yyyy HH:mm:ss"
	 */
	DOT_DD_MM_YYYY_HH_MM_SS("dd.MM.yyyy HH:mm:ss"),

	/**
	 * Dateformat in String. Current value:"HH:mm, dd.MM.yyyy"
	 */
	DOT_HH_MM_COMMA_DD_MM_YYYY("HH:mm, dd.MM.yyyy"),

	/**
	 * Dateformat in String. Current value:"HH:mm, dd.M.yyyy"
	 */
	DOT_HH_MM_COMMA_DD_M_YYYY("HH:mm, dd.M.yyyy"),

	/**
	 * Dateformat in String. Current value:"yyyy-MM-dd"
	 */
	YYYY_MM_DD("yyyy-MM-dd"),

	/**
	 * Dateformat in String. Current value:"dd.MM.yy"
	 */
	DOT_DD_MM_YY("dd.MM.yy");

	private final String pattern;

	DatePattern(String pattern)
	{
		this.pattern = pattern;
	}

	public String getPattern()
	{
		return pattern;
	}
}
