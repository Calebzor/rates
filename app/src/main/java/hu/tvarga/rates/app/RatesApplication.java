package hu.tvarga.rates.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.jakewharton.threetenabp.AndroidThreeTen;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import hu.tvarga.rates.BuildConfig;
import hu.tvarga.rates.app.di.ApplicationComponent;
import hu.tvarga.rates.app.di.BaseApplicationModule;
import hu.tvarga.rates.app.di.DaggerApplicationComponent;
import timber.log.Timber;

public class RatesApplication extends Application
		implements HasActivityInjector, HasServiceInjector {

	@Inject
	DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

	@Inject
	DispatchingAndroidInjector<Service> dispatchingServiceInjector;

	@Override
	public void onCreate() {
		super.onCreate();
		AndroidThreeTen.init(this);
		if (BuildConfig.DEBUG) {
			Timber.plant(new Timber.DebugTree());
		}
		createComponent().inject(this);
	}

	@Override
	public AndroidInjector<Activity> activityInjector() {
		return dispatchingActivityInjector;
	}

	@NonNull
	protected ApplicationComponent createComponent() {
		return DaggerApplicationComponent.builder().baseApplicationModule(
				new BaseApplicationModule(this)).build();
	}

	@Override
	public AndroidInjector<Service> serviceInjector() {
		return dispatchingServiceInjector;
	}

}