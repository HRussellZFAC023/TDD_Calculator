package application.model.operators;

import application.model.Symbol;

/**
 * A class that subtracts two numbes.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 */
public class Sub implements Operator {

  @Override
  public float compute(float x, float y) {
    return x - y;
  }

  /**
   * Checks top of the stack when a LEFTBRACKET is to be put into the stack. If the stack top
   * includes a LEFTBRACKET then the operator will be popped.
   */
  @Override
  public boolean checkTop(String top) {
    return !top.equals(Symbol.LEFTBRACKET.toString());
  }

}
