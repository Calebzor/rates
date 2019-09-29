package hu.tvarga.conversion.ui;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import hu.tvarga.conversion.ConversionRepository;
import hu.tvarga.conversion.dto.Conversion;
import hu.tvarga.conversion.dto.ConversionListElement;
import hu.tvarga.rates.common.app.util.SchedulerProvider;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

public class ConversionViewModel extends ViewModel {

	static final long POLLING_INTERVAL = 1L;
	static final TimeUnit POLLING_UNIT = TimeUnit.SECONDS;
	private final ConversionRepository conversionRepository;
	private final SchedulerProvider schedulerProvider;
	private final ConversionListElement conversionListElement = new ConversionListElement("1.00",
			"1.00", Currency.getInstance("EUR"));
	private final PublishSubject<List<ConversionListElement>> conversionListElementsPublishSubject =
			PublishSubject.create();
	private Disposable disposable;

	ConversionViewModel(ConversionRepository conversionRepository,
			SchedulerProvider schedulerProvider) {
		this.conversionRepository = conversionRepository;
		this.schedulerProvider = schedulerProvider;
	}

	PublishSubject<List<ConversionListElement>> getConversions() {
		pollForConversions();
		return conversionListElementsPublishSubject;
	}

	private void pollForConversions() {
		Flowable<Conversion> conversions = conversionRepository.getConversion(
				conversionListElement.getISOCodeString());
		disposable = conversions.delay(POLLING_INTERVAL, POLLING_UNIT, schedulerProvider.io())
				.repeatUntil(() -> false).observeOn(schedulerProvider.mainThread()).subscribe(
						this::handleConversion,
						Timber::w);
	}

	private void handleConversion(Conversion conversion) {
		List<ConversionListElement> conversionListElements = new ArrayList<>();
		if (conversion != null && conversion.getRates() != null) {
			conversionListElements.add(conversionListElement);
			Map<String, String> rates = conversion.getRates();
			for (Map.Entry<String, String> entry : rates.entrySet()) {
				ConversionListElement element = new ConversionListElement(entry.getValue(),
						entry.getValue(), Currency.getInstance(entry.getKey()));
				conversionListElements.add(element);
			}
		}
		conversionListElementsPublishSubject.onNext(conversionListElements);
	}

	@Override
	protected void onCleared() {
		disposePolling();
		super.onCleared();
	}

	private void disposePolling() {
		if (disposable != null) {
			disposable.dispose();
		}
	}

	void setModifiedListItem(ConversionListElement conversionListElement) {
		disposePolling();
		this.conversionListElement.setCurrency(conversionListElement.getCurrency());
		this.conversionListElement.setValue(conversionListElement.getValue());
		pollForConversions();
	}

	public static class ConversionViewModelFactory implements ViewModelProvider.Factory {

		private final ConversionRepository conversionRepository;
		private final SchedulerProvider schedulerProvider;

		@Inject
		public ConversionViewModelFactory(ConversionRepository conversionRepository,
				SchedulerProvider schedulerProvider) {
			this.conversionRepository = conversionRepository;
			this.schedulerProvider = schedulerProvider;
		}

		@NonNull
		@Override
		public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
			//noinspection unchecked
			return (T) new ConversionViewModel(conversionRepository, schedulerProvider);
		}

	}
}
