package application.view;

import application.controller.CalcController;

/**
 * Common methods for both the text-ui and the graphical-ui. Bridge pattern.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * 
 * @see CalcController
 */
public interface View {
  void addCalcListener(Observer f);

  String getUserInput();

  void setResult(String result);

  void setError(Exception e);
}
