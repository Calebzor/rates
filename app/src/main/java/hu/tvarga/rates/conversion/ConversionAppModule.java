package hu.tvarga.rates.conversion;

import dagger.Module;
import hu.tvarga.conversion.ConversionModule;

@Module(includes = {ConversionModule.class})
public interface ConversionAppModule {}
