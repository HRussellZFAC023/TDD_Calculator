package application.model.exceptions;

import application.model.CalcModel;

/**
 * An exception that is thrown when an expression does not follow a valid infix
 * or postfix pattern.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Exception
 * @see CalcModel
 */
@SuppressWarnings("serial")
public class BadExpressionException extends Exception {

  /**
   * Constructs the exception while taking in an explanation for why the exception
   * was thrown.
   * 
   * @param message explain why the type was invalid
   */
  public BadExpressionException(String message) {
    super(message);
  }

}