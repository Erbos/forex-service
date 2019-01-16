package com.example.forexservice.service;

import com.example.forexservice.domain.ExchangeValue;
import com.example.forexservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueService {

    private final ExchangeValueRepository exchangeValueRepository;

    @Autowired
    public ExchangeValueService(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    public ExchangeValue findByFromAndTo(String from, String to) {
        return this.exchangeValueRepository.findByFromAndTo(from, to);
    }
}
