/**
 * Copyright (c) Codice Foundation
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package org.codice.countrycode.converter;

import java.util.Set;
import org.codice.countrycode.standard.CountryCode;
import org.codice.countrycode.standard.StandardInfo;

/** A {@code Converter} converts {@link CountryCode}s from one country code standard to another. */
public interface Converter {

  /**
   * Takes a format value which acts as a key to identify the {@link CountryCode} in the {@code
   * from} standard and converts to the corresponding country code in the {@code to} standard.
   *
   * <p>The format value must be equal to one of the values corresponding to one of the country
   * code's format names of the {@code from} standard. Available format names are given by {@link
   * StandardInfo#getFormatNames()}. If the format value does not correspond to the value of a
   * format name, then an empty set must be returned.
   *
   * <p>If the {@code from} or {@code to} standards do not belong to this converter's supported
   * standards, an {@code IllegalArgumentException} will be thrown.
   *
   * <p>For example, if countryCodeA has a format name "alpha2" with a value of "AF" belonging to
   * standardA, and countryCodeB has a format name "alpha3 with a value of "AFG" belonging to
   * standardB, then to convert countryCodeA from standardA to the country codes from standardB do:
   *
   * <pre>{@code
   * Set<CountryCode> countryCodesFromStandardB = converter.fromValue("AF", standardA, standardB);
   * }</pre>
   *
   * An example result set could be a single country code whose call to {@link
   * CountryCode#getAsFormat(String)} for the format name "alpha3" would return "AFG".
   *
   * <p>More than 1 country code may be returned when a given country code from a standard converts
   * to multiple country codes in another standard. An example of this is the alpha3 country code
   * "PSE" (Palestine) from ISO 3166-1 converting to the alpha2 country codes "GZ" (Gaza Strip) and
   * "WE" (West Bank) in FIPS 10-4.
   *
   * @param formatValue a value of a country code's format
   * @param from the standard which has a country code with the format value
   * @param to the standard to convert to
   * @return a set of country code conversions, or empty set if there is no mapping
   * @throws CountryCodeConversionException if there is no country code in the {@code from} standard
   *     with a format name whose value is {@code formatValue}
   * @throws IllegalArgumentException if the {@code from} or {@code to} standards do not belong to
   *     {@link #getSupportedStandards()}
   */
  Set<CountryCode> fromValue(String formatValue, StandardInfo from, StandardInfo to)
      throws CountryCodeConversionException;

  /** @return a set of standards this converter supports */
  Set<StandardInfo> getSupportedStandards();

  /**
   * Converts from the {@code from} standard to the default standard of this converter. Utility
   * method for
   *
   * <pre>{@code
   * Set<CountryCode> countryCodes = converter.fromValue("ABC", fromStandard, {@link #getDefaultStandard()});
   * }</pre>
   */
  Set<CountryCode> toDefaultStandard(String formatValue, StandardInfo from);

  /**
   * Converts to the {@code to} standard from the default standard of this converter. Utility method
   * for
   *
   * <pre>{@code
   * Set<CountryCode> countryCodes = converter.fromValue("ABC",  {@link #getDefaultStandard()}, fromStandard);
   * }</pre>
   */
  Set<CountryCode> fromDefaultStandard(String formatValue, StandardInfo to);

  /**
   * Returns the info of the default standard for this converter. Useful for configuring a default
   * standard for a system. The default standard must be supported by this converter.
   *
   * @return default standard info of this converter
   */
  StandardInfo getDefaultStandard();
}
