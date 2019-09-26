package hu.tvarga.conversion;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ConversionModule {

	@ContributesAndroidInjector
	ConversionFragment contributeConversionFragmentInjector();
}
