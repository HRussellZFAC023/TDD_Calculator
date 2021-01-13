package application.model;

import application.model.exceptions.BadExpressionException;
import application.model.exceptions.BadTypeException;
import application.model.exceptions.EmptyStackException;
import application.model.operators.Add;
import application.model.operators.Div;
import application.model.operators.Mult;
import application.model.operators.Operator;
import application.model.operators.Sub;

import java.util.HashMap;
import java.util.Map;

/**
 * Visitor pattern, maps common methods for the infix and postfix calculators. Stategy pattern is
 * also used here as the type of calculator is determined at runtime.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see CalcModel
 */
@SuppressWarnings("serial")
public interface Calculator {

  /**
   * Map each symbol to its function.
   */
  Map<String, Operator> operators = new HashMap<String, Operator>() {
    {
      put(Symbol.PLUS.toString(), new Add());
      put(Symbol.MINUS.toString(), new Sub());
      put(Symbol.TIMES.toString(), new Mult());
      put(Symbol.DIVIDE.toString(), new Div());
    }
  }; // map avoids if statements

  /**
   * Evaluates an expression and returns the answer.
   * 
   * @param expression to be evaluated
   * @return answer to the expression
   * @throws BadTypeException       thrown during an unsuccessful evaluation due to an incorrect
   *                                type
   * @throws EmptyStackException    if there are too many operators
   * @throws BadExpressionException if the expression is malformed
   */

  float evaluate(String[] expression)
      throws BadExpressionException, BadTypeException, EmptyStackException;
}
