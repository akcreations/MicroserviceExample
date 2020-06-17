package com.akcreations.microservice.limitsservice.bean;

public class LimitsServiceConfig {
	private int minimum;
	private int maximum;
	
	
	protected LimitsServiceConfig() {
		
	}
	
	public LimitsServiceConfig(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	
	
}
