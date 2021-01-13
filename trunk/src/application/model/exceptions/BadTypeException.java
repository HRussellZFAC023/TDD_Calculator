package application.model.exceptions;

import application.model.Entry;

/**
 * An exception thrown by methods which require a specific data-type when an invalid data-type is
 * given.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Exception
 * @see Entry
 */
@SuppressWarnings("serial")
public class BadTypeException extends Exception {

  /**
   * Constructs a message as to why the exception was thrown.
   * 
   * @param message a message to explain why the type was invalid
   */
  public BadTypeException(String message) {
    super(message);
  }
}
