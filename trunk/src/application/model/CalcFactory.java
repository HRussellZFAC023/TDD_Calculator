package application.model;

import application.controller.CalcController;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates calculator objects.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * 
 * @see CalcController
 * @see Calculator
 */
@SuppressWarnings("serial")
public class CalcFactory {
  private static Map<OpType, Calculator> validators = new HashMap<OpType, Calculator>() {
    {
      put(OpType.INFIX, new InfixCalc());
      put(OpType.POSTFIX, new PostfixCalc());

    }
  }; // map avoids if statements

  public static Calculator newInstance(OpType op) {
    return validators.get(op);
  }

}
