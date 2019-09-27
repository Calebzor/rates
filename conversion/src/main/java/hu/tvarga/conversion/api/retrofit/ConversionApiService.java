package hu.tvarga.conversion.api.retrofit;

import hu.tvarga.conversion.api.dao.ConversionApiObject;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConversionApiService {

	@GET("latest")
	Single<ConversionApiObject> getLatestConversionForBase(@Query("base") String base);
}
