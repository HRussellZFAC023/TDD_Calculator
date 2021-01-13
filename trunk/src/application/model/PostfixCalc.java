package application.model;

import application.controller.CalcController;
import application.model.exceptions.BadExpressionException;
import application.model.exceptions.BadTypeException;
import application.model.exceptions.EmptyStackException;
import application.model.operators.Operator;

/**
 * The class used to evaluate postfix string expression using the parents' evaluation method. Uses
 * the stack to store the float values found in the string.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * 
 * @see CalcController
 * @see Calculator
 * @see Stack
 */
public class PostfixCalc implements Calculator {

  private Stack numStack;

  /**
   * Constructor initialising stack for floats.
   */
  public PostfixCalc() {
    numStack = new Stack();
  }

  /**
   * Evaluates a postfix expression by pushing numbers to the stack till operator then pops and
   * performs calculation.
   * 
   * @return the evaluation of a postfix expression
   */
  @Override
  public float evaluate(String[] expression) throws BadExpressionException, BadTypeException {

    if (expression == null) { // defensive check
      throw new BadExpressionException("Expression is malformed, expected operator or number.");
    }

    for (String s : expression) {
      if (Type.getType(s) == Type.NUMBER) {
        numStack.push(new Entry(Float.parseFloat(s)));
      } else if (s.length() == 1 && Type.getType(s) == Type.SYMBOL) {

        try {
          float operand2 = numStack.pop().getValue();
          float operand1 = numStack.pop().getValue();

          Operator op = operators.get(s);
          numStack.push(new Entry(op.compute(operand1, operand2)));

        } catch (EmptyStackException e) {
          throw new BadExpressionException("Expression is malformed, expected operator or number.");

        }

      } else {
        throw new BadExpressionException("Expression is malformed, expected operator or number.");
      }
    }
    try {
      return numStack.pop().getValue();
    } catch (EmptyStackException e) {
      throw new BadExpressionException("Expression is malformed, expected operator or number.");
    }
  }

}
