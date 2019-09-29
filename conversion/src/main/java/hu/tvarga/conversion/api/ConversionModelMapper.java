package hu.tvarga.conversion.api;

import javax.inject.Inject;

import hu.tvarga.conversion.api.dao.ConversionApiObject;
import hu.tvarga.conversion.dto.Conversion;

public class ConversionModelMapper {

	@Inject
	public ConversionModelMapper() {
		// for dagger
	}

	public Conversion mapToConversionModel(ConversionApiObject conversionApiObject) {
		return new Conversion(conversionApiObject.rates);
	}
}
