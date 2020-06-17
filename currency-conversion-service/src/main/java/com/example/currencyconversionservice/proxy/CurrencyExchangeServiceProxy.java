package com.example.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.currencyconversionservice.bean.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")

//@FeignClient(name="currency-exchange-service")
//after zuul integration
@FeignClient(name="zuul-api-gateway-service")
//when using ribbonclient url not required
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getCurrencyExchangeValue(@PathVariable String from ,@PathVariable String to);
}
