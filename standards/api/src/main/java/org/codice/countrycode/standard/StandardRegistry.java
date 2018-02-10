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
 * A registry for {@link Standard}s. To get a standard from this registry, a call to the appropriate
 * lookup method to get the {@link StandardInfo} should be used, followed by another call to {@link
 * #getStandard(StandardInfo)}.
 */
public interface StandardRegistry {

  /**
   * Looks up the {@link StandardInfo} by the given name. If multiple standards are registered under
   * the same name then the latest published standard, given by {@link
   * StandardInfo#getPublishedDate()}, will be returned.
   *
   * @param name name of the standard to lookup
   * @return standard info, or null if not found
   */
  StandardInfo lookup(String name);

  /**
   * Looks up the {@link StandardInfo} by name and version.
   *
   * @param name name of the standard to lookup, cannot be null
   * @param version version of the standard, cannot be null
   * @return the standard info, or null if not found
   */
  StandardInfo lookup(String name, String version);

  /**
   * Looks up a {@link StandardInfo} from the given name and published date.
   *
   * @param name
   * @param publishedDate
   * @return the standard info, or null if not found
   */
  StandardInfo lookup(String name, Date publishedDate);

  /**
   * Looks up the {@link StandardInfo} with the given name and a publication date before the given
   * date.
   *
   * @param name
   * @param beforeDate
   * @return the standard info, or null if not found
   */
  StandardInfo lookupBefore(String name, Date beforeDate);

  /**
   * Looks up the {@link StandardInfo} with the given name and a publication date after the given
   * date.
   *
   * @param name
   * @param afterDate
   * @return the standard info, or null if not found
   */
  StandardInfo lookupAfter(String name, Date afterDate);

  /**
   * Looks up the {@link StandardInfo} with the given name with a publication date within the
   * provided start date and end date (inclusive).
   *
   * @param name
   * @param startDate
   * @param endDate
   * @return the standard info, or null if not found
   */
  StandardInfo lookupBetween(String name, Date startDate, Date endDate);

  /**
   * Looks up the {@link Standard} by the given {@link StandardInfo}'s {@link
   * StandardInfo#getName()} and {@link StandardInfo#getVersion()}. A lookup method should be used
   * to get the appropriate {@code StandardInfo} before calling this method.
   *
   * @param standardInfo the standardInfo for the desired standard to lookup
   * @return the standard, cannot be null
   * @throws IllegalArgumentException is the standardInfo is not in the registry
   */
  Standard getStandard(StandardInfo standardInfo);

  /** @return set of standard infos of all standards in this registry, cannot be null or empty */
  Set<StandardInfo> getRegisteredStandards();
}
