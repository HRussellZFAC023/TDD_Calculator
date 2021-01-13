package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import application.model.CalcFactory;
import application.model.InfixCalc;
import application.model.OpType;
import application.model.PostfixCalc;
import org.junit.Test;


/**
 * Test class for the methods of the CalcFactory class.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see CalcFactory
 */
public class TestCalcFactory {


  /**
   * Test 1, tests the creation of an infix calculator using calcFactory.
   * 
   */
  // implemented map entry for factory
  @Test
  public void createInfixCalc() {
    assertTrue(CalcFactory.newInstance(OpType.INFIX) instanceof InfixCalc);
    assertFalse(CalcFactory.newInstance(OpType.INFIX) instanceof PostfixCalc);
    assertTrue(CalcFactory.newInstance(OpType.INVALID) == null);
  }

  /**
   * Test 2, tests the creation of an postfix calculator using calcFactory.
   * 
   */
  // implemented map entry for factory
  @Test
  public void createPostfixCalc() {
    assertTrue(CalcFactory.newInstance(OpType.POSTFIX) instanceof PostfixCalc);
    assertFalse(CalcFactory.newInstance(OpType.POSTFIX) instanceof InfixCalc);
    assertNull(CalcFactory.newInstance(OpType.INVALID));
  }
}
