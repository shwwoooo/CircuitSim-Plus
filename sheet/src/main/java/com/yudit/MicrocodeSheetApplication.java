package com.yudit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
 
public class MicrocodeSheetApplication extends Application {
    private MacroState fetchTable = new MacroState("FETCH");
    private MacroState decodeTable = new MacroState("DECODE");

    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("Microcode Editor");

        fetchTable.getItems().add(new MicroState("1"));
        decodeTable.getItems().add(new MicroState("2"));

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(fetchTable.getLabel(), fetchTable, decodeTable.getLabel(), decodeTable);

        ScrollPane sp = new ScrollPane();
        sp.setContent(vbox);
        sp.setPannable(true);

        Scene scene = new Scene(sp);
 
        stage.setScene(scene);
        stage.show();
    }
}