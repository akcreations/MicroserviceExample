package com.akcreations.microservice.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akcreations.microservice.currencyexchangeservice.entity.CurrencyExchange;
import com.akcreations.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeServiceController {
	
	@Autowired
	Environment env;
	
	@Autowired
	private CurrencyExchangeRepository repo;
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable String from ,@PathVariable String to)
	{ 
		CurrencyExchange result= repo.findByFromAndTo(from,to);
		result.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("{}",result);
		return result;
	}

}
