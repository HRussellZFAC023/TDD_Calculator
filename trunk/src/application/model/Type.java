package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An enum to represent the type of an entry, whether it is a NUMBER, SYMBOL, STRING or INVALID.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Entry
 */
public enum Type {
  NUMBER, SYMBOL, INVALID;

  /**
   * Determines if a string is an symbol, number or invalid.
   * 
   * @return if a string is an symbol, number or invalid
   */
  public static Type getType(String s) {
    if (s.length() == 1 && Symbol.getToken(s) != Symbol.INVALID) {
      return Type.SYMBOL;
    }

    boolean number = true;
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.') {
        number = false;
      }
    }

    return number ? NUMBER : INVALID;

  }

  /**
   * Splits the user input into String tokens based on spaces.
   * 
   * @param input user-input from the view
   * @return the String without spaces
   * @author adapted from
   *         https://stackoverflow.com/questions/35042087/split-a-infix-string-to-an-array-of-string-in-java
   */
  public static String[] parseString(final String input) {
    if (input.length() == 0) {
      return null; // input is null so parsed input should also be null
    }
  
    List<String> tokens = new ArrayList<>();
    // Add the first character to a new token. We make the assumption
    // that the string is not empty.
    tokens.add(Character.toString(input.charAt(0)));
    boolean space = false;
    // Now iterate over the rest of the characters from the input string.
    for (int i = 1; i < input.length(); i++) {
      char ch = input.charAt(i); // Store the current character.
      char lch = input.charAt(i - 1); // Store the last character.

      if (Character.isSpaceChar(ch)) {
        space = true;
        continue;
      }

      // We're checking if the last character is either a digit or the
      // dot, AND if the current character is either a digit or a dot.
      if ((!space) && (Character.isDigit(ch) || ch == '.')
          && (Character.isDigit(lch) || lch == '.')) {
        // If so, add the current character to the last token.
        int lastIndex = (tokens.size() - 1);
        tokens.set(lastIndex, tokens.get(lastIndex) + ch);
      } else {
        // Otherwise, add the current character to a new token.
        space = false;
        tokens.add(Character.toString(ch));
      }
    }
    Object[] o = tokens.toArray();
    return Arrays.copyOf(o, o.length, String[].class);
  }

}
