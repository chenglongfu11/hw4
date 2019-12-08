package com.example.test;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.lang.NonNull;

public class AdminInput {

    @NonNull
    @Pattern(regexp = "[A-Z]{3}", message = "Please specify a legal currecny")
    private String fromCurrency;

    @NonNull
    @Pattern(regexp = "[A-Z]{3}", message = "Please specify a legal currecny")
    private String toCurrency;
    
    @PositiveOrZero(message = "Please input a positive number")
    @NonNull
    private double rate;

    public AdminInput() {
    }

    /**
     * @return the fromCurrency
     */
    public String getFromCurrency() {
        return fromCurrency;
    }

    /**
     * @return the toCurrency
     */
    public String getToCurrency() {
        return toCurrency;
    }

    /**
     * @param fromCurrency the fromCurrency to set
     */
    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    /**
     * @param toCurrency the toCurrency to set
     */
    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }


}
