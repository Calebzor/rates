package hu.tvarga.conversion;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import hu.tvarga.conversion.api.ConversionModelMapper;
import hu.tvarga.conversion.api.dao.ConversionApiObject;
import hu.tvarga.conversion.api.retrofit.ConversionApiService;
import hu.tvarga.conversion.dto.Conversion;
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
	public Flowable<Conversion> getConversion(@NonNull String base) {
		// could do persistent caching here
		return conversionApiService.getLatestConversionForBase(base).onErrorReturn(
				throwable -> new ConversionApiObject()).subscribeOn(Schedulers.io()).map(
				conversionModelMapper::mapToConversionModel).toFlowable();
	}
}
