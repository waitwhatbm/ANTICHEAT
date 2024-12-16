package com.example.kursach;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.synedra.validatorfx.Check;

public class HelloController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private TextArea TextArea;
    @FXML
    private TextField SaveArea;
    @FXML
    private TextField Result;
    @FXML
    private URL location;
    @FXML
    private Button CheckButton;

    @FXML
    private Button SaveButton;
    @FXML
    void initialize() {
        // while (true) {
        SaveButton.setOnAction(event -> {
            String userProgram = TextArea.getText();
            CurrentlyFileRedactor.writeToFile(Handler.getPathToFile(), userProgram);
            if (Handler.HandleFunc()>= 60 || userProgram.length()<=100) {
                SaveArea.setText("Similarity! Don`t save!");
            } else {
                CurrentlyFileRedactor.saveTextToFile(Integer.toString(Handler.GetFileCounter())+".txt", userProgram);
                SaveArea.setText("Saved!");
            }
        });
        CheckButton.setOnAction(event -> {
            String userProgram = TextArea.getText();
            CurrentlyFileRedactor.writeToFile(Handler.getPathToFile(), userProgram);
            System.out.println("Button clicked! User program: " + userProgram);
            Result.setText(Integer.toString(Handler.HandleFunc()) + "%");
        });
        //}
    }

}
