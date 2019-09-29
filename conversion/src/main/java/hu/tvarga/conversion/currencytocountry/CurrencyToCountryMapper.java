package hu.tvarga.conversion.currencytocountry;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class CurrencyToCountryMapper {

	public static final String UNKNOWN_CURRENCY_TO_COUNTRY_MAPPING =
			"UnknownCurrencyToCountryMapping";
	private Map<String, CurrencyToCountryMapApiObject> mapping;

	private final Gson gson;

	@Inject
	public CurrencyToCountryMapper(Gson gson) {
		this.gson = gson;
	}

	public String getCountryCodeForCurrencyCode(String currencyCode) {
		ensureMappingIsInitialized();
		if (mapping.containsKey(currencyCode)) {
			return mapping.get(currencyCode).CountryCode;
		}
		else {
			return UNKNOWN_CURRENCY_TO_COUNTRY_MAPPING;
		}
	}

	private void ensureMappingIsInitialized() {
		if (mapping == null) {
			mapping = new HashMap<>();
			Type listType = new TypeToken<ArrayList<CurrencyToCountryMapApiObject>>() {}.getType();
			ArrayList<CurrencyToCountryMapApiObject> listOfMapping = gson.fromJson(
					CurrencyToCountryMap.JSON, listType);

			for (CurrencyToCountryMapApiObject currencyToCountryMap : listOfMapping) {
				mapping.put(currencyToCountryMap.Code, currencyToCountryMap);
			}

			useOverrides();
		}
	}

	private void useOverrides() {
		putCurrencyForCountry("EUR", "EU");
		putCurrencyForCountry("AUD", "AU");
		putCurrencyForCountry("DKK", "DK");
		putCurrencyForCountry("NOK", "NO");
		putCurrencyForCountry("NZD", "NZ");
		putCurrencyForCountry("USD", "US");
		putCurrencyForCountry("GBP", "GB");
	}

	private void putCurrencyForCountry(String currency, String country) {
		mapping.put(currency, new CurrencyToCountryMapApiObject(country));
	}
}
