package com.example.test;

public class CurrencyTypes {

    String CurrencyName;
    Double rate;
    public CurrencyTypes(String currencyName, Double rate) {
        this.CurrencyName=currencyName;
        this.rate=rate;
    }


    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        CurrencyName = currencyName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }


}
