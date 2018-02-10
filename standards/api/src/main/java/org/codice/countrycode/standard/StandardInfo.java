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

import java.util.Date;
import java.util.Set;

/**
 * Metadata about a country code standard, such as FIPS 10-4. The name and version of a standard
 * should be unique from all other standards in a system. A standard with a unique name and version
 * should not have multiple publish dates.
 */
public interface StandardInfo extends Comparable<StandardInfo> {

  /**
   * Returns the name of this standard.
   *
   * @return the standard's name, cannot be null or empty string
   */
  String getName();

  /**
   * Returns the version of this country code standard.
   *
   * @return the version, or null if a version is not applicable
   */
  String getVersion();

  /**
   * Returns the date for when this standard was published. If a modification occurs to a standard,
   * such as the codes it returns or a code being modified, then the published date should reflect
   * the date that change occurred.
   *
   * @return the publication date
   */
  Date getPublishedDate();

  /**
   * Returns a list of formats available for a {@link CountryCode} whose standard info is equal to
   * this info. For example, a standard that supports alpha2 country codes, like ISO 3166-1, would
   * have a format of "alpha2". Other examples include "numeric", "alpha3", etc.
   *
   * @return the set of a country code's formats
   */
  Set<String> getFormatNames();
}
