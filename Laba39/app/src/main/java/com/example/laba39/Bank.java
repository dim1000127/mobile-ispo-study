package com.example.laba39;

public class Bank {

    String start, fin, adr, type;
    int [] t;


    public Bank(String _adr, String _type, String _start, String _fin, int[] _t){
        adr = _adr;
        type = _type;
        start = _start;
        fin = _fin;
        t = _t;
    }

    public String getAdr() {
        return adr;
    }

    public String getType() {
        return type;
    }

    public String getStart() {
        return start;
    }

    public String getFin() {
        return fin;
    }

    public int[] getT() {
        return t;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public void setT(int[] t) {
        this.t = t;
    }
}
