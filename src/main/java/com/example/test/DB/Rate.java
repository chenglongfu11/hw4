package com.example.test.DB;

import javax.persistence.*;
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

    @Column(name = "FROMM")
    private String fromm;

    @Column(name = "TO")
    private String to;

    @Column(name = "RATE")
    private double rate;

    public Rate(String fromCode, String toCode, double rate) {
        this.fromm = fromCode;
        this.to = toCode;
        this.rate = rate;
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











}
