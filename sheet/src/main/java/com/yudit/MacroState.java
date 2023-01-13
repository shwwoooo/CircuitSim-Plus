package com.yudit;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class MacroState extends TableView<MicroState> {
    private Label label;

    private TableColumn<MicroState, String> ldmarCol;
    private TableColumn<MicroState, String> ldmdrCol;
    private TableColumn<MicroState, String> ldirCol;
    private TableColumn<MicroState, String> ldregCol;
    private TableColumn<MicroState, String> ldccCol;
    private TableColumn<MicroState, String> ldpcCol;
//     private ObservableList<MicroState> data;

    public MacroState(String name) {
        label = new Label(name);
        label.setFont(new Font("Arial", 20));

        this.setEditable(true);

        ldmarCol = new TableColumn<>("LD.MAR");
        ldmdrCol = new TableColumn<>("LD.MDR");
        ldirCol = new TableColumn<>("LD.IR");
        ldregCol = new TableColumn<>("LD.REG");
        ldccCol = new TableColumn<>("LD.CC");
        ldpcCol = new TableColumn<>("LD.PC");
        
        ldmarCol.setCellValueFactory(
                new PropertyValueFactory<>("ldMAR"));
        ldmdrCol.setCellValueFactory(
                new PropertyValueFactory<>("ldMDR"));
        ldirCol.setCellValueFactory(
                new PropertyValueFactory<>("ldIR"));
        ldregCol.setCellValueFactory(
                new PropertyValueFactory<>("ldREG"));
        ldccCol.setCellValueFactory(
                new PropertyValueFactory<>("ldCC"));
        ldpcCol.setCellValueFactory(
                new PropertyValueFactory<>("ldPC"));

        ldmarCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldmdrCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldirCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldregCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldccCol.setCellFactory(TextFieldTableCell.forTableColumn());
        ldpcCol.setCellFactory(TextFieldTableCell.forTableColumn());
        
        // data = FXCollections.observableArrayList(
        //         new MicroState(), new MicroState(), new MicroState()
        // );
        // this.setItems(data);
        this.getColumns().addAll(ldmarCol, ldmdrCol, ldirCol, ldregCol, ldccCol, ldpcCol);

        this.setPrefSize(ldmarCol.getPrefWidth()*6, 100);
    }

    public Label getLabel() {
        return label;
    }
}
