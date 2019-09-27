package hu.tvarga.rates.app.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import hu.tvarga.rates.common.app.di.annotations.qualifiers.ApplicationContext;

@Module
public class BaseApplicationModule {

	private final Application application;

	public BaseApplicationModule(Application application) {
		this.application = application;
	}

	@Provides
	@ApplicationContext
	Context provideApplicationContext() {
		return application;
	}
}
