package com.yudit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableCell;

public class DataSheetApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    TableView tableView = new TableView();
    tableView.setEditable(true);
    
    TableColumn<Person, String> column1 = new TableColumn<>("First Name");
    column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    column1.setCellFactory(TextFieldTableCell.forTableColumn());
    
    TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
    column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    
    tableView.getColumns().add(column1);
    tableView.getColumns().add(column2);
    
    tableView.getItems().add(new Person("John"  , "Doe"));
    tableView.getItems().add(new Person("Jane"  , "Deer"));
    tableView.getItems().add(new Person("Dinesh", "Gupta"));

    VBox vbox = new VBox(tableView);

    Scene scene = new Scene(vbox);

    primaryStage.setScene(scene);

    primaryStage.show();
  }

}