package hu.tvarga.rates.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hu.tvarga.conversion.ConversionModule;

@Module(includes = {ConversionModule.class})
public interface MainModule {

	@ContributesAndroidInjector
	MainActivity contributeMainActivityInjector();
}
