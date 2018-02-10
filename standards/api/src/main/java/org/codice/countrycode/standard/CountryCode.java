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
package org.codice.countrycode.standard;

/** Represents a country code for a standard. */
public interface CountryCode {

  /**
   * Returns the country code in the specified format. Supported format names for this entry are
   * defined by this entry's {@link StandardInfo#getFormatNames()}.
   *
   * @param formatName name of format to get this entry in
   * @return the country code format's value, or null if not a supported format
   * @throws IllegalArgumentException if the {@code formatName} is not supported by this country
   *     code
   */
  String getAsFormat(String formatName);

  /**
   * Returns the country name identified by this {@code CountryCode}.
   *
   * @return the name, cannot be null
   */
  String getName();

  /**
   * Returns this country code's standard.
   *
   * @return the standard, cannot return null
   */
  StandardInfo getStandardInfo();
}
