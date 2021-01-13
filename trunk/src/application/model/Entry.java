package application.model;

import application.model.exceptions.BadTypeException;

/**
 * Represents an entry into the Stack. The entry can be of type float, String or
 * Symbol.
 *
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 */
public class Entry {

  private float number;
  private Symbol symbol;
  private Type type;

  /**
   * Constructs a Entry and assigns it a number.
   *
   * @param number the numerical value of the stack Entry.
   */
  public Entry(float number) {
    this.number = number;
    this.type = Type.NUMBER;
  }

  /**
   * Constructs a Entry and assigns it a Symbol.
   *
   * @param symbol the symbol value of the stack Entry.
   */
  public Entry(Symbol symbol) throws BadTypeException {
    String message = "BadTypeException: You cannot create an entry using an invalid symbol";
    if (symbol.equals(Symbol.INVALID)) {
      throw new BadTypeException(message);
    }
    this.type = Type.SYMBOL;
    this.symbol = symbol;
  }

  /**
   * Constructs an invalid Entry and throws and error.
   *
   * @param o an invalid parameter.
   */
  public Entry(Object o) throws BadTypeException {
    this.type = Type.INVALID;
    throw new BadTypeException("BadTypeException: Entry is of an invalid type");
  }

  /**
   * Returns the entry number so long as it is a float.
   *
   * @return the private number field
   */
  public float getValue() throws BadTypeException {
    checkType("number", Type.NUMBER);
    return number;
  }

  /**
   * Updates the entry with a float value.
   *
   * @param number update the number field.
   * @throws BadTypeException if the entry is not of the expected type.
   */
  public void setValue(float number) throws BadTypeException {
    checkType("number", Type.NUMBER);
    this.number = number;
  }


  /**
   * Returns the entry symbol so long as it is a symbol.
   *
   * @return the private symbol field.
   */
  public Symbol getSymbol() throws BadTypeException {
    checkType("symbol", Type.SYMBOL);
    return symbol;
  }

  /**
   * Updates the entry with a symbol value.
   *
   * @param symbol update the symbol field.
   * @throws BadTypeException if the entry is not of the expected type.
   */
  public void setSymbol(Symbol symbol) throws BadTypeException {
    checkType("symbol", Type.SYMBOL);
    this.symbol = symbol;
  }

  /**
   * Checks whether an entry is of a valid type - if it isn't, an exception is
   * thrown.
   *
   * @param message   the expected type as a string for error message.
   * @param assertion the expected type as enum.
   * @throws BadTypeException if the entry is not of the expected type.
   */
  private void checkType(String message, Type assertion) throws BadTypeException {
    if (this.type != assertion) {
      throw new BadTypeException("BadTypeException: Entry does not contain a " + message);
    }

  }

  /**
   * Returns an index-able code from the object. Auto-generated.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Float.floatToIntBits(number);
    return result;
  }

  /**
   * Returns whether an object is equal to another. Auto-generated.
   *
   * @param obj object to compare against
   * @return true if this and obj have the same field values.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number);
  }

  /**
   * Returns an entry in String format.
   *
   * @return an entry as a String
   */
  @Override
  public String toString() {
    if (type == Type.NUMBER) {
      return Float.toString(number);
    } else if (type == Type.SYMBOL) {
      return this.symbol.toString();
    } else {
      throw new IllegalArgumentException("Invalid argument given.");
    }
  }

}
