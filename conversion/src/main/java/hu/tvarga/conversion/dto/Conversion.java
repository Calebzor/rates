package hu.tvarga.conversion.dto;

import java.util.Map;

public class Conversion {

	private Map<String, String> rates;

	public Conversion(Map<String, String> rates) {
		this.rates = rates;
	}

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}
}
