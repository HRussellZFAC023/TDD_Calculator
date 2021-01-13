package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import application.model.Entry;
import application.model.Stack;
import application.model.Symbol;
import application.model.exceptions.BadTypeException;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class for the values to be stored in the stack.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Entry
 * @see Stack
 */
public class AnEntryObjectShouldBeAbleTo {

  private Entry numberEntry;

  /**
   * Creates a new Entry of 5f before each test to be used for tests.
   */
  // Code implemented? Constructor and entry class. I started my TDD here.
  @Before
  public void addANewFloatValue() {
    numberEntry = new Entry(5f);
  }

  /**
   * Test 1, tests that entry returns its initial value 5f then 10f correctly.
   * 
   * @throws BadTypeException if the type of getValue() is not a float.
   */

  // Code implemented? A getter method, field for float.
  @Test
  public void returnItsInitialValue() throws BadTypeException {
    assertEquals("An entry object should be able to return its initial value of 5f", 5f,
        numberEntry.getValue(), 0.0);
    numberEntry = new Entry(10f);
    assertEquals("An entry object should be able to return its initial value of 10f", 10f,
        numberEntry.getValue(), 0.0);
  }

  /**
   * Test 2, tests that the entry returns its updated value of 0f correctly, then checks that the
   * entry returns its updated value of 7f correctly.
   * 
   * @throws BadTypeException if the type of getValue() is not a float.
   */
  // Code implemented? setValue() method which updates private field.
  // Once I had done this I created the stack class and tests for the stack as I had just enough to
  // add entries to a stack.
  @Test
  public void updateItsInitalValue() throws BadTypeException {
    numberEntry.setValue(0f);
    assertEquals("An entry object should be able return its updated value of 0f", 0f,
        numberEntry.getValue(), 0.0);
    numberEntry.setValue(7f);
    assertEquals("An entry object should be able return its updated value of 7f", 7f,
        numberEntry.getValue(), 0.0);
  }


  private Entry symEntry;

  /**
   * Instantiates a new entry with a symbol enum to be used in testing.
   * 
   * @throws BadTypeException if the symbol is an invalid type.
   */
  // Code implemented? Symbol enum and enumTest class.
  @Before
  public void addNewSymbolValue() throws BadTypeException {
    symEntry = new Entry(Symbol.DIVIDE);
  }

  /**
   * Test 5, tests that the entries with symbol values of Symbol.DIVIDE and Symbol.MINUS returns
   * symbol.Divide and Symbol.MINUS there getter getSymbol() is called.
   * 
   * @throws BadTypeException if the type of getSymbol() is an invalid type.
   */
  // Code implemented? Getter method returning hard-coded Symbol.DIVIDE then updated to have field.
  @Test
  public void returnItsInitialSymbolValue() throws BadTypeException {
    assertSame("An entry object should be able return its initial symbol value Symbol.DIVIDE",
        Symbol.DIVIDE, symEntry.getSymbol());
    symEntry = new Entry(Symbol.MINUS);
    assertSame("An entry object should be able return its initial symbol value Symbol.MINUS",
        Symbol.MINUS, symEntry.getSymbol());
  }

  /**
   * Test 6, tests that when setSymbol is called with Symbol.PLUS and Symbol.MINUS their respective
   * getters return the same symbol.
   * 
   * @throws BadTypeException if the type of getSymbol() is an invalid type.
   */
  // Code implemented? SetSymbol() method which updates the private field.
  @Test
  public void updateItsInitialSymbolValue() throws BadTypeException {
    symEntry.setSymbol(Symbol.PLUS);
    assertSame("An entry object should be able update its initial symbol value to Symbol.PLUS",
        Symbol.PLUS, symEntry.getSymbol());
    symEntry.setSymbol(Symbol.MINUS);
    assertSame("An entry object should be able update its initial symbol value to Symbol.MINUS",
        Symbol.MINUS, symEntry.getSymbol());
  }


  /**
   * Test 7, tests that an exception is thrown when an entry that does not contain a number is used
   * in getValue() method.
   */
  // Code implemented? A custom exception class with constructor so error message can be made.Type
  // enum class was also created here.
  @Test
  public void preventGetValueOnInvalidTypeAndGivesGoodErrorMessage() {
    try {
      symEntry.getValue();
      fail("An entry object should prevent getvalue() being called if only a symbol is stored");
    } catch (BadTypeException err) {
      assertEquals(
          "An entry object should throw an exception if getValue() is called with an invalid type",
          "BadTypeException: Entry does not contain a number", err.getMessage());
    }
  }


  /**
   * Test 9, tests that an exception is thrown when an entry that does not contain a symbol is used
   * in getSymbol() method.
   */
  // Code implemented? Updated getSymbol() to throw an error on invalid type.
  @Test
  public void preventGetSymbolOnInvalidTypeAndGivesGoodErrorMessage() {
    try {
      numberEntry.getSymbol();
      fail("An entry object should prevent getSymbol() being called if only a number is stored");
    } catch (BadTypeException err) {
      assertEquals(
          "An entry object should throw an exception if getSymbol() is called with an invalid type",
          "BadTypeException: Entry does not contain a symbol", err.getMessage());
    }
  }

  /**
   * Test 10, tests that an exception is thrown when a string entry or a symbol entry try to set a
   * numeric value of 9f.
   */
  // Code implemented? Updated setValue to throw error on invalid type.
  @Test
  public void preventSetValueOnBadTypesAndGiveGoodErrorMessage() {
    try {
      symEntry.setValue(9f);
      fail("An entry object should prevent setValue() being called if only a symbol is stored");
    } catch (BadTypeException err) {
      assertEquals(
          "An entry object should throw an exception if setValue() returns an invalid type",
          "BadTypeException: Entry does not contain a number", err.getMessage());
    }
  }

  /**
   * Test 12, Tests that an exception is thrown when a number entry or a string entry try to set a
   * symbol value of Symbol.DIVIDE.
   */
  // Code implemented? Updated getSymbol() to throw an error on invalid type.
  @Test
  public void preventSetSymbolOnBadTypesAndGiveGoodErrorMessage() {
    try {
      numberEntry.setSymbol(Symbol.DIVIDE);
      fail("An entry object should prevent setSymbol() being called if only a number is stored");
    } catch (BadTypeException err) {
      assertEquals(
          "An entry object should throw an exception if setSymbol() has an invalid return type",
          "BadTypeException: Entry does not contain a symbol", err.getMessage());
    }

  }

  private Entry val1;
  private Entry val2;
  private Entry sym1;
  private Entry sym2;

  /**
   * Setup 2 float, 2 string and 2 symbol Entries with the same values for testing.
   * 
   * @throws BadTypeException if the type of Symbol is an invalid type.
   */
  @Before
  public void createEntriesForEqualsTesting() throws BadTypeException {
    val1 = new Entry(5f);
    val2 = new Entry(5f);
    sym1 = new Entry(Symbol.DIVIDE);
    sym2 = new Entry(Symbol.DIVIDE);
  }

  /**
   * Test 13, tests the equals method returns true if and only if the fields are identical.
   */
  // Code implemented? Originally passed this test by hard coding a value of true for equals.
  @Test
  public void compareTwoValuesAreEqual() {
    assertEquals("An entry object equals method should return true if compared to the same object",
        val1, val1); // val1=val1
    assertEquals("Return true if compared to another object with the same value field", val1, val2);

    assertEquals("Return true if compared to another object with the same value field", val2, val1);

    assertEquals("An entry object equals method should return true if compared to the same object",
        sym1, sym1);
    assertEquals("Return true if compared to another object with the same symbol field", sym1,
        sym2);
    assertEquals("Return true if compared to another object with the same symbol field", sym2,
        sym1);
  }

  /**
   * Test 14, tests that the equals method returns false if the fields are not identical.
   */
  // Code implemented? Updated equals method to eclipses auto gen code.
  @Test
  public void compareTwoValuesAreNotEqual() {
    assertNotEquals("return false if compared to an object with different value fields", val1,
        sym1);
    assertNotEquals("return false if compared to an object with different value fields", sym1,
        val1);
    assertNotEquals("return false if compared to an object with different value fields", val1,
        null);
  }

  /**
   * Test 15, tests that hashCode is the same if two objects are the same or have identical fields.
   */
  // Code implemented? Eclipses autogenerated hashcode.
  @Test
  public void returnEqualHashCodeForEqualObjects() {
    // The same object should have the same hash code.
    assertEquals("An entry object hashcode method should return true if it has the same fields",
        val1.hashCode(), val1.hashCode());
    // Different Equals objects with the same fields should also have the same hash value.
    assertEquals("An entry object hashcode method should return true if it has the same fields",
        val1.hashCode(), val2.hashCode());
  }

  /**
   * Test 16, tests the toString method presents each entity in a readable way.
   */
  // Code implemented? Updated enum class to have constructor and fields. Created toSting in entry.
  @Test
  public void shouldPresentFieldsAsString() {
    assertEquals("An entry object toString should return its value", "5.0", numberEntry.toString());
    assertEquals("An entry object toString should return its symbol", "/", symEntry.toString());
  }

}
