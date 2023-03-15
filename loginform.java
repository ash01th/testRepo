
Conversation opened. 1 unread message.
package com.example.ca2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.stage.Popup;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to
import static javafx.application.Application.launch;

public class HelloController extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("successful");
        // create a popup
        Popup popup = new Popup();

        // set background
        label.setStyle(" -fx-background-color: white;");

        // add the label
        popup.getContent().add(label);

        // set size of label
        label.setMinWidth(80);
        label.setMinHeight(50);

        //creating label email
        Text text1 = new Text("Username");
        Text text11 = new Text("Username");
        //creating label password
        Text text2 = new Text("Password");
        Text text22 = new Text("Password");
        //Creating Text Filed for email
        TextField textField1 = new TextField();
        TextField textField11 = new TextField();
        //Creating Text Filed for password
        TextField textField2 = new TextField();
        TextField textField22 = new TextField();
        //Creating Buttons
        Button button1 = new Button("Submit");
        Button button2 = new Button("Clear");
        Button button3 = new Button("Signup");
        Button button4 = new Button("create");
        //Creating a Grid Pane
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setContentText("successfull");
        Text scenetitle = new Text("Login");
        scenetitle.setFont(Font.font("Blue", FontWeight.SEMI_BOLD, 30))
        ;
        Text scenetitle2 = new Text("signup");
        scenetitle2.setFont(Font.font("Blue", FontWeight.SEMI_BOLD, 30));

        GridPane gridPane = new GridPane();
        GridPane gridPane1 = new GridPane();
        //Setting size for the pane
        gridPane.setMinSize(600, 400);
        gridPane1.setMinSize(600, 400);
        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane1.setPadding(new Insets(10, 10, 10, 10));
        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane1.setHgap(5);
        gridPane1.setVgap(5);
        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);
        gridPane1.setAlignment(Pos.CENTER);
        //Arranging all the nodes in the grid
        gridPane.add(scenetitle, 0, 0);
        gridPane.add(text1, 0, 1);
        gridPane.add(textField1, 1, 1);
        gridPane.add(text2, 0, 2);
        gridPane.add(textField2, 1, 2);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);
        gridPane.add(button3, 0, 4);

        gridPane1.add(scenetitle2, 0, 0);
        gridPane1.add(text11, 0, 1);
        gridPane1.add(textField11, 1, 1);
        gridPane1.add(text22, 0, 2);
        gridPane1.add(textField22, 1, 2);
        button1.setOnAction(e -> {
            try {
                File myObj = new File("new.txt");
                Scanner myReader = new Scanner(myObj);
                myReader.nextLine();
                String usr = textField1.getText();
                String pass = textField2.getText();
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String datas[] = data.split(",");
                    if (usr.equals(datas[0])) {
                        if (pass.equals(datas[1])) {
                            a.setContentText("successful");
                            a.setAlertType(Alert.AlertType.INFORMATION);
                            a.show();
                        }
                        else{
                            a.setContentText("unsuccessful");
                            a.setAlertType(Alert.AlertType.INFORMATION);
                            a.show();
                        }
                    }
                    else{
                        a.setContentText("unsuccessful");
                        a.setAlertType(Alert.AlertType.INFORMATION);
                        a.show();
                    }
                }
                myReader.close();
            } catch (FileNotFoundException ee) {
                System.out.println("An error occurred.");
                ee.printStackTrace();
            }
        });
        button2.setOnAction(e->{
            textField1.setText("");
            textField2.setText("");
        });
        gridPane1.add(button4, 1, 3);
        button4.setOnAction(e -> {
            try {
                BufferedWriter out = new BufferedWriter(
                        new FileWriter("new.txt", true));
                String s = "";
                Pattern pattern = Pattern.compile("[0-9][0-9][pP][CWTDcwtd][0-4][0-9]", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(textField11.getText());
                boolean matchFound = matcher.find();
                if(!matchFound)
                {
                    a.setContentText("This login is only students of amcs dept");
                    a.setAlertType(Alert.AlertType.INFORMATION);
                    a.show();
                }
                else
                {
                    s += "\n" + textField11.getText() + "," + textField22.getText();
                    out.write(s);
                }

                // Closing the connection
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        //Creating a scene object
        Scene scene = new Scene(gridPane);
        //Setting title to the Stage
        stage.setTitle("Grid Pane Example");
        Scene scene2 = new Scene(gridPane1);
        //Adding scene to the stage
        stage.setScene(scene);
        button3.setOnAction(e -> stage.setScene(scene2));
        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }

}
