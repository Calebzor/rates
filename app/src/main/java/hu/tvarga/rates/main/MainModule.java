package hu.tvarga.rates.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hu.tvarga.rates.conversion.ConversionAppModule;

@Module(includes = {ConversionAppModule.class})
public interface MainModule {

	@ContributesAndroidInjector
	MainActivity contributeMainActivityInjector();
}
