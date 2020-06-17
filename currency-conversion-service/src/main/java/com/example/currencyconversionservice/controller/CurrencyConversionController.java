package com.example.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.currencyconversionservice.bean.CurrencyConversionBean;
import com.example.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeProxy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@GetMapping("currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getCurrencyConverted(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
       
		ResponseEntity<CurrencyConversionBean> responseEntity = restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody(); 
		
		return new CurrencyConversionBean(response.getId(),response.getFrom(),response.getTo(),response.getConversionMultiple(),quantity,
				quantity.multiply(response.getConversionMultiple()),response.getPort());
		
	}
	
	@GetMapping("currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean getCurrencyConvertedFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response = currencyExchangeProxy.getCurrencyExchangeValue(from, to);
		logger.info("{}",response);
		return new CurrencyConversionBean(response.getId(),response.getFrom(),response.getTo(),response.getConversionMultiple(),quantity,
				quantity.multiply(response.getConversionMultiple()),response.getPort());
		
	}
}
