package edu.icet.crm.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ViewOrderReportForm {
    @FXML
    private AnchorPane pane3;
    @FXML
    private Button backbtn;

    @FXML
    private TableView<?> vieworderreportTable;

    @FXML
    private TableColumn<?, ?> oid;

    @FXML
    private TableColumn<?, ?> pid;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private TableColumn<?, ?> cnumber;

    @FXML
    private TableColumn<?, ?> pprice;

    @FXML
    private TableColumn<?, ?> qty;

    @FXML
    private Button refreshbtn;

    @FXML
    void BackbuttonOnAction(ActionEvent event) {

    }

    @FXML
    void RefreshbuttonOnAction(ActionEvent event) {

    }

}
