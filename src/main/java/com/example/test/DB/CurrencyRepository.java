package com.example.test.DB;

import com.example.test.CurrencyTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface CurrencyRepository extends JpaRepository<CurrencyRate,Long> {

    CurrencyRate findCurrencyRateByCurrencyName(String currencyName);



}
