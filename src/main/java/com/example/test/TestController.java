package com.example.test;

import com.example.test.DB.CurrencyDTO;
import com.example.test.DB.RateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.util.ClassUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.validation.Valid;

@Controller
@Transactional
public class TestController {

    @Autowired
    private CurrencyService service;
    
    @GetMapping("/")
    public String PageSet(@Valid CalculateMoney calculateMoney, Model model){


        service.addCurrency("SEK");
        service.addRate("SEK", "SEK", 1.0);
        List<CurrencyDTO> list = service.getCurrencies();

        System.out.println(list);
        model.addAttribute("currencyList", list);
        boolean testboolean = false;
        model.addAttribute("testbo",testboolean);
        return "index";
    }

    @PostMapping("/amount-input")
    public String AmountInput(@Valid CalculateMoney calculateMoney, BindingResult bindingResult, Model model){
        List<CurrencyDTO> list = service.getCurrencies();
        
        if(bindingResult.hasErrors()){
            model.addAttribute("currencyList",list);
            //model.addAttribute("res", -1.0);
            return "index";
        }

        Double calculatedResults;
        //Double calculatedResults=service.calculate(calculateMoney.getFromCode(),
                       // calculateMoney.getToCode(),calculateMoney.getInputValue());
        double rate = service.getRate(calculateMoney.getFromCode(), calculateMoney.getToCode());

        boolean testboolean = false;
        calculateMoney.setRate(rate);
        calculatedResults = calculateMoney.MoneyCalculate();
        if(calculatedResults !=null){
            testboolean = true;
        }

        model.addAttribute("testbo",testboolean);
        model.addAttribute("res", calculatedResults);
        model.addAttribute("currencyList",list);
        return "index";
    }

    @GetMapping("/admin")
    public String AdminShow(@Valid AdminInput adminInput, Model model){

        service.addRate("SEK", "SEK", 1.0);
        service.addCurrency("SEK");
        List<RateDTO> rateList = service.getRates();

        model.addAttribute("rateList", rateList);
        return "admin";
    }

    @PostMapping("/admins")
    public String Admin(@Valid AdminInput adminInput, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            List<RateDTO> rateList = service.getRates();
            model.addAttribute("rateList", rateList);
            return "admin";
        }

        //transfer info back to service
        service.addRate(adminInput.getFromCurrency(), adminInput.getToCurrency(), adminInput.getRate());
        service.addCurrency(adminInput.getFromCurrency());
        service.addCurrency(adminInput.getToCurrency());
        
        List<RateDTO> rateList = service.getRates();
        model.addAttribute("rateList", rateList);
        return "admin";
    }


}
