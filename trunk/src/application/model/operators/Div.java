package application.model.operators;

import application.model.Symbol;

/**
 * A class that subtracts divides numbes.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 */
public class Div implements Operator {

  @Override
  public float compute(float x, float y) {
    return x / y;
  }

  /**
   * Checks top of the stack when a TIMES or DIVIDE is to be put into the stack. If the stack top
   * includes a TIMES or DIVIDE then the operator will be popped.
   */
  @Override
  public boolean checkTop(String top) {
    return (top.equals(Symbol.DIVIDE.toString()) || top.equals(Symbol.TIMES.toString()));
  }

}
