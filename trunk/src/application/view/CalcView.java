package application.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Graphical MVC View, what the user sees when using the calculator. Launches
 * the GUI and components and communicates them to the controller.
 * 
 * @author Dave Cohen &ltd.cohen@cs.rhul.ac.ukgt
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * 
 * @see View
 */
public class CalcView extends Application implements View {
  // Button is an Observable JavaFX object.
  @FXML
  private TextField input;
  @FXML
  private TextField total;
  @FXML
  private Button btn = null;

  /////////////////////////////////////////////////////////////////////////////////
  // Block for creating an instance variable for others to use.
  //
  // Make it a JavaFX singleton. Instance is set by the javafx "initialize" method
  private static volatile CalcView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Creates a new thread if there is no instance.
   * 
   * @return new instance thread.
   */
  public static synchronized CalcView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(CalcView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }
  // End of special block
  /////////////////////////////////////////////////////////////////////////////////

  @Override
  public void start(Stage primaryStage) throws IOException {
    GridPane page = (GridPane) FXMLLoader.load(getClass().getResource("/application/view/View.fxml"));
    Scene scene = new Scene(page);
    scene.getStylesheets().add(getClass().getResource("/application/view/application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Calculator");
    primaryStage.show();
  }

  /**
   * Prepare for a calculate button event.
   * 
   * @param f functional observer
   */
  public void addCalcListener(Observer f) {
    btn.setOnAction(e -> f.tell());
  }

  /**
   * Retrieves the text from the input field.
   * 
   * @return the current values in the input box as a String.
   */
  public String getUserInput() {
    return input.getText();
  }

  /**
   * Sets the current value of the result box.
   * 
   * @param result to display on the in the result text field
   */
  public void setResult(String result) {
    total.setText(result);
  }

  @Override
  public void setError(Exception e) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText("Invalid expression");
    alert.setContentText(e.getClass().getSimpleName() + "\n" + e.getMessage());
    alert.showAndWait();
  }

}
