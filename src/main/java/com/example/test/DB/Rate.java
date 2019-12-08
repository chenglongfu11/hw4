package com.example.test.DB;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RATE")

public class Rate implements RateDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NAME")
    @SequenceGenerator(name = "SEQ_NAME", sequenceName = "RATE_SEQUENCE")
    @Column(name = "ID")
    private long id;

    @NotNull(message="{admin.adminInput.fromCurrency}")
    @Column(name = "FROMM")
    private String fromm;

    @NotNull(message="{admin.adminInput.toCurrency}")
    @Column(name = "TO")
    private String to;

    @PositiveOrZero(message="{admin.adminInput.rate}")
    @Column(name = "RATE")
    private double rate;



    @Column(name = "CONVERSION")
    private int conversion;

    public Rate(String fromCode, String toCode, double rate) {
        this.fromm = fromCode;
        this.to = toCode;
        this.rate = rate;
        this.conversion = 0;
    }

    //required by JPA, should not used
    protected Rate(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getFromm() {
        return fromm;
    }
    
    @Override
    public String getTo() {
        return to;
    }
    
    @Override
    public double getRate() {
        return rate;
    }
    
    public String getToCode() {
        return to;
    }
    
    public void setFromCode(String fromCode) {
        this.fromm = fromCode;
    }
    
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public void setToCode(String toCode) {
        this.to = toCode;
    }

    @Override
    public int getConversion() {
        return conversion;
    }


    public void setConversion(int conversion) {
        this.conversion = conversion;
    }

    public void updateConversion(){
        conversion = conversion + 1;
    }











}
