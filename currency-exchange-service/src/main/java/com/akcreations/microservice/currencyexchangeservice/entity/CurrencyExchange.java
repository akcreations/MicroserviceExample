package com.akcreations.microservice.currencyexchangeservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	
	@Id
	public long id;
	
	@Column(name="currency_from")
	public String from;
	
	@Column(name="currency_to")
	public String to;
	
	public BigDecimal conversionMultiple;
	
	public int port;
	
	protected CurrencyExchange()
	{
		
	}

	public long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getConversionMulitple() {
		return conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public CurrencyExchange(long id, String from, String to, BigDecimal conversionMulitple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMulitple;
	}
	
	

}
