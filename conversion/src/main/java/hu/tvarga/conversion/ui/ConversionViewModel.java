package hu.tvarga.conversion.ui;

import android.icu.util.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import hu.tvarga.conversion.ConversionRepository;
import hu.tvarga.conversion.dto.Conversion;
import hu.tvarga.conversion.dto.ConversionListElement;
import hu.tvarga.rates.common.app.locale.LocaleProvider;

public class ConversionViewModel extends ViewModel {

	private final ConversionRepository conversionRepository;
	private final LocaleProvider localeProvider;

	public ConversionViewModel(ConversionRepository conversionRepository,
			LocaleProvider localeProvider) {
		this.conversionRepository = conversionRepository;
		this.localeProvider = localeProvider;
	}

	public LiveData<List<ConversionListElement>> getConversions() {
		LiveData<Conversion> objectLiveData = LiveDataReactiveStreams.fromPublisher(
				conversionRepository.getConversion(null));
		return Transformations.map(objectLiveData, conversion -> {
			List<ConversionListElement> conversionListElements = new ArrayList<>();
			if (conversion != null && conversion.getRates() != null) {
				ConversionListElement baseElement = new ConversionListElement(
						getValue(conversion.getBaseValue()),
						Currency.getInstance(conversion.getBase()));
				conversionListElements.add(baseElement);
				Map<String, BigDecimal> rates = conversion.getRates();
				for (Map.Entry<String, BigDecimal> entry : rates.entrySet()) {
					ConversionListElement element = new ConversionListElement(
							getValue(entry.getValue()), Currency.getInstance(entry.getKey()));
					conversionListElements.add(element);
				}
			}
			return conversionListElements;
		});
	}

	private String getValue(BigDecimal value) {
		return String.format(localeProvider.getCurrentLocale(), "%.2f",
				value.setScale(2, RoundingMode.FLOOR));
	}

	public static class ConversionViewModelFactory implements ViewModelProvider.Factory {

		private final ConversionRepository conversionRepository;
		private final LocaleProvider localeProvider;

		@Inject
		public ConversionViewModelFactory(ConversionRepository conversionRepository,
				LocaleProvider localeProvider) {
			this.conversionRepository = conversionRepository;
			this.localeProvider = localeProvider;
		}

		@NonNull
		@Override
		public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
			//noinspection unchecked
			return (T) new ConversionViewModel(conversionRepository, localeProvider);
		}

	}
}
