package hu.tvarga.conversion.dto;

import android.icu.util.Currency;

import java.util.Locale;
import java.util.Objects;

public class ConversionListElement implements Comparable<ConversionListElement> {

	private String value;
	private String conversionRate;
	private Currency currency;

	public ConversionListElement(String value, String conversionRate, Currency currency) {
		this.value = value;
		this.conversionRate = conversionRate;
		this.currency = currency;
	}

	public String getISOCodeString() {
		return currency.getCurrencyCode();
	}

	public String getDisplayName(Locale locale) {
		return currency.getDisplayName(locale);
	}

	public Currency getCurrency() {
		return currency;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ConversionListElement that = (ConversionListElement) o;
		return Objects.equals(value, that.value) && Objects.equals(conversionRate,
				that.conversionRate) && Objects.equals(currency, that.currency);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, conversionRate, currency);
	}

	@Override
	public int compareTo(ConversionListElement o) {
		return getISOCodeString().compareTo(o.getISOCodeString());
	}
}
