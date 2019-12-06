package com.example.test;


import com.example.test.DB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepo;

    public CurrencyService() {
        //currencyRepo.save(new CurrencyRate(currencyName,currencyRate));
        //currencyRepo.save(new CurrencyRate("SEK TO EUR", 10.0));
        //addCurrencyRates("EUR TO SEK", 0.1);
        //addCurrencyRates("SEK TO USD", 7.0);
        //addCurrencyRates("USD TO SEK", 0.7);
    }

    public void addCurrencyRates(String currencyName, Double currencyRate){

        CurrencyRate currencyRateEntity = currencyRepo.findCurrencyRateByCurrencyName(currencyName);
        if(currencyRateEntity != null){
                Long id= currencyRateEntity.getId();
                CurrencyRate newone = new CurrencyRate(currencyName,currencyRate);
                newone.setId(id);
                currencyRepo.saveAndFlush(newone);
        }
        else {
            currencyRepo.save(new CurrencyRate(currencyName, currencyRate));
        }
    }


    public CurrencyListDTO getCurrencies(){
        List<CurrencyRate> list = currencyRepo.findAll();
        CurrencyList currencyList = new CurrencyList();
        currencyList.setCurrencyRateList(list);

        return currencyList;

    }






}
