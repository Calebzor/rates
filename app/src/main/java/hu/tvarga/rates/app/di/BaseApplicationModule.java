package hu.tvarga.rates.app.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import hu.tvarga.rates.common.app.di.annotations.qualifiers.ApplicationContext;
import hu.tvarga.rates.common.app.di.annotations.scope.ApplicationScoped;
import hu.tvarga.rates.common.app.ui.AndroidStrings;
import hu.tvarga.rates.common.app.ui.Strings;

@Module
public class BaseApplicationModule {

	private final Application application;

	public BaseApplicationModule(Application application) {
		this.application = application;
	}

	@Provides
	@ApplicationScoped
	Strings provideStrings() {
		return new AndroidStrings(application.getResources());
	}

	@Provides
	@ApplicationContext
	Context provideApplicationContext() {
		return application;
	}
}
