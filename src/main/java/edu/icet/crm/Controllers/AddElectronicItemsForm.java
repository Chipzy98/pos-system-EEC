package edu.icet.crm.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddElectronicItemsForm {
    @FXML
    private AnchorPane pane5;
    @FXML
    private TextField pnametxt;

    @FXML
    private TextField pidtxt;

    @FXML
    private TextField ppricetxt;

    @FXML
    private TextField pqtytxt;

    @FXML
    private TableView<?> electricalitemTable;

    @FXML
    private TableColumn<?, ?> pid;

    @FXML
    private TableColumn<?, ?> pname;

    @FXML
    private TableColumn<?, ?> pprice;

    @FXML
    private TableColumn<?, ?> pqty;

    @FXML
    private Button savebtn;

    @FXML
    private Button clearbtn;

    @FXML
    private Button refreshbtn;

    @FXML
    private Button Backbtn;

    @FXML
    void BackbuttonOnAction(ActionEvent event) {

    }

    @FXML
    void ClearbuttonOnAction(ActionEvent event) {

    }

    @FXML
    void RefreshbuttonOnAction(ActionEvent event) {

    }

    @FXML
    void SavebuttonOnAction(ActionEvent event) {

    }

}
