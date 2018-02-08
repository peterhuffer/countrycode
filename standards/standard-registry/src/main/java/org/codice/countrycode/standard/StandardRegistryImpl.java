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
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.codice.countrycode.standards.fips.FipsJsonStandard;
import org.codice.countrycode.standards.genc.provider.GencXmlStandard;
import org.codice.countrycode.standards.iso.Iso3166StandardProvider;

public class StandardRegistryImpl implements StandardRegistry {

  private static StandardRegistry standardRegistry;

  private final Set<Standard> standardProviders;

  public static StandardRegistry getInstance() {
    if (standardRegistry == null) {
      standardRegistry = new StandardRegistryImpl();
    }
    return standardRegistry;
  }

  private StandardRegistryImpl() {
    standardProviders = new HashSet<>();
    standardProviders.add(new FipsJsonStandard());
    standardProviders.add(new GencXmlStandard());
    standardProviders.add(new Iso3166StandardProvider());
  }

  @Override
  public StandardInfo lookup(String name) {
    return null;
  }

  @Override
  public StandardInfo lookup(String name, String version) {
    return null;
  }

  @Override
  public StandardInfo lookup(String name, Date publishedDate) {
    return null;
  }

  @Override
  public StandardInfo lookupBefore(String name, Date beforeDate) {
    return null;
  }

  @Override
  public StandardInfo lookupAfter(String name, Date afterDate) {
    return null;
  }

  @Override
  public StandardInfo lookupBetween(String name, Date startDate, Date endDate) {
    return null;
  }

  @Override
  public Standard getByStandard(StandardInfo standardInfo) {
    return null;
  }

  @Override
  public Set<StandardInfo> getRegisteredStandards() {
    return standardProviders
        .stream()
        .map(Standard::getStandard)
        .collect(Collectors.toSet());
  }
}
