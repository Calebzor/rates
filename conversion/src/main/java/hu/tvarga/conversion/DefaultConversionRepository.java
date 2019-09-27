package hu.tvarga.conversion;

import javax.inject.Inject;

import hu.tvarga.conversion.api.ConversionModelMapper;
import hu.tvarga.conversion.api.dao.ConversionApiObject;
import hu.tvarga.conversion.api.retrofit.ConversionApiService;
import hu.tvarga.conversion.dto.Conversion;
import hu.tvarga.rates.common.app.util.StringUtils;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class DefaultConversionRepository implements ConversionRepository {

	private final ConversionApiService conversionApiService;
	private final ConversionModelMapper conversionModelMapper;

	@Inject
	public DefaultConversionRepository(ConversionApiService conversionApiService,
			ConversionModelMapper conversionModelMapper) {
		this.conversionApiService = conversionApiService;
		this.conversionModelMapper = conversionModelMapper;
	}

	@Override
	public Flowable<Conversion> getConversion(String base) {
		String baseToUse = base;
		if (StringUtils.isNullOrEmpty(base)) {
			baseToUse = "EUR";
		}
		return conversionApiService.getLatestConversionForBase(baseToUse).onErrorReturn(
				throwable -> new ConversionApiObject()).subscribeOn(Schedulers.io()).map(
				conversionModelMapper::mapToConversionModel).toFlowable();
	}
}
