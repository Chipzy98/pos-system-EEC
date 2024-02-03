package edu.icet.crm.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCustomerForm {
    @FXML
    private AnchorPane pane7;
    @FXML
    private TextField cusnametxt;

    @FXML
    private TextField cusidtxt;

    @FXML
    private TextField cusemailtxt;

    @FXML
    private TextField cusmnumtxt;

    @FXML
    private Button savebtn;

    @FXML
    private Button clearbtn;

    @FXML
    private TextField cuspswtxt;

    @FXML
    private Button backbtn;

    @FXML
    void BackbuttonOnAction(ActionEvent event) {
        Stage stage = (Stage) pane7.getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    void ClearbuttonOnAction(ActionEvent event) {

    }

    @FXML
    void SavebuttonOnAction(ActionEvent event) {

    }

}//last