package hu.tvarga.conversion;

import hu.tvarga.conversion.dto.Conversion;
import io.reactivex.Flowable;

public interface ConversionRepository {

	Flowable<Conversion> getConversion(String base);
}
