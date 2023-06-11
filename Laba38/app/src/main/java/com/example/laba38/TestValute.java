package com.example.laba38;

public class TestValute {

    int valuteNumCode;
    String valuteCharCode;
    String valuteName;
    double valuteValue;

    public TestValute(int _valuteNumCode, String _valuteCharCode, String _valuteName, double _valutevalue){
        valuteNumCode = _valuteNumCode;
        valuteCharCode = _valuteCharCode;
        valuteName = _valuteName;
        valuteValue = _valutevalue;
    }

    public int getValuteNumCode() {
        return valuteNumCode;
    }

    public String getValuteCharCode() {
        return valuteCharCode;
    }

    public String getValuteName() {
        return valuteName;
    }

    public double getValuteValue() {
        return valuteValue;
    }

    public void setValuteNumCode(int valuteNumCode) {
        this.valuteNumCode = valuteNumCode;
    }

    public void setValuteCharCode(String valuteCharCode) {
        this.valuteCharCode = valuteCharCode;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    public void setValuteValue(double valuteValue) {
        this.valuteValue = valuteValue;
    }
}
