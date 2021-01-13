package application.model;

import application.controller.CalcController;
import application.model.exceptions.BadExpressionException;
import application.model.exceptions.BadTypeException;
import application.model.exceptions.EmptyStackException;
import application.view.CalcView;

/**
 * Manages the data and methods. Independent of UI.
 * 
 * @author Dave Cohen &ltd.cohen@cs.rhul.ac.ukgt
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * 
 * @see CalcController
 * @see CalcView
 */
public class CalcModel {

  private Calculator calc;
  private float answer = 1f;

  public String getValue() {
    return String.valueOf(answer);
  }

  public void evaluate(String[] axioms)
      throws BadExpressionException, BadTypeException, EmptyStackException {
    this.answer = calc.evaluate(axioms);
  }

  /**
   * If the last character in the function is an operator then its Postfix Message.
   * 
   * @implNote This method does validate the whole expression, only the last character. Further
   *           validation is expected later.
   * 
   * @param input user-input from the view
   * @return if a string is in infix notation or postfix notation
   */
  public OpType getStringType(String[] input) {
    if (input == null || input.length <= 2) {
      return OpType.INVALID;
    }
    String last = input[input.length - 1];
    if (Symbol.getOperators().contains(Symbol.getToken(last))) {
      return OpType.POSTFIX;
    }
    return OpType.INFIX;
  }

  /**
   * Splits the user input into String tokens based on spaces.
   * 
   * @param input user-input from the view
   * @return the String without spaces
   */
  public String[] parseString(final String input) {
    return Type.parseString(input);
  }


  public void setType(OpType type) {
    this.calc = CalcFactory.newInstance(type);
  }


}
