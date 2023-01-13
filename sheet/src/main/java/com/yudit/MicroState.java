package com.yudit;

public class MicroState {

    private String ldMAR = null;
    private String ldMDR = null;
    private String ldIR = null;
    private String ldREG = null;
    private String ldCC = null;
    private String ldPC = null;

    public MicroState(String str) {
        this.ldMAR = str;
        this.ldMDR = str;
        this.ldIR = str;
        this.ldREG = str;
        this.ldCC = str;
        this.ldPC = str;
    }

    public String getldMAR() {
        return ldMAR;
    }

    public void setldMAR(String str) {
        this.ldMAR = str;
    }

    public String getldMDR() {
        return ldMDR;
    }

    public void setldMDR(String str) {
        this.ldMAR = str;
    }

    public String getldIR() {
        return ldIR;
    }

    public void setldIR(String str) {
        this.ldMAR = str;
    }

    public String getldREG() {
        return ldREG;
    }

    public void setldREG(String str) {
        this.ldMAR = str;
    }

    public String getldCC() {
        return ldCC;
    }

    public void setldCC(String str) {
        this.ldMAR = str;
    }

    public String getldPC() {
        return ldPC;
    }

    public void setldPC(String str) {
        this.ldMAR = str;
    }

}
