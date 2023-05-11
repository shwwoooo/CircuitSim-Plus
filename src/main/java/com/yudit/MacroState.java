package com.yudit;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.event.EventHandler;
import javafx.util.Callback;
import java.util.Arrays;
import java.util.function.Function;

import javafx.beans.property.StringProperty;
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

        ldmarCol = createColumn("LD.MAR", MicroState::getldMAR);
        ldmdrCol = createColumn("LD.MDR", MicroState::getldMDR);
        ldirCol = createColumn("LD.IR", MicroState::getldIR);
        ldregCol = createColumn("LD.REG", MicroState::getldREG);
        ldccCol = createColumn("LD.CC", MicroState::getldCC);
        ldpcCol = createColumn("LD.PC", MicroState::getldPC);
        
        this.getColumns().addAll(Arrays.asList(ldmarCol, ldmdrCol, ldirCol, ldregCol, ldccCol, ldpcCol));

        this.setOnKeyPressed(event -> {
            TablePosition<MicroState, String> pos = thisObject.getFocusModel().getFocusedCell() ;
            if (pos != null && event.getCode().isLetterKey()) {
                thisObject.edit(pos.getRow(), pos.getTableColumn());
            }
        });

        ldmarCol.prefWidthProperty().bind(this.widthProperty().divide(6));
        ldmdrCol.prefWidthProperty().bind(this.widthProperty().divide(6));
        ldirCol.prefWidthProperty().bind(this.widthProperty().divide(6));
        ldregCol.prefWidthProperty().bind(this.widthProperty().divide(6));
        ldccCol.prefWidthProperty().bind(this.widthProperty().divide(6));
        ldpcCol.prefWidthProperty().bind(this.widthProperty().divide(6));

        ldmarCol.setResizable(false);
        ldmdrCol.setResizable(false);
        ldirCol.setResizable(false);
        ldregCol.setResizable(false);
        ldccCol.setResizable(false);
        ldpcCol.setResizable(false);
    }

    private <T> TableColumn<T, String> createColumn(String title, Function<T, StringProperty> property) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

        col.setCellFactory(column -> EditCell.createStringEditCell());
        return col;
    }

    public Label getLabel() {
        return label;
    }
}
