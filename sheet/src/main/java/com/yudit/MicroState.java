package com.yudit;

import javafx.beans.property.SimpleStringProperty;

public class MicroState {

    private SimpleStringProperty ldMAR = null;
    private SimpleStringProperty ldMDR = null;
    private SimpleStringProperty ldIR = null;
    private SimpleStringProperty ldREG = null;
    private SimpleStringProperty ldCC = null;
    private SimpleStringProperty ldPC = null;
    private SimpleStringProperty gatePC = null;
    private SimpleStringProperty gateMDR = null;
    private SimpleStringProperty gateALU = null;
    private SimpleStringProperty gateMARMUX = null;
    private SimpleStringProperty pcMUX = null;
    private SimpleStringProperty drMUX = null;
    private SimpleStringProperty sr1MUX = null;
    private SimpleStringProperty addr1MUX = null;
    private SimpleStringProperty addr2MUX = null;
    private SimpleStringProperty marMUX = null;
    private SimpleStringProperty aluK = null;
    private SimpleStringProperty memEN = null;
    private SimpleStringProperty rw = null;
    private SimpleStringProperty next = null;

    public MicroState() {
        this.ldMAR = new SimpleStringProperty();
        this.ldMDR = new SimpleStringProperty();
        this.ldIR = new SimpleStringProperty();
        this.ldREG = new SimpleStringProperty();
        this.ldCC = new SimpleStringProperty();
        this.ldPC = new SimpleStringProperty();
        this.gatePC = new SimpleStringProperty();
        this.gateMDR = new SimpleStringProperty();
        this.gateALU = new SimpleStringProperty();
        this.gateMARMUX = new SimpleStringProperty();
        this.pcMUX = new SimpleStringProperty();
        this.drMUX = new SimpleStringProperty();
        this.sr1MUX = new SimpleStringProperty();
        this.addr1MUX = new SimpleStringProperty();
        this.addr2MUX = new SimpleStringProperty();
        this.marMUX = new SimpleStringProperty();
        this.aluK = new SimpleStringProperty();
        this.memEN = new SimpleStringProperty();
        this.rw = new SimpleStringProperty();
        this.next = new SimpleStringProperty();
    }

    public SimpleStringProperty getldMAR() {
        return ldMAR;
    }

    public void setldMAR(String str) {
        System.out.println("editing MAR");
        this.ldMAR.set(str);
    }

    public SimpleStringProperty getldMDR() {
        return ldMDR;
    }

    public void setldMDR(String str) {
        System.out.println("editing MDR");
        this.ldMDR.set(str);
    }

    public SimpleStringProperty getldIR() {
        return ldIR;
    }

    public void setldIR(String str) {
        System.out.println("editing IR");
        this.ldIR.set(str);
    }

    public SimpleStringProperty getldREG() {
        return ldREG;
    }

    public void setldREG(String str) {
        System.out.println("editing REG");
        this.ldREG.set(str);
    }

    public SimpleStringProperty getldCC() {
        return ldCC;
    }

    public void setldCC(String str) {
        System.out.println("editing CC");
        this.ldCC.set(str);
    }

    public SimpleStringProperty getldPC() {
        return ldPC;
    }

    public void setldPC(String str) {
        System.out.println("editing PC");
        this.ldPC.set(str);
    }

    public SimpleStringProperty getgatePC() {
        return gatePC;
    }

    public void setgatePC(String str) {
        System.out.println("editing gatePC");
        this.gatePC.set(str);
    }

    public SimpleStringProperty getgateMDR() {
        return gateMDR;
    }

    public void setgateMDR(String str) {
        System.out.println("editing gateMDR");
        this.gateMDR.set(str);
    }

    public SimpleStringProperty getgateALU() {
        return gateALU;
    }

    public void setgateALU(String str) {
        System.out.println("editing gateALU");
        this.gateALU.set(str);
    }

    public SimpleStringProperty getgateMARMUX() {
        return gateMARMUX;
    }

    public void setgateMARMUX(String str) {
        System.out.println("editing gateMARMUX");
        this.gateMARMUX.set(str);
    }

    public SimpleStringProperty getPCMUX() {
        return pcMUX;
    }

    public void setPCMUX(String str) {
        System.out.println("editing pcMUX");
        this.pcMUX.set(str);
    }

    public SimpleStringProperty getDRMUX() {
        return drMUX;
    }

    public void setDRMUX(String str) {
        System.out.println("editing drMUX");
        this.drMUX.set(str);
    }
    
    public SimpleStringProperty getSR1MUX() {
        return sr1MUX;
    }

    public void setSR1MUX(String str) {
        System.out.println("editing sr1MUX");
        this.sr1MUX.set(str);
    }

    public SimpleStringProperty getADDR1MUX() {
        return addr1MUX;
    }

    public SimpleStringProperty getADDR2MUX() {
        return addr2MUX;
    }

    public SimpleStringProperty getMARMUX() {
        return marMUX;
    }

    public SimpleStringProperty getALUK() {
        return aluK;
    }

    public SimpleStringProperty getMEMEN() {
        return memEN;
    }

    public SimpleStringProperty getRW() {
        return rw;
    }

    public SimpleStringProperty getNEXT() {
        return next;
    }

}
