package application.view;

import java.util.Scanner;

/**
 * Text-based MVC View, what the user sees when using the calculator. Launches the GUI and
 * components and communicates them to the controller.
 * 
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see View
 */
public class TextView implements View {
  private String args = "";
  private Scanner sc = new Scanner(System.in);
  private Observer inputEvent = null;

  /**
   * Constructor for the text. Sets the original value of the command line args to be the user
   * input.
   * 
   * @param args command line args.
   */
  public TextView(String[] args) {
    this.args = String.join("", args);
  }

  /**
   * Retrives input from the console. Initially it will return the original command line args, then
   * it will listen for further input.
   */
  @Override
  public String getUserInput() {
    if (args.isEmpty()) {
      args = sc.nextLine();
    }
    if (args.equals("help")) {
      System.out.println("\nThis is a calculator");
      System.out.println("\nSupported calculator modes infix, postfix (autodect)");
      System.out.println("\nSupported Operators \n+\n-\n*\n/\n()");
      args = sc.nextLine(); // wait for next line
    }
    if (args.equals("quit")) {
      System.exit(0);
    }
    return args;
  }

  /**
   * This method prints the result of the calculations to the console. After printing, the program
   * waits for next input
   */
  @Override
  public void setResult(String result) {
    args = "";
    System.out.println(result + "\n");
    while (!sc.hasNext()) {
    }
    inputEvent.tell(); // fires input event
  }

  /**
   * Prepare for an input event and fires initially as startup contained command line arguements.
   *
   * @see Observer
   * @param f functional observer
   **/
  @Override
  public void addCalcListener(Observer f) {
    this.inputEvent = f;
    inputEvent.tell();
  }

  @Override
  public void setError(Exception e) {
    System.err.println("\n error !\n");
    e.printStackTrace();
    System.out.println("\n For list of availible commnds, type help. To exit, type quit");
    setResult("");
  }

}
