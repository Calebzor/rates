package hu.tvarga.rates.common.app.util;

import javax.inject.Inject;

import hu.tvarga.rates.common.app.di.annotations.scope.ApplicationScoped;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@ApplicationScoped
public class SchedulerProvider {

	@Inject
	SchedulerProvider() {
		// for dagger
	}

	public Scheduler mainThread() {
		return AndroidSchedulers.mainThread();
	}

	public Scheduler io() {
		return Schedulers.io();
	}
}
