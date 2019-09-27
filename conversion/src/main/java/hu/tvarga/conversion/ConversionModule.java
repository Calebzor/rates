package hu.tvarga.conversion;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hu.tvarga.conversion.api.retrofit.RetrofitConversionApiModule;
import hu.tvarga.conversion.ui.ConversionFragment;

@Module(includes = {RetrofitConversionApiModule.class})
public interface ConversionModule {

	@Binds
	ConversionRepository bindConversionRepository(
			DefaultConversionRepository defaultConversionRepository);

	@ContributesAndroidInjector
	ConversionFragment contributeConversionFragmentInjector();
}
