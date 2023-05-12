package com.yudit;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TableHeaderRow;
 
public class MicrocodeSheetApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("Microcode Editor");

        Label stateName = new Label("Name of macrostate: ");
        Label stateNum = new Label("Number of microstates: ");
        TextField nameField = new TextField();
        TextField numField = new TextField();
        Button button = new Button("Add macrostate");

        HBox hbox = new HBox(stateName, nameField, stateNum, numField, button);
        hbox.setMargin(stateName, new Insets(10, 5, 5, 0));
        hbox.setMargin(nameField, new Insets(5, 0, 0, 0));
        hbox.setMargin(stateNum, new Insets(10, 5, 5, 5));
        hbox.setMargin(numField, new Insets(5, 0, 0, 0));
        hbox.setMargin(button, new Insets(5, 0, 0, 5));

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().add(hbox);

        ScrollPane sp = new ScrollPane();
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);
        sp.setContent(vbox);
        sp.setPannable(true);
        sp.setPrefSize(720, 420);

        Scene scene = new Scene(sp);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
 
        stage.setScene(scene);
        stage.show();

        button.setOnAction(event -> {
            MacroState tableView = new MacroState(nameField.getText());
            int rows = Integer.parseInt(numField.getText());
            Button delButton = new Button("Delete macrostate");

            nameField.clear();
            numField.clear();

            ObservableList<MicroState> states = FXCollections.observableArrayList();
            for (int i=0; i<rows; i++) {
                states.add(new MicroState());
            }
            tableView.setItems(states);
            tableView.setFixedCellSize(35);
            TableHeaderRow header = (TableHeaderRow) tableView.lookup("TableHeaderRow");
            double height = ((states.size()+0.8)*tableView.getFixedCellSize()) + tableView.getInsets().getTop() + tableView.getInsets().getBottom() + (header == null ? 0 : header.getHeight());
            tableView.setMinHeight(height);
            tableView.setMaxHeight(height);
            tableView.setPrefHeight(height);
            tableView.setItems(states);
            
            HBox labelButton = new HBox();
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            labelButton.getChildren().addAll(tableView.getLabel(), spacer, delButton);
            vbox.getChildren().add(vbox.getChildren().size()-1, labelButton);
            vbox.getChildren().add(vbox.getChildren().size()-1, tableView);

            delButton.setOnAction(delEvent -> {
                int index = vbox.getChildren().indexOf(labelButton);
                vbox.getChildren().remove(index);
                vbox.getChildren().remove(index);
            });
        });
    }
}