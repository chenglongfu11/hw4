package com.example.test;

import java.util.HashMap;
import java.util.List;

public class CalculateMoney {
    private int inputValue;
    private Double rate;


    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }


    public void setInputValue(int inputValue) {
        this.inputValue = inputValue;
    }



    public int getInputValue(){
        System.out.println(inputValue);
        return inputValue;
    }

    public Double MoneyCalculate(){
        return inputValue*rate;

    }
}
