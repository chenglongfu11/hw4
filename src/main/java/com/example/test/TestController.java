package com.example.test;

import com.example.test.DB.CurrencyDTO;
import com.example.test.DB.CurrencyListDTO;
import com.example.test.DB.CurrencyRate;
import com.example.test.DB.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Transactional
public class TestController {
    @Autowired
    private CurrencyService service;
    private CurrencyListDTO currencyListDTO;
    private CurrencyDTO currencyDTO;
    @Autowired
    private CurrencyRepository currencyRepository;



    @GetMapping("/")
    public String PageSet(CalculateMoney calculateMoney, Model model){


        service.addCurrencyRates("SEK TO EUR", 10.0);
        //currencyRepository.save(new CurrencyRate("SEK TO EUR111", 10.0));
        //addCurrencyRates("EUR TO SEK", 0.1);
        //addCurrencyRates("SEK TO USD", 7.0);
        //addCurrencyRates("USD TO SEK", 0.7);
        currencyListDTO=  service.getCurrencies();
        //List<CurrencyRate> list = currencyRepository.findAll();
        List<CurrencyDTO> list = currencyListDTO.getCurrencyRateList();

        System.out.println(list);
        model.addAttribute("currencyList", list);
//        model.addAttribute(calculateMoney);
        return "index";
    }

//    @PostMapping("/request")
//    public String Request(GetRequest)



    @PostMapping("/amount-input")
    public String AmountInput(CalculateMoney calculateMoney, Model model){

        Double calculatedResults;
        calculatedResults = calculateMoney.MoneyCalculate();
        model.addAttribute("res",calculatedResults);


        currencyListDTO=  service.getCurrencies();
        List<CurrencyDTO> list = currencyListDTO.getCurrencyRateList();

        //System.out.println(list);
        model.addAttribute("currencyList",list);
        return "index";
    }

    @GetMapping("/admin")
    public String AdminShow(AdminInput adminInput, Model model){

        service.addCurrencyRates("SEK TO EUR", 10.0);
        currencyListDTO=  service.getCurrencies();
        List<CurrencyDTO> list = currencyListDTO.getCurrencyRateList();
        model.addAttribute("currencyList", list);
        return "admin";
    }

    @PostMapping("/admins")
    public String Admin(AdminInput adminInput, Model model){
        //transfer info back to service
        service.addCurrencyRates(adminInput.getCurrencyName(), adminInput.getCurrencyRate());

        //call currencyList again to show new results
        currencyListDTO=  service.getCurrencies();
        List<CurrencyDTO> list = currencyListDTO.getCurrencyRateList();
        model.addAttribute("currencyList", list);
        return "admin";
    }
}
