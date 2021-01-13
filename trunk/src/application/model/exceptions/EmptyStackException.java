package application.model.exceptions;

import application.model.Stack;

/**
 * An exception thrown by the stack class if an entry is returned and the size
 * is zero.
 *
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Exception
 * @see Stack
 */
@SuppressWarnings("serial")
public class EmptyStackException extends Exception {
  /**
   * Constructs a message as to why the exception was thrown.
   *
   * @param message a message to explain why the type was invalid.
   */
  public EmptyStackException(String message) {
    super(message);

  }

}
