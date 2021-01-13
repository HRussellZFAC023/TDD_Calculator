package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import application.model.Entry;
import application.model.Type;
import application.model.exceptions.BadTypeException;

import org.junit.Test;

/**
 * Test class for the Type enum class.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Type
 */
public class TestType {

  /**
   * Test 1, tests that the toString method presents the enum in a readable way.
   */
  // Code implemented? toString() method in type.
  @Test
  public void shouldPresentNumberTypesAsNmber() {
    Type testType = Type.NUMBER;
    String expStr = "NUMBER";
    assertEquals("Type should return its name in the toString() method", expStr,
        testType.toString());
  }

  /**
   * Test 2, tests that an error is thrown if an invalid type is used in the Entry class.
   * 
   * @throws BadTypeException if an entry of an invalid type is made.
   */
  // Code implemented? A constructor that accepts generic objects and throws errors.
  @Test
  public void shouldThrowErrorIfEntryOfTypeInvalidWithGoodErrorMessage() throws BadTypeException {
    try {
      new Entry(true);
      fail("Type should throw an error if it is invalid");
    } catch (BadTypeException err) {
      assertEquals("Type should throw a good error message if it is invalid",
          "BadTypeException: Entry is of an invalid type", err.getMessage());
    }
  }

  /**
   * Test 3, tests we can determin if a string is a symbol, number or invalid.
   */
  // Code implemented? getType() method in type.
  @Test
  public void shouldReturnCorrectTypeOfString() {
    assertEquals(Type.getType("+"), Type.SYMBOL);
    assertEquals(Type.getType("-"), Type.SYMBOL);
    assertEquals(Type.getType("?"), Type.INVALID);
    assertEquals(Type.getType("10"), Type.NUMBER);
    assertEquals(Type.getType("2343"), Type.NUMBER);
    assertEquals(Type.getType("2.5"), Type.NUMBER);
  }

}
