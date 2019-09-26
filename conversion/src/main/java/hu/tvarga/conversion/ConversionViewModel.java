package hu.tvarga.conversion;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import hu.tvarga.rates.common.app.ui.Strings;

public class ConversionViewModel extends ViewModel {

	private final Strings strings;

	public ConversionViewModel(Strings strings) {
		this.strings = strings;
	}

	public static class ConversionViewModelFactory implements ViewModelProvider.Factory {

		private final Strings strings;

		@Inject
		public ConversionViewModelFactory(Strings strings) {
			this.strings = strings;
		}

		@NonNull
		@Override
		public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
			//noinspection unchecked
			return (T) new ConversionViewModel(strings);
		}

	}
}
