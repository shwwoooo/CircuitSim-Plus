package com.yudit;

import javafx.beans.property.SimpleStringProperty;

public class MicroState {

    private SimpleStringProperty ldMAR = null;
    private SimpleStringProperty ldMDR = null;
    private SimpleStringProperty ldIR = null;
    private SimpleStringProperty ldREG = null;
    private SimpleStringProperty ldCC = null;
    private SimpleStringProperty ldPC = null;

    public MicroState() {
        this.ldMAR = new SimpleStringProperty();
        this.ldMDR = new SimpleStringProperty();
        this.ldIR = new SimpleStringProperty();
        this.ldREG = new SimpleStringProperty();
        this.ldCC = new SimpleStringProperty();
        this.ldPC = new SimpleStringProperty();
    }

    public SimpleStringProperty getldMAR() {
        return ldMAR;
    }

    public void setldMAR(String str) {
        System.out.println("editing MAR");
        this.ldMAR = new SimpleStringProperty(str);
    }

    public SimpleStringProperty getldMDR() {
        return ldMDR;
    }

    public void setldMDR(String str) {
        System.out.println("editing MDR");
        this.ldMDR = new SimpleStringProperty(str);
    }

    public SimpleStringProperty getldIR() {
        return ldIR;
    }

    public void setldIR(String str) {
        System.out.println("editing IR");
        this.ldIR = new SimpleStringProperty(str);
    }

    public SimpleStringProperty getldREG() {
        return ldREG;
    }

    public void setldREG(String str) {
        System.out.println("editing REG");
        this.ldREG = new SimpleStringProperty(str);
    }

    public SimpleStringProperty getldCC() {
        return ldCC;
    }

    public void setldCC(String str) {
        System.out.println("editing CC");
        this.ldCC = new SimpleStringProperty(str);
    }

    public SimpleStringProperty getldPC() {
        return ldPC;
    }

    public void setldPC(String str) {
        System.out.println("editing PC");
        this.ldPC = new SimpleStringProperty(str);
    }

}
