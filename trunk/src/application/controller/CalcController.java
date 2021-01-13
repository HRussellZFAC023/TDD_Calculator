package application.controller;

import application.model.CalcModel;
import application.model.OpType;
import application.model.exceptions.BadExpressionException;
import application.model.exceptions.BadTypeException;
import application.model.exceptions.EmptyStackException;
import application.view.CalcView;
import application.view.View;

/**
 * Accepts input and converts it to commands for the model or view. Carries out Business logic.
 * 
 * @author Dave Cohen &ltd.cohen@cs.rhul.ac.ukgt
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 *
 * @see CalcView
 * @see CalcModel
 */
public class CalcController {
  private CalcModel model;
  private View view;

  /**
   * Constructor for the controller, creates listeners for the evaluate button and infix postfix
   * radio buttons.
   *
   * @param model object for application data and methods.
   * @param view  object to manipulate the UI.
   */
  CalcController(CalcModel model, View view) {
    this.model = model;
    this.view = view;
    this.view.addCalcListener(() -> {
      try {
        this.handleCalculate();
      } catch (Exception e) {
        view.setError(e);
      }
    });

  }

  private void handleCalculate()
      throws BadExpressionException, BadTypeException, EmptyStackException {
    // get input
    String userInput = view.getUserInput();
    // parse
    String[] axioms = model.parseString(userInput);
    // handle type
    OpType type = model.getStringType(axioms);

    if (type.equals(OpType.INVALID)) {
      throw new BadExpressionException(
          "Expression is too short, Must be longer than two characters");
    }
    // Create calculator
    model.setType(type);
    // evaluate
    model.evaluate(axioms);
    // print
    view.setResult(model.getValue());
  }

}
