package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import application.model.Entry;
import application.model.Symbol;
import application.model.exceptions.BadTypeException;

import org.junit.Test;

/**
 * Test class for the Symbol enum.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Symbol
 */
public class TestSymbol {

  Entry symEntry;

  /**
   * Test 1, tests that an enum can be made to represent the following symbols ( ) * / + -.
   * 
   * @throws BadTypeException if symbol is of type invalid.
   */
  // Code implemented? All the consts in enum.
  @Test
  public void addAllNonNumberTokenSymbols() throws BadTypeException {
    symEntry = new Entry(Symbol.LEFTBRACKET);
    symEntry = new Entry(Symbol.RIGHTBRACKET);
    symEntry = new Entry(Symbol.TIMES);
    symEntry = new Entry(Symbol.DIVIDE);
    symEntry = new Entry(Symbol.PLUS);
    symEntry = new Entry(Symbol.MINUS);
  }

  /**
   * Test 2, Tests that if an invalid symbol is used as an entry, an error is thrown.
   */
  // Code implemented? Invalid const in enum and Updated the constructor in Entry
  // to throw error if
  // symbol is invalid.
  @Test
  public void throwErrorIfSymbolIsInvalidWithGoodErrorMessage() {
    try {
      new Entry(Symbol.INVALID);
      fail("An exception should be thrown when an Entry is created using an invalid symbol");
    } catch (Exception err) {
      assertEquals("An error should be shown if an entry is created with an invalid symbol",
          "BadTypeException: You cannot create an entry using an invalid symbol", err.getMessage());
    }
  }

  /**
   * Test 3, tests retrieval of the correct ascii symbol when given an enum.
   */
  @Test
  public void returnItsChar() {
    assertEquals(Symbol.DIVIDE.getChar(), '/');
  }

  /**
   * Test 4, tests retrieval of the correct ennum symbol when given an ascii symbol.
   */
  @Test
  public void assignSymbol() {
    assertEquals(Symbol.DIVIDE, Symbol.getToken('/'));
    assertEquals(Symbol.INVALID, Symbol.getToken('?'));
    assertNotEquals(Symbol.DIVIDE, Symbol.getToken('@'));
    assertNotEquals(Symbol.INVALID, Symbol.getToken('+'));
  }

  /**
   * Test 5, tests toString method of symbol.
   */
  @Test
  public void assignSymbolString() {
    assertEquals(Symbol.DIVIDE.toString(), "/");
  }
}
