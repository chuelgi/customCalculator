package com.chuelgi.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;


public class CalculatorUI extends Application {
    private TextField inputField;
    Calculator cal;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        cal = new Calculator();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //text field
        inputField = new TextField();
        inputField.setEditable(false);
        gridPane.add(inputField, 0, 0, 4,1);


        Button btn0 = new Button("0");
        btn0.getStyleClass().add("number-button");
        btn0.setOnAction(e -> handleButtonInput("0"));

        Button btn1 = new Button("1");
        btn1.getStyleClass().add("number-button");
        btn1.setOnAction(e -> handleButtonInput("1"));

        Button btn2 = new Button("2");
        btn2.getStyleClass().add("number-button");
        btn2.setOnAction(e -> handleButtonInput("2"));

        Button btn3 = new Button("3");
        btn3.getStyleClass().add("number-button");
        btn3.setOnAction(e -> handleButtonInput("3"));

        Button btn4 = new Button("4");
        btn4.getStyleClass().add("number-button");
        btn4.setOnAction(e -> handleButtonInput("4"));

        Button btn5 = new Button("5");
        btn5.getStyleClass().add("number-button");
        btn5.setOnAction(e -> handleButtonInput("5"));

        Button btn6 = new Button("6");
        btn6.getStyleClass().add("number-button");
        btn6.setOnAction(e -> handleButtonInput("6"));

        Button btn7 = new Button("7");
        btn7.getStyleClass().add("number-button");
        btn7.setOnAction(e -> handleButtonInput("7"));

        Button btn8 = new Button("8");
        btn8.getStyleClass().add("number-button");
        btn8.setOnAction(e -> handleButtonInput("8"));

        Button btn9 = new Button("9");
        btn9.getStyleClass().add("number-button");
        btn9.setOnAction(e -> handleButtonInput("9"));

        Button subBtn = new Button("-");
        subBtn.getStyleClass().add("operation-button");
        subBtn.setOnAction(e -> handleOperator("-"));

        Button addBtn = new Button("+");
        addBtn.getStyleClass().add("operation-button");
        addBtn.setOnAction(e -> handleOperator("+"));

        Button divBtn = new Button("/");
        divBtn.getStyleClass().add("operation-button");
        divBtn.setOnAction(e -> handleOperator("/"));

        Button mulBtn = new Button("*");
        mulBtn.getStyleClass().add("operation-button");
        mulBtn.setOnAction(e -> handleOperator("*"));

        Button clearBtn = new Button("c");
        clearBtn.getStyleClass().add("operation-button");
        clearBtn.setOnAction(e -> handleClear());

        Button eqlBtn = new Button("=");
        eqlBtn.getStyleClass().add("equals-button");
        eqlBtn.setOnAction(e-> handleOperation(inputField.getText()));


        gridPane.add(btn0, 0, 1);
        gridPane.add(btn1, 1, 1);
        gridPane.add(btn2, 2, 1);
        gridPane.add(btn3, 3, 1);
        gridPane.add(btn4, 0, 2);
        gridPane.add(btn5, 1, 2);
        gridPane.add(btn6, 2, 2);
        gridPane.add(btn7, 3, 2);
        gridPane.add(btn8, 0, 3);
        gridPane.add(btn9, 1, 3);

        gridPane.add(subBtn, 2, 3);
        gridPane.add(addBtn, 3, 3);
        gridPane.add(divBtn, 0, 4);
        gridPane.add(mulBtn, 1, 4);
        gridPane.add(clearBtn, 2, 4);
        gridPane.add(eqlBtn, 3, 4);



        inputField.getStyleClass().add("input-field");

        gridPane.getStyleClass().add("grid-pane");

        Scene scene = new Scene(gridPane, 275, 350);
        inputField.requestFocus();

        //keyboard input

        
        scene.getStylesheets().add(getClass().getResource("calculatorStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();



    }
    /**
     * Handles appending to input field
     * Appends numbers to the input field.
     *
     * @param val click on by user.
     */
    private void handleButtonInput(String val){
        inputField.appendText(val);
    }

    /**
     * Handles the button click for operators (+, -, *, /).
     * Appends the operator surrounded by spaces to the input field.
     *
     * @param op The operator (+, -, *, /) clicked by the user.
     */
    private void handleOperator(String op){
        inputField.appendText(" " + op+" ");
    }

    /**
     * Handles operation
     * Computes operation using method from Calculator
     *
     * @param val The string created by the user.
     */
    private void handleOperation(String val){

        inputField.setText(String.valueOf(cal.evaluateExpression(val)));
    }
    
    private void handleKeyBoardInput(String key){
        if(Character.isDigit(key.charAt(0))){
            inputField.appendText(key);
        }
        else if(key.matches("[+\\-*/]")){
            inputField.appendText(" "+ key+" ");

        } else if (key.equals("=") || key.equals("\n")) {
            handleOperation(inputField.getText());

        } else if (key.equals("c") || key.equals("C")) {
            handleClear();

        }
    }

    /**
     * Handles clearing the input field
     *
     *
     *
     */
    private void handleClear(){
        inputField.setText("");
    }


    public static void main(String[] args){
        launch(args);
    }
}
