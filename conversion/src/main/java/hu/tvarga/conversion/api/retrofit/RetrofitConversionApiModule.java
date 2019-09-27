package hu.tvarga.conversion.api.retrofit;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = ConversionRetrofitModule.class)
public class RetrofitConversionApiModule {

	@Provides
	ConversionApiService provideConversionApiService(Retrofit retrofit) {
		return retrofit.create(ConversionApiService.class);
	}
}
