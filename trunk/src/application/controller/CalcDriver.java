package application.controller;

import application.model.CalcModel;
import application.view.CalcView;
import application.view.TextView;
import application.view.View;

/**
 * The main method entry point class which launches the calculator view.
 *
 * @author Dave Cohen &ltd.cohen@cs.rhul.ac.ukgt
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 *
 * @see CalcModel
 * @see CalcView
 * @see CalcController
 */
public class CalcDriver {

  /**
   * Initialize the calculator model, view and controller.
   * 
   * @param args command-line args
   */
  public static void main(String[] args) {
    CalcModel model = new CalcModel();
    View view;

    if (args.length == 0) {
      view = CalcView.getInstance(); // lauches graphical UI
    } else {
      view = new TextView(args); // launches text UI
    }

    new CalcController(model, view);

  }

}
