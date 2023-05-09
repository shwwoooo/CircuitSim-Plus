package com.yudit;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.event.EventHandler;
import javafx.util.Callback;
import java.util.Arrays;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MacroState extends TableView<MicroState> {

    private Label label;

    private TableColumn<MicroState, String> ldmarCol;
    private TableColumn<MicroState, String> ldmdrCol;
    private TableColumn<MicroState, String> ldirCol;
    private TableColumn<MicroState, String> ldregCol;
    private TableColumn<MicroState, String> ldccCol;
    private TableColumn<MicroState, String> ldpcCol;

    public MacroState(String name) {
        MacroState thisObject = this;

        label = new Label(name);
        label.setFont(new Font("Arial", 20));

        this.setEditable(true);
        this.setSortPolicy(param -> false);
        this.widthProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth)
            {
                TableHeaderRow header = (TableHeaderRow) thisObject.lookup("TableHeaderRow");
                header.reorderingProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        header.setReordering(false);
                    }
                });
            }
        });
        this.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) {
                thisObject.getSelectionModel().clearSelection();
            }
        });

        ldmarCol = new TableColumn<MicroState, String>("LD.MAR");
        ldmdrCol = new TableColumn<MicroState, String>("LD.MDR");
        ldirCol = new TableColumn<MicroState, String>("LD.IR");
        ldregCol = new TableColumn<MicroState, String>("LD.REG");
        ldccCol = new TableColumn<MicroState, String>("LD.CC");
        ldpcCol = new TableColumn<MicroState, String>("LD.PC");

        ldmarCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MicroState, String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MicroState, String> param) {
                return param.getValue().getldMAR();
            }
        });
        ldmarCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldmarCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<MicroState,String>>() {
            @Override
            public void handle(CellEditEvent<MicroState, String> event) {
                MicroState ms = thisObject.getItems().get(event.getTablePosition().getRow());
                ms.setldMAR(event.getNewValue());
            }
        });

        ldmdrCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MicroState, String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MicroState, String> param) {
                return param.getValue().getldMDR();
            }
        });
        ldmdrCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldmdrCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<MicroState,String>>() {
            @Override
            public void handle(CellEditEvent<MicroState, String> event) {
                MicroState ms = event.getTableView().getItems().get(event.getTablePosition().getRow());
                ms.setldMDR(event.getNewValue());
            }
        });

        ldirCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MicroState, String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MicroState, String> param) {
                return param.getValue().getldIR();
            }
        });
        ldirCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldirCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<MicroState,String>>() {
            @Override
            public void handle(CellEditEvent<MicroState, String> event) {
                MicroState ms = event.getTableView().getItems().get(event.getTablePosition().getRow());
                ms.setldIR(event.getNewValue());
            }
        });

        ldregCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MicroState, String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MicroState, String> param) {
                return param.getValue().getldREG();
            }
        });
        ldregCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldregCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<MicroState,String>>() {
            @Override
            public void handle(CellEditEvent<MicroState, String> event) {
                MicroState ms = event.getTableView().getItems().get(event.getTablePosition().getRow());
                ms.setldREG(event.getNewValue());
            }
        });

        ldccCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MicroState, String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MicroState, String> param) {
                return param.getValue().getldCC();
            }
        });
        ldccCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldccCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<MicroState,String>>() {
            @Override
            public void handle(CellEditEvent<MicroState, String> event) {
                MicroState ms = event.getTableView().getItems().get(event.getTablePosition().getRow());
                ms.setldCC(event.getNewValue());
            }
        });

        ldpcCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<MicroState, String>,ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<MicroState, String> param) {
                return param.getValue().getldPC();
            }
        });
        ldpcCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldpcCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<MicroState,String>>() {
            @Override
            public void handle(CellEditEvent<MicroState, String> event) {
                MicroState ms = event.getTableView().getItems().get(event.getTablePosition().getRow());
                ms.setldPC(event.getNewValue());
            }
        });
        
        this.getColumns().addAll(Arrays.asList(ldmarCol, ldmdrCol, ldirCol, ldregCol, ldccCol, ldpcCol));

        this.setPrefSize(ldmarCol.getPrefWidth()*6, 100);
    }

    public Label getLabel() {
        return label;
    }
}
