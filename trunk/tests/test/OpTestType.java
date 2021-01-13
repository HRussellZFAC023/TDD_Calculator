package test;

import application.model.OpType;
import org.junit.Test;

/**
 * Test class for the methods of the OpType class.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see OpType
 */
public class OpTestType {

  /**
   * Test 1, tests that an enum can be made to represent the following symbols Infix and Postfix
   * strings.
   * 
   */
  // Code implemented? All the consts in Op.
  @Test
  public void addAllNonNumberTokenSymbols() {
    OpType operation = OpType.INFIX;
    operation = OpType.POSTFIX;
    operation = OpType.INVALID;
  }
}
