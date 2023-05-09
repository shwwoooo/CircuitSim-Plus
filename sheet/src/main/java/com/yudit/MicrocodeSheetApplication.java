package com.yudit;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.skin.TableHeaderRow;
 
public class MicrocodeSheetApplication extends Application {
    private MacroState fetchTable = new MacroState("FETCH");
    private MacroState decodeTable = new MacroState("DECODE");

    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("Microcode Editor");

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

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(fetchTable.getLabel(), fetchTable, decodeTable.getLabel(), decodeTable);

        ScrollPane sp = new ScrollPane();
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);
        sp.setContent(vbox);
        sp.setPannable(true);
        sp.setPrefSize(480, 350);

        Scene scene = new Scene(sp);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
 
        stage.setScene(scene);
        stage.show();
    }
}