package hu.tvarga.conversion.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.tvarga.conversion.ConversionRepository;
import hu.tvarga.conversion.dto.Conversion;
import hu.tvarga.conversion.dto.ConversionListElement;
import hu.tvarga.rates.common.app.util.SchedulerProvider;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subjects.PublishSubject;

import static hu.tvarga.conversion.ui.ConversionViewModel.POLLING_INTERVAL;
import static hu.tvarga.conversion.ui.ConversionViewModel.POLLING_UNIT;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConversionViewModelTest {

	@Mock
	private ConversionRepository conversionRepository;
	@Mock
	private SchedulerProvider schedulerProvider;
	private ConversionViewModel conversionViewModel;

	@Before
	public void setUp() {
		conversionViewModel = new ConversionViewModel(conversionRepository, schedulerProvider);
	}

	@Test
	public void getConversionStartsWithDefault() {
		when(schedulerProvider.mainThread()).thenReturn(Schedulers.trampoline());
		TestScheduler testScheduler = new TestScheduler();
		when(schedulerProvider.io()).thenReturn(testScheduler);
		Map<String, String> rates = new HashMap<>();
		rates.put("USD", "1.23");
		rates.put("HUF", "4.56");
		when(conversionRepository.getConversion(any())).thenReturn(
				Single.just(new Conversion(rates)).toFlowable());

		PublishSubject<List<ConversionListElement>> conversions =
				conversionViewModel.getConversions();

		TestObserver<List<ConversionListElement>> test = conversions.test();
		List<ConversionListElement> expected = new ArrayList<>();
		expected.add(new ConversionListElement("1.00", "1.00", Currency.getInstance("EUR")));
		expected.add(new ConversionListElement("1.23", "1.23", Currency.getInstance("USD")));
		expected.add(new ConversionListElement("4.56", "4.56", Currency.getInstance("HUF")));

		testScheduler.advanceTimeBy(POLLING_INTERVAL, POLLING_UNIT);
		test.assertValue(expected);

		test.dispose();
	}
}