package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import application.model.CalcModel;
import application.model.OpType;
import org.junit.Before;
import org.junit.Test;



/**
 * Test class for the methods of the Model class.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see CalcModel
 */
public class TheModelShouldBeAbleTo {

  private CalcModel model;

  @Before
  public void setup() {
    model = new CalcModel();
  }

  /**
   * Determines that the model can pasrse a string into lexus by spaces.
   */
  @Test
  public void parseAStringBySpaces() {
    String abc = "a b c";
    String[] splitAbc = {"a", "b", "c"};
    assertArrayEquals("The model should be able to split a string by quotes",
        model.parseString(abc), (splitAbc));
    String expression = "4  222 55 * + 1 3 2 * + /";
    String[] splitExpression = {"4", "222", "55", "*", "+", "1", "3", "2", "*", "+", "/"};
    assertArrayEquals("The model should be able to split a string by quotes",
        model.parseString(expression), (splitExpression));
  }

  /**
   * Determines that the model can pasrse a string into lexus by any characters.
   */
  @Test
  public void parseAStringBySymbolsAndSpaces() {
    String expression = "42*2+1-(3+2)*+/";
    String[] splitExpression =
        {"42", "*", "2", "+", "1", "-", "(", "3", "+", "2", ")", "*", "+", "/"};
    assertArrayEquals("The model should be able to split a string by quotes",
        model.parseString(expression), (splitExpression));
  }

  /**
   * Determines that a empty string is invalid.
   */
  @Test
  public void determineIfExpressionIsInvalid() {
    assertEquals("The model return that the expression type is invalid",
        model.getStringType(model.parseString("")), OpType.INVALID);
  }

  /**
   * Tests the program correctly identifies strings ending in an operator are postfix.
   */
  @Test
  public void determineIfExpressionIsInfixOrPostfix() {
    assertEquals(model.getStringType(model.parseString("1 +")), OpType.INVALID);
    assertEquals(model.getStringType(model.parseString("1 + 2")), OpType.INFIX);
    assertEquals(model.getStringType(model.parseString("1 + 2")), OpType.INFIX);

  }
}
