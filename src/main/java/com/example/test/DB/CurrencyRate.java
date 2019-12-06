package com.example.test.DB;

import com.example.test.CurrencyTypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CURRENCYRATES")

public class CurrencyRate implements CurrencyDTO{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NAME")
    @SequenceGenerator(name = "SEQ_NAME", sequenceName = "CURRENCY_SEQUENCE")
    @Column(name = "CURRENCY_ID")
    private long id;

    @Column(name = "CURRENCY_NAME")
    private String currencyName;

    @Column(name = "CURRENCY_RATE")
    private Double currencyRate;

    public CurrencyRate(String currencyName, Double currencyRate) {
        this.currencyName = currencyName;
        this.currencyRate = currencyRate;
    }

    //required by JPA, should not used
    protected CurrencyRate(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public Double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }











}
