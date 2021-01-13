package application.model;

import java.util.EnumSet;

/**
 * A enum to represent the type of symbol entered by a user, either ( ) * / - or an error.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Symbol
 */
public enum Symbol {
  LEFTBRACKET('('), RIGHTBRACKET(')'), TIMES('*'), DIVIDE('/'), PLUS('+'), MINUS('-'), INVALID;

  private char sym;

  /**
   * Empty constructor for invalid type.
   */
  Symbol() {
  }

  /**
   * Creates a symbol entered by a user.
   * 
   * @param sym the symbol to be created.
   */
  Symbol(char sym) {
    this.sym = sym;
  }

  public final char getChar() {
    return sym;
  }

  /**
   * Represents the enum symbol as a string.
   * 
   * @return the ascii char symbol as a String.
   */
  @Override
  public final String toString() {
    return String.valueOf(sym);
  }

  /**
   * Assigns an enum to the correct symbol.
   * 
   * @param c a character to 'convert' to enum.
   */
  public static Symbol getToken(char c) {
    for (Symbol s : Symbol.values()) {
      if (s.getChar() == c) {
        return s;
      }
    }
    return Symbol.INVALID;

  }

  /**
   * Assigns an enum to the correct symbol.
   * 
   * @param c a String to 'convert' to enum.
   */
  public static Symbol getToken(String c) {
    for (Symbol s : Symbol.values()) {
      if (s.getChar() == c.charAt(0)) {
        return s;
      }
    }
    return Symbol.INVALID;

  }

  /**
   * Returns a set of all the operators.
   * 
   * @return set of PLUS, MINUS, TIMES, DIVIDE
   */
  public static EnumSet<Symbol> getOperators() {
    return EnumSet.of(PLUS, MINUS, TIMES, DIVIDE);
  }


}
