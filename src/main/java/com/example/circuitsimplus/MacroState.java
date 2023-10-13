package com.example.circuitsimplus;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
// import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.layout.VBox;

import java.math.BigInteger;
// import javafx.scene.control.TableColumn.CellEditEvent;
// import javafx.event.EventHandler;
// import javafx.util.Callback;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

public class MacroState extends TableView<MicroState> {

    int rows;
    private Label label;
    ObservableList<MicroState> states;

    private TableColumn<MicroState, String> ldmarCol;
    private TableColumn<MicroState, String> ldmdrCol;
    private TableColumn<MicroState, String> ldirCol;
    private TableColumn<MicroState, String> ldregCol;
    private TableColumn<MicroState, String> ldccCol;
    private TableColumn<MicroState, String> ldpcCol;
    private TableColumn<MicroState, String> gatepcCol;
    private TableColumn<MicroState, String> gatemdrCol;
    private TableColumn<MicroState, String> gatealuCol;
    private TableColumn<MicroState, String> gatemarmuxCol;
    private TableColumn<MicroState, String> pcmuxCol;
    private TableColumn<MicroState, String> drmuxCol;
    private TableColumn<MicroState, String> sr1muxCol;
    private TableColumn<MicroState, String> addr1muxCol;
    private TableColumn<MicroState, String> addr2muxCol;
    private TableColumn<MicroState, String> marmuxCol;
    private TableColumn<MicroState, String> alukCol;
    private TableColumn<MicroState, String> memenCol;
    private TableColumn<MicroState, String> rwCol;
    private TableColumn<MicroState, String> nextCol;
    
    List<TableColumn<MicroState, String>> columns = Arrays.asList(
        ldmarCol,
        ldmdrCol,
        ldirCol,
        ldregCol,
        ldccCol,
        ldpcCol,
        gatepcCol,
        gatemdrCol,
        gatealuCol,
        gatemarmuxCol,
        pcmuxCol,
        drmuxCol,
        sr1muxCol,
        addr1muxCol,
        addr2muxCol,
        marmuxCol,
        alukCol,
        memenCol,
        rwCol,
        nextCol
    );

    List<String> titles = Arrays.asList(
        "LD.MAR\n1bit",
        "LD.MDR\n1bit",
        "LD.IR\n1bit",
        "LD.REG\n1bit",
        "LD.CC\n1bit",
        "LD.PC\n1bit",
        "GatePC\n1bit",
        "GateMDR\n1bit",
        "GateALU\n1bit",
        "GateMARMUX\n1bit",
        "PCMUX\n2bits",
        "DRMUX\n1bit",
        "SR1MUX\n1bit",
        "ADDR1MUX\n1bit",
        "ADDR2MUX\n2bits",
        "MARMUX\n1bit",
        "ALUK\n2bits",
        "MEM.EN\n1bit",
        "R.W\n1bit",
        "NEXT\n6bits"
    );

    List<Function<MicroState, StringProperty>> getters = Arrays.asList(
        MicroState::getldMAR,
        MicroState::getldMDR,
        MicroState::getldIR,
        MicroState::getldREG,
        MicroState::getldCC,
        MicroState::getldPC,
        MicroState::getgatePC,
        MicroState::getgateMDR,
        MicroState::getgateALU,
        MicroState::getgateMARMUX,
        MicroState::getPCMUX,
        MicroState::getDRMUX,
        MicroState::getSR1MUX,
        MicroState::getADDR1MUX,
        MicroState::getADDR2MUX,
        MicroState::getMARMUX,
        MicroState::getALUK,
        MicroState::getMEMEN,
        MicroState::getRW,
        MicroState::getNEXT
    );

    public MacroState(String name) {
        MacroState thisObject = this;

        label = new Label(name);
        label.setFont(new Font("Arial", 20));

        this.setEditable(true);
        this.setSortPolicy(param -> false);
        // this.widthProperty().addListener(new ChangeListener<Number>()
        // {
        //     @Override
        //     public void changed(ObservableValue<? extends Number> source, Number oldWidth, Number newWidth)
        //     {
        //         TableHeaderRow header = (TableHeaderRow) thisObject.lookup("TableHeaderRow");
        //         header.reorderingProperty().addListener(new ChangeListener<Boolean>() {
        //             @Override
        //             public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        //                 header.setReordering(false);
        //             }
        //         });
        //     }
        // });
        this.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) {
                thisObject.getSelectionModel().clearSelection();
            }
        });

        for (int i=0; i<columns.size(); i++) {
            columns.set(i, createColumn(titles.get(i), getters.get(i)));
            columns.get(i).prefWidthProperty().bind(this.widthProperty().divide(columns.size()));
            columns.get(i).setResizable(false);
            // columns.get(i).sortableProperty().set(false);
            columns.get(i).reorderableProperty().set(false);
            // if (titles.get(i).equals("PCMUX\n2bits")) {
            //     Label label = new Label(columns.get(i).getText());
            //     label.setWrapText(true);
            //     label.setTextAlignment(TextAlignment.CENTER);
            //     VBox vbox = new VBox(label);
            //     vbox.setAlignment(Pos.CENTER);
            //     columns.get(i).setGraphic(vbox);
            // }
        }
        
        this.getColumns().addAll(columns);

        this.setOnKeyPressed(event -> {
            TablePosition<MicroState, String> pos = thisObject.getFocusModel().getFocusedCell() ;
            if (pos != null && event.getCode().isLetterKey()) {
                thisObject.edit(pos.getRow(), pos.getTableColumn());
            }
        });
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

    public String[] getData() {
        String[][] dataGrid = new String[rows][columns.size()];
        for (int i=0; i<rows; i++) {
            int j=0;
            for (Function<MicroState, StringProperty> getter : getters) {
                String str = getter.apply(states.get(i)).get();
                if (titles.get(j).equals("PCMUX\n2bits") || titles.get(j).equals("ADDR2MUX\n2bits") || titles.get(j).equals("ALUK\n2bits")) {
                    if (str.equals("00") || str.equals("01") || str.equals("10") || str.equals("11")) {
                        dataGrid[i][j] = str;
                    } else {
                        System.out.println("Invalid value typed");
                    }
                } else if (titles.get(j).equals("NEXT\n6bits")) {
                    dataGrid[i][j] = str;
                } else {
                    if (str.equals("0") || str.equals("1")) {
                        dataGrid[i][j] = str; // hope TAs are able to input correctly...
                    } else {
                        System.out.println("Invalid value typed");
                    }
                }
                j++;
            }
        }
        String[] output = new String[rows];
        for (int i=0; i<rows; i++) {
            output[i] = String.format("%01x", new BigInteger(dataGrid[i][0] + dataGrid[i][1] + dataGrid[i][2] + dataGrid[i][3], 2).intValue()) +
                String.format("%02x", new BigInteger(dataGrid[i][4] + dataGrid[i][5] + dataGrid[i][6] + dataGrid[i][7] + dataGrid[i][8] + dataGrid[i][9] + dataGrid[i][10], 2).intValue()) +
                String.format("%02x", new BigInteger(dataGrid[i][11] + dataGrid[i][12] + dataGrid[i][13] + dataGrid[i][14] + dataGrid[i][15] + dataGrid[i][16], 2).intValue()) +
                String.format("%02x", new BigInteger(dataGrid[i][17] + dataGrid[i][18] + dataGrid[i][19], 2).intValue());
        }
        return output;
    }
}
