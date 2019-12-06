package com.example.test.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CURRENCY")

public class Currency implements CurrencyDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NAME")
    @SequenceGenerator(name = "SEQ_NAME", sequenceName = "CURRENCY_SEQUENCE")
    @Column(name = "CURRENCY_ID")
    private long id;

    @Column(name = "CODE")
    private String code;

    public Currency(String code) {
        this.code = code;
    }

    //required by JPA, should not used
    protected Currency(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }











}
