package hu.tvarga.rates.app.di;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import hu.tvarga.rates.app.RatesApplication;
import hu.tvarga.rates.common.app.api.ApiModule;
import hu.tvarga.rates.common.app.di.annotations.scope.ApplicationScoped;
import hu.tvarga.rates.main.MainModule;

@ApplicationScoped
@Component(modules = {BaseApplicationModule.class, AndroidInjectionModule.class,

		MainModule.class,

		ApiModule.class,

})
public interface ApplicationComponent extends AndroidInjector<RatesApplication> {}
