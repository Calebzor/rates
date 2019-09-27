package hu.tvarga.conversion.dto;

import java.math.BigDecimal;
import java.util.Map;

public class Conversion {

	private String base = "EUR";
	private BigDecimal baseValue = BigDecimal.ONE;
	private Map<String, BigDecimal> rates;

	public Conversion(String base, BigDecimal baseValue, Map<String, BigDecimal> rates) {
		this.base = base;
		this.baseValue = baseValue;
		this.rates = rates;
	}

	public Conversion(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public BigDecimal getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(BigDecimal baseValue) {
		this.baseValue = baseValue;
	}

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}
}
