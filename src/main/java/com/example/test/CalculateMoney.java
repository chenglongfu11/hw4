package com.example.test;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class CalculateMoney {
    @NotNull(message = "Please specify amount")
    @PositiveOrZero(message = "Input value should be greater than 0")
    private double inputValue;
    
    @PositiveOrZero
    private double rate;

    @NotNull
    @Pattern(regexp = "[A-Z]{3}")
    private String fromCode = "AAA";

    @NotNull
    @Pattern(regexp = "[A-Z]{3}")
    private String toCode = "AAA";

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    public void setInputValue(double inputValue) {
        this.inputValue = inputValue;
    }

    public double getInputValue(){
        System.out.println(inputValue);
        return inputValue;
    }

    public double MoneyCalculate(){
        return inputValue * rate;
    }

    /**
     * @return the fromCode
     */
    public String getFromCode() {
        return fromCode;
    }

    /**
     * @param fromCode the fromCode to set
     */
    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    /**
     * @return the toCode
     */
    public String getToCode() {
        return toCode;
    }

    /**
     * @param toCode the toCode to set
     */
    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

}
