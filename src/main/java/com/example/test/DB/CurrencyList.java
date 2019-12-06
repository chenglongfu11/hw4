package com.example.test.DB;


import java.util.ArrayList;
import java.util.List;

public class CurrencyList implements CurrencyListDTO{
    List<CurrencyRate> list = new ArrayList<>();


    public void setCurrencyRateList(List<CurrencyRate> list) {
        this.list=list;
    }

    @Override
    public List<CurrencyDTO> getCurrencyRateList() {
        List<CurrencyDTO> copyOfList = new ArrayList<>();
        copyOfList.addAll(list);
        return copyOfList;
    }
}
