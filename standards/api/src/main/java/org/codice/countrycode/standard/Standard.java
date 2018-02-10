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

import java.io.IOException;
import java.util.Set;

/**
 * Represents a country code standard. Examples of standards include: FIPS 10-4, ISO 3166-1, and
 * GENC.
 */
public interface Standard {

  /**
   * The {@link StandardInfo} describing this standard.
   *
   * @return the standard info, cannot be null
   */
  StandardInfo getStandardInfo();

  /**
   * A set of {@code CountryCode}s belonging to this standard. The {@link StandardInfo} returned by
   * each country code belonging to this standard must be equal to this standard's {@code
   * StandardInfo}.
   *
   * @return a set of country codes for this standard, cannot be null
   * @throws IOException if there was an error getting codes for this standard
   */
  Set<CountryCode> getStandardEntries() throws IOException;
}
