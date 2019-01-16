package com.example.forexservice.controller;

import com.example.forexservice.domain.ExchangeValue;
import com.example.forexservice.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    private final Environment environment;

    private final ExchangeValueService exchangeValueService;

    @Autowired
    public ForexController(Environment environment, ExchangeValueService exchangeValueService) {
        this.environment = environment;
        this.exchangeValueService = exchangeValueService;
    }


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueService.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }
}
