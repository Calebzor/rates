package hu.tvarga.conversion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class ConversionFragment extends hu.tvarga.rates.common.ui.BaseFragment {

	public static ConversionFragment newInstance() {
		return new ConversionFragment();
	}

	@Inject
	ConversionViewModel.ConversionViewModelFactory conversionViewModelFactory;
	private ConversionViewModel conversionViewModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.conversion_fragment, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		conversionViewModel = ViewModelProviders.of(this, conversionViewModelFactory).get(
				ConversionViewModel.class);
	}

}
