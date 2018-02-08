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
import org.codice.countrycode.standard.Standard;

public interface Converter {

  /**
   * Takes an format value which is a key to identify the country code in the {@code from} standard
   * and converts to the corresponding country code in the {@code to} standard.
   *
   * @param formatValue the value of a country code's format
   * @param from the standard which has a country code with the format value
   * @param to the standard to map to
   * @return a set of country code conversions
   */
  Set<CountryCode> fromValue(String formatValue, Standard from, Standard to);

  Set<Standard> getSupportedStandards();

  Standard getSystemDefaultStandard();
}
