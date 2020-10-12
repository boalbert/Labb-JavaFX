package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginStage1 extends Application {

    public void start(Stage stage) {

        stage.setTitle("Login");

        // Header
        Label lblHeader = new Label("Login");
        // Setting ID for stylesheet
        lblHeader.setId("header-text");

        // Email and Password
        TextField tfEmail = new TextField();
        tfEmail.setPromptText("E-Mail");
        PasswordField tfPassword = new PasswordField();
        tfPassword.setPromptText("Password");

        // Buttons
        Button btnCreateAccount = new Button("Create Account");
        btnCreateAccount.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // TODO Add functionality for Create account -> Go to Stage1.1
        btnCreateAccount.setOnAction(actionEvent -> {
            // Kod för att gå till Stage1.1CreateAccount
            CreateAccount createAccount = new CreateAccount();
            createAccount.start(stage);
        });

        Button btnExit = new Button("Exit");
        btnExit.setStyle("-fx-background-color: #bf2b2b");
        btnExit.setCancelButton(true);
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });


        Button btnLogin = new Button("Login");
        btnLogin.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnLogin.setOnAction(actionEvent -> {
            System.out.println("Username accepted");
            if (Controller.customerMap.containsKey(tfEmail.getText()))    {
                if (tfPassword.getText().equals(Controller.customerMap.get(tfEmail.getText()).getPassword())) {
                    System.out.println("Password accepted");
                    BookingStage2 bookingStage2 = new BookingStage2();
                    bookingStage2.start(stage);
                }
                else System.out.println("Invalid password");
            }
            else System.out.println("Denied");
        });


        // Created GridPane
        GridPane gridPane = new GridPane();

        // Formatting GridPane
        gridPane.setMinSize(400, 400);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Added placeholder text
        gridPane.add(lblHeader, 0, 0, 2, 1);
        // Centering lblHeader
        GridPane.setHalignment(lblHeader, HPos.CENTER);
        gridPane.setHalignment(btnExit, HPos.CENTER);


        // Textfields
        gridPane.add(tfEmail, 0, 1);
        gridPane.add(tfPassword, 1, 1);
        // Button
        gridPane.add(btnCreateAccount, 0, 2);
        gridPane.add(btnLogin, 1, 2);
        gridPane.add(btnExit,0,4);

        // Creating scene
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);

        // Setting stylesheet
        scene.getStylesheets().add("sample/stylesheet.css");

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if (key == KeyCode.ENTER)   {
                }
            }
        });

        btnLogin.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode key = keyEvent.getCode();
                if(key == KeyCode.ESCAPE)   {
                    stage.close();
                }
            }
        });

        stage.show();
    }
}
