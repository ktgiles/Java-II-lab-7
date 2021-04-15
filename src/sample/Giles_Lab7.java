/* Kaitlin Giles, Lab 7, 04/15/2021
Create Interactive Calculator
 */

package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Giles_Lab7 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane(); //create gridpane
        grid.setMinSize(400, 250);
        grid.setHgap(10);
        grid.setVgap(10);

        //create first input field and add to grid
        Text t1 = new Text("Input number:");
        TextField tf1 = new TextField();
        grid.add(t1, 0, 0);
        grid.add(tf1, 1, 0);

        //create second input field and add to grid
        Text t2 = new Text("Input number:");
        TextField tf2 = new TextField();
        grid.add(t2, 0, 1);
        grid.add(tf2, 1, 1);

        //create text labeling buttons and add to grid
        Text t4 = new Text("Select function:");
        grid.add(t4, 4, 0);

        //create button and add to grid
        Button add = new Button("Add");
        add.setPrefSize(50, 20);
        grid.add(add, 4, 1);

        //create button and add to grid
        Button sub = new Button("Subtract");
        grid.add(sub, 4, 2);

        //create button and add to grid
        Button mult = new Button("Multiply");
        grid.add(mult, 4, 3);

        //create button and add to grid
        Button div = new Button("Divide");
        grid.add(div, 4, 4);

        //create output field and add to grid
        Text t3 = new Text("Output:");
        TextField tf3 = new TextField();
        grid.add(t3, 0, 4);
        grid.add(tf3, 1, 4);

        //create error message field (invisible by default)
        Text t5 = new Text("");
        grid.add(t5, 0, 5);

        //create checkbox for dark mode
        CheckBox cb = new CheckBox("Dark Mode");
        grid.add(cb,0,6);

        cb.selectedProperty().addListener((obs, wasSelected, isSelected) ->   {
            if (isSelected) { //switch to dark mode colors
                grid.setStyle("-fx-background-color: #3f4247");
                add.setStyle("-fx-background-color: black; -fx-text-fill: slategray; -fx-border-color: lightslategray; -fx-border-width: 2px;");
                sub.setStyle("-fx-background-color: black; -fx-text-fill: slategray; -fx-border-color: lightslategray; -fx-border-width: 2px;");
                div.setStyle("-fx-background-color: black; -fx-text-fill: slategray; -fx-border-color: lightslategray; -fx-border-width: 2px;");
                mult.setStyle("-fx-background-color: black; -fx-text-fill: slategray; -fx-border-color: lightslategray; -fx-border-width: 2px;");
                t1.setFill(Color.SLATEGRAY);
                t2.setFill(Color.SLATEGRAY);
                t3.setFill(Color.SLATEGRAY);
                t4.setFill(Color.SLATEGRAY);
                t5.setFill(Color.WHITE);
                cb.setTextFill(Color.SLATEGRAY);
                tf1.setStyle("-fx-control-inner-background: #686c75");
                tf2.setStyle("-fx-control-inner-background: #686c75");
                tf3.setStyle("-fx-control-inner-background: #686c75");
            }
            else { //restore default colors
                grid.setStyle(null);
                add.setStyle(null);
                sub.setStyle(null);
                div.setStyle(null);
                mult.setStyle(null);
                t1.setFill(Color.BLACK);
                t2.setFill(Color.BLACK);
                t3.setFill(Color.BLACK);
                t4.setFill(Color.BLACK);
                t5.setFill(Color.BLACK);
                tf1.setStyle(null);
                tf2.setStyle(null);
                tf3.setStyle(null);
                cb.setTextFill(Color.BLACK);
            }
        });

        //create scene and display grid/scene/stage
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        //set action for addition button
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent add) {
                if ((tf1.getText() == null) || (tf1.getText().isEmpty()) || (tf2.getText() == null) || (tf2.getText().isEmpty())) {
                    t5.setText(""); //if either input is blank or null, do nothing
                }
                else {
                    try {
                        Double num1 = Double.parseDouble(tf1.getText()); //get first input as double
                        Double num2 = Double.parseDouble(tf2.getText()); //get second input as double
                        tf3.setText(String.valueOf(num1 + num2)); //print sum in output textfield
                        t5.setText(""); //make or leave fifth text box invisible
                    }
                    catch (NumberFormatException ex) { //if either input is not a double
                        t5.setText("Error: Numeric Input Expected."); //print error message in fifth text box
                    }
                }
            }
        });

        //set action for subtraction button
        sub.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent add) {
                if ((tf1.getText() == null) || (tf1.getText().isEmpty()) || (tf2.getText() == null) || (tf2.getText().isEmpty())) {
                    t5.setText(""); //if either input is blank or null, do nothing
                }
                else {
                    try {
                        Double num1 = Double.parseDouble(tf1.getText()); //get first input as double
                        Double num2 = Double.parseDouble(tf2.getText()); //get second input as double
                        tf3.setText(String.valueOf(num1 - num2)); //print difference in output textfield
                        t5.setText(""); //make or leave fifth text box invisible
                    }
                    catch (NumberFormatException ex) { //if either input is not an double
                        t5.setText("Error: Numeric Input Expected."); //print error message in fifth text box
                    }
                }
            }
        });

        //set action for multiply button
        mult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent add) {
                if ((tf1.getText() == null) || (tf1.getText().isEmpty()) || (tf2.getText() == null) || (tf2.getText().isEmpty())) {
                    t5.setText(""); //if either input is blank or null, do nothing
                }
                else {
                    try {
                        Double num1 = Double.parseDouble(tf1.getText()); //get first input as double
                        Double num2 = Double.parseDouble(tf2.getText()); //get second input as double
                        tf3.setText(String.valueOf(num1 * num2)); //print product in output textfield
                        t5.setText(""); //make or leave fifth text box invisible
                    }
                    catch (NumberFormatException ex) { //if either input is not an double
                        t5.setText("Error: Numeric Input Expected."); //print error message in fifth text box
                    }
                }
            }
        });

        //set action for divide button
        div.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent add) {
                if ((tf1.getText() == null) || (tf1.getText().isEmpty()) || (tf2.getText() == null) || (tf2.getText().isEmpty())) {
                    t5.setText(""); //if either input is blank or null, do nothing
                }
                else {
                    try {
                        Double num1 = Double.parseDouble(tf1.getText()); //get first input as double
                        Double num2 = Double.parseDouble(tf2.getText()); //get second input as double
                        tf3.setText(String.valueOf(num1 / num2)); //print quotient in output textfield
                        t5.setText(""); //make or leave fifth text box invisible
                    }
                    catch (NumberFormatException ex) { //if either input is not an double
                        t5.setText("Error: Numeric Input Expected."); //print error message in fifth text box
                    }
                }
            }
        });
    }
        //launch
        public static void main (String[]args){
            launch(args);
        }
}
