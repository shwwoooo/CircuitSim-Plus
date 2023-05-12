package com.yudit;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class MicrocodeSheetApplication extends Application {
    private MacroState fetchTable = new MacroState("FETCH");
    private MacroState decodeTable = new MacroState("DECODE");

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

        int numRow = 3;
        ObservableList<MicroState> data = FXCollections.observableArrayList();
        for (int i=0; i<numRow; i++) {
            data.add(new MicroState());
        }
        fetchTable.setItems(data);
        fetchTable.setFixedCellSize(35);
        TableHeaderRow headerRow = (TableHeaderRow) fetchTable.lookup("TableHeaderRow");
        double tableHeight = ((data.size()+0.8)*fetchTable.getFixedCellSize()) + fetchTable.getInsets().getTop() + fetchTable.getInsets().getBottom() + (headerRow == null ? 0 : headerRow.getHeight());
        fetchTable.setMinHeight(tableHeight);
        fetchTable.setMaxHeight(tableHeight);
        fetchTable.setPrefHeight(tableHeight);

        ObservableList<MicroState> data2 = FXCollections.observableArrayList();
        for (int i=0; i<numRow; i++) {
            data2.add(new MicroState());
        }
        decodeTable.setItems(data2);
        decodeTable.setFixedCellSize(35);
        TableHeaderRow headerRow2 = (TableHeaderRow) decodeTable.lookup("TableHeaderRow");
        double tableHeight2 = ((data2.size()+0.8)*decodeTable.getFixedCellSize()) + decodeTable.getInsets().getTop() + decodeTable.getInsets().getBottom() + (headerRow2 == null ? 0 : headerRow2.getHeight());
        decodeTable.setMinHeight(tableHeight2);
        decodeTable.setMaxHeight(tableHeight2);
        decodeTable.setPrefHeight(tableHeight2);

        HBox hbox = new HBox(stateName, nameField, stateNum, numField, button);

        HBox.setMargin(stateName, new Insets(5, 5, 5, 0));
        HBox.setMargin(stateNum, new Insets(5, 5, 5, 5));
        HBox.setMargin(button, new Insets(0, 0, 0, 5));

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(fetchTable.getLabel(), fetchTable, decodeTable.getLabel(), decodeTable, hbox);

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

            nameField.clear();
            numField.clear();

            ObservableList<MicroState> states = FXCollections.observableArrayList();
            for (int i=0; i<rows; i++) {
                states.add(new MicroState());
            }
            tableView.setItems(data);
            tableView.setFixedCellSize(35);
            TableHeaderRow header = (TableHeaderRow) tableView.lookup("TableHeaderRow");
            double height = ((states.size()+0.8)*tableView.getFixedCellSize()) + tableView.getInsets().getTop() + tableView.getInsets().getBottom() + (header == null ? 0 : header.getHeight());
            tableView.setMinHeight(height);
            tableView.setMaxHeight(height);
            tableView.setPrefHeight(height);
            tableView.setItems(states);
            
            vbox.getChildren().add(vbox.getChildren().size()-1, tableView.getLabel());
            vbox.getChildren().add(vbox.getChildren().size()-1, tableView);
        });
    }
}