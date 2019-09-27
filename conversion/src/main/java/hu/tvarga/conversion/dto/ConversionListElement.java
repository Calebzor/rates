package hu.tvarga.conversion.dto;

import android.icu.util.Currency;

import java.util.Locale;

import androidx.annotation.DrawableRes;

public class ConversionListElement {

	private String value;
	private Currency currency;

	public ConversionListElement(String value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	public String getISOCodeString() {
		return currency.getCurrencyCode();
	}

	public String getDisplayName(Locale locale) {
		return currency.getDisplayName(locale);
	}

	@DrawableRes
	public int getFlag() {
		return 0;
	}

	public String getValue() {
		return value;
	}
}
