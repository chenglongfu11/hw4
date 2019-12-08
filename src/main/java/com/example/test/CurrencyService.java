package com.example.test;


import com.example.test.DB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Transactional
@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepo;
    @Autowired
    private RateRepository rateRepo;

    public CurrencyService() {
        //currencyRepo.save(new CurrencyRate(currencyName,currencyRate));
        //currencyRepo.save(new CurrencyRate("SEK TO EUR", 10.0));
        //addCurrencyRates("EUR TO SEK", 0.1);
        //addCurrencyRates("SEK TO USD", 7.0);
        //addCurrencyRates("USD TO SEK", 0.7);
    }

    
    public void addCurrency(String code){

        Currency currencyEntity = currencyRepo.findCurrencyByCode(code);
        if(currencyEntity == null){
            currencyRepo.save(new Currency(code));
        }
    }


    @SuppressWarnings("unchecked")
    public List<CurrencyDTO> getCurrencies(){
        List<CurrencyDTO> list = (List<CurrencyDTO>)(List<?>)currencyRepo.findAll();
        return list;
    }

    public double getRate(String from, String to){
        Rate rate = rateRepo.findRateByFrommAndTo(from, to);
        if(rate != null){
            rate.setConversion();
            return rate.getRate();
        }
        return -1.0;
    }

    public void addRate(String from, String to, double rate){
        Rate r = rateRepo.findRateByFrommAndTo(from, to);

        if(r != null){
            Long id = r.getId();
            Rate newRate = new Rate(from, to, rate);
            newRate.setId(id);
            rateRepo.saveAndFlush(newRate);
        }else{
            Rate newRate = new Rate(from, to, rate);
            rateRepo.saveAndFlush(newRate);
        }
    }

    @SuppressWarnings("unchecked")
    public List<RateDTO> getRates(){
        List<RateDTO> list = (List<RateDTO>)(List<?>)rateRepo.findAll();
        return list;
    }





}
