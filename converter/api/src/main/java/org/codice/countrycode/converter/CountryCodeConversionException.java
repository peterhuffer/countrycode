package org.codice.countrycode.converter;

/** A checked exception indicating an error during country code conversions */
public class CountryCodeConversionException extends Exception {

  private static final long serialVersionUID = 42L;

  /** Instantiates a new {@code CountryCodeVersionException}. */
  public CountryCodeConversionException() {
    super();
  }

  /**
   * Instantiates a new {@code CountryCodeVersionException} with a message.
   *
   * @param message the message
   */
  public CountryCodeConversionException(String message) {
    super(message);
  }

  /**
   * Instantiates a new {@code CountryCodeVersionException} with a message and throwable
   *
   * @param message the message
   * @param throwable the throwable
   */
  public CountryCodeConversionException(String message, Throwable throwable) {
    super(message, throwable);
  }

  /**
   * Instantiates a new {@code CountryCodeVersionException} with a throwable
   *
   * @param throwable the throwable
   */
  public CountryCodeConversionException(Throwable throwable) {
    super(throwable);
  }
}
