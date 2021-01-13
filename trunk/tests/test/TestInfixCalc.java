package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import application.model.CalcModel;
import application.model.InfixCalc;
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
 * @see RevPolishCalc
 * @see TestRunner
 */

public class TestInfixCalc {

  private InfixCalc calc;
  private CalcModel model;


  /**
   * Create a PostfixCalc for testing.
   */
  @Before
  public void createRevPolishCalcObject() {
    calc = new InfixCalc();
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
  public void shouldEvaluateAnInfixString()
      throws BadTypeException, BadExpressionException, EmptyStackException {
    assertEquals(22, calc.evaluate(model.parseString("10 + 12")), 0.0);
    assertEquals(calc.evaluate(model.parseString("10 - 12 ")), -2, 0.0);
    assertEquals(10, calc.evaluate(model.parseString("10 * 2 / 2")), 0.0);
    assertEquals(10, calc.evaluate(model.parseString("10 / 2 * 2")), 0.0);
  }

  /**
   * Tests for proper evaluation of expressions with ( ).
   * 
   * @throws BadTypeException       thrown when a Symbol is of the wrong type
   * @throws BadExpressionException when expression is invalid
   * @throws EmptyStackException    when expected token is not contained next
   */
  @Test
  public void shouldEvaluateAnInfixStringWithBrackets()
      throws BadTypeException, BadExpressionException, EmptyStackException {
    assertEquals(36f, calc.evaluate(model.parseString("3 * ( 10 + 2 ) ")), 0.0);
  }

  @Test
  public void shouldEvaluateDecimalString()
      throws BadExpressionException, BadTypeException, EmptyStackException {
    assertEquals(5.7f, calc.evaluate(model.parseString("2.5 + 3.2")), 0.0);
  }

  @Test
  public void shouldEvaluateWithoutSpaces()
      throws BadExpressionException, BadTypeException, EmptyStackException {
    assertEquals(5.7f, calc.evaluate(model.parseString("2.5+3.2")), 0.0);
    assertEquals(8.9f, calc.evaluate(model.parseString("2.5+(3.2*2)")), 0.0);

  }


  @Test
  public void shouldThrowExceptionsOnInvalidInput() throws BadTypeException {

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

  }

}
