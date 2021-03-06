package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import application.model.CalcModel;
import application.model.PostfixCalc;
import application.model.exceptions.BadExpressionException;
import application.model.exceptions.BadTypeException;
import application.model.exceptions.EmptyStackException;
import junit.textui.TestRunner;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class for methods of the PostfixCalc class.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see PostfixCalc
 * @see TestRunner
 */

public class TestPostfixCalc {

  private PostfixCalc calc;
  private CalcModel model;


  /**
   * Create a PostfixCalc for testing.
   */
  @Before
  public void createRevPolishCalcObject() {
    calc = new PostfixCalc();
    model = new CalcModel();
  }

  /**
   * Tests for proper evaluation of expressions with +,-, * and/or +.
   * 
   * @throws BadTypeException       thrown when a Symbol is of the wrong type
   * @throws BadExpressionException when expression is invalid
   * @throws EmptyStackException    when expected token is not contained next
   */
  @Test
  public void shouldEvaluateAPostfixString()
      throws BadTypeException, BadExpressionException, EmptyStackException {
    assertEquals(22, calc.evaluate(model.parseString("10 12 +")), 0.0);
    assertEquals(calc.evaluate(model.parseString("10 12 -")), -2, 0.0);
    assertEquals(20, calc.evaluate(model.parseString("10 2 * ")), 0.0);
    assertEquals(5, calc.evaluate(model.parseString("10 2 / ")), 0.0);
    assertEquals(36, calc.evaluate(model.parseString("3 10 2 + * ")), 0.0);
  }

  @Test
  public void shouldEvaluateDecimalString()
      throws BadExpressionException, BadTypeException, EmptyStackException {
    assertEquals(5.7f, calc.evaluate(model.parseString("2.5 3.2 +")), 0.0);
  }


  @Test
  public void shouldThrowExceptionsOnInvalidInput() throws BadTypeException, EmptyStackException {
    try {
      calc.evaluate(model.parseString(""));
      fail("Cannot evaluate empty expression");
    } catch (BadExpressionException err) {
      assertEquals("Calculating should throw exception on empty string",
          "Expression is malformed, expected operator or number.", err.getMessage());
    }

    try {
      calc.evaluate(model.parseString(""));
      fail("Cannot evaluate empty expression");
    } catch (BadExpressionException err) {
      assertEquals("Calculating should throw exception on empty string",
          "Expression is malformed, expected operator or number.", err.getMessage());
    }

    try {
      calc.evaluate(model.parseString(" "));
      fail("Cannot evaluate empty expression");
    } catch (BadExpressionException err) {
      assertEquals("Calculating should throw exception on empty string",
          "Expression is malformed, expected operator or number.", err.getMessage());
    }

    try {
      calc.evaluate(model.parseString(""));
      fail("Cannot evaluate empty expression");
    } catch (BadExpressionException err) {
      assertEquals("Calculating should throw exception on empty string",
          "Expression is malformed, expected operator or number.", err.getMessage());
    }

    try {
      calc.evaluate(model.parseString("9+3 bdfsf dsfds"));
      fail("Cannot evaluate letters");
    } catch (BadExpressionException err) {
      assertEquals("Calculating should throw exception if it contains letters",
          "Expression is malformed, expected operator or number.", err.getMessage());
    }

    try {
      calc.evaluate(model.parseString("9 + 3"));
      fail("Cannot evaluate letters");
    } catch (BadExpressionException err) {
      assertEquals("Calculating should throw exception if it contains letters",
          "Expression is malformed, expected operator or number.", err.getMessage());
    }
  }

}
