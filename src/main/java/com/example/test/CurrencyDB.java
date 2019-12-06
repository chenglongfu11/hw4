package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;

public class CurrencyDB {

    ArrayList<CurrencyTypes> currencyDB = new ArrayList<>();

    public CurrencyDB() {

        currencyDB.add(new CurrencyTypes("SEK TO EUR", 10.0));
        currencyDB.add(new CurrencyTypes("EUR TO SEK", 0.1));
        currencyDB.add(new CurrencyTypes("SEK TO USD", 7.0));
        currencyDB.add(new CurrencyTypes("USD TO SEK", 0.7));
    }

    public ArrayList<CurrencyTypes> getCurrencyDB() {
        return currencyDB;
    }

    public void setCurrencyDB(ArrayList<CurrencyTypes> currencyDB) {
        this.currencyDB = currencyDB;
    }





}
