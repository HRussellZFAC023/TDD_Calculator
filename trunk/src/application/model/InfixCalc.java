package application.model;

import application.model.exceptions.BadExpressionException;
import application.model.exceptions.BadTypeException;
import application.model.exceptions.EmptyStackException;
import application.model.operators.Operator;

/**
 * The class used to evaluate infix string expression using an implementation of the parents'
 * evaluation method which converts infix input to postfix and uses the postfix calculators
 * evaluation method. Uses the stack to store the float values found in the string.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 */
public class InfixCalc implements Calculator {

  private Stack symbolStack;
  private PostfixCalc calc;

  private StringBuilder postfixString = new StringBuilder();

  /**
   * Constructor initialising stack for symbols and a postfix calculator.
   */
  public InfixCalc() {
    symbolStack = new Stack();
    calc = new PostfixCalc();
  }

  /**
   * Using Shunting Yard Algorithm, takes a String infix expression and converts it to a String
   * Postfix expression. The expression is then evaluated using the postfix evaluate method.
   *
   * @return the result after evaluating the postfix version of the expression using the
   *         ReversePolishCalc evaluate method.
   */
  public float evaluate(String[] expression) throws BadExpressionException, BadTypeException {

    if (expression == null) {
      throw new BadExpressionException("Expression is malformed, expected operator or number.");
    }

    for (String s : expression) {
      if (Type.getType(s) == Type.NUMBER) {
        postfixString.append(Float.parseFloat(s)).append(" ");
      } else if (s.length() == 1 && Type.getType(s) == Type.SYMBOL) {

        try {
          if (Symbol.LEFTBRACKET.toString().equals(s)) {
            symbolStack.push(new Entry(Symbol.LEFTBRACKET));

          } else if (Symbol.RIGHTBRACKET.toString().equals(s) && !symbolStack.isEmpty()) {

            while (!symbolStack.topStr().equals(Symbol.LEFTBRACKET.toString())) {
              postfixString.append(symbolStack.popStr()).append(" ");
            }
            symbolStack.pop(); // pop leftbracket

          } else {
            Operator visitor = operators.get(s); // s will be + or - or * or /
            if (!symbolStack.isEmpty() && visitor.checkTop(symbolStack.topStr())) {
              postfixString.append(symbolStack.popStr()).append(" ");
            }
            symbolStack.push(new Entry(Symbol.getToken(s)));
          }

        } catch (EmptyStackException e) {
          throw new BadExpressionException("Expression is malformed, expected operator or number.");
        }

      } else {
        throw new BadExpressionException("Expression is malformed, expected operator or number.");
      }
    }
    try {
      while (!symbolStack.isEmpty()) {
        postfixString.append(symbolStack.popStr()).append(" "); // append symbols after numbers
      }
    } catch (EmptyStackException e) {
      throw new BadExpressionException("Expression is malformed, expected operator or number.");
    }
    return (calc.evaluate(Type.parseString(postfixString.toString())));
  }


}
