package hu.tvarga.conversion.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import hu.tvarga.conversion.R;
import hu.tvarga.conversion.R2;
import hu.tvarga.conversion.dto.ConversionListElement;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class ConversionFragment extends hu.tvarga.rates.common.ui.BaseFragment {

	public static ConversionFragment newInstance() {
		return new ConversionFragment();
	}

	@BindView(R2.id.noConversion)
	TextView noConversion;

	@BindView(R2.id.conversionRecyclerView)
	RecyclerView conversionRecyclerView;

	@Inject
	ConversionListAdapter conversionListAdapter;

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
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		conversionRecyclerView.setAdapter(conversionListAdapter);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		conversionViewModel = ViewModelProviders.of(this, conversionViewModelFactory).get(
				ConversionViewModel.class);
		conversionViewModel.getConversions().observe(this, this::handleConversionLiveData);
	}

	private void handleConversionLiveData(List<ConversionListElement> conversionListElements) {
		if (conversionListElements == null || conversionListElements.isEmpty()) {
			noConversion.setVisibility(View.VISIBLE);
			conversionRecyclerView.setVisibility(View.GONE);
		}
		else {
			noConversion.setVisibility(View.GONE);
			conversionRecyclerView.setVisibility(View.VISIBLE);
			conversionListAdapter.setConversionList(conversionListElements);
			conversionListAdapter.notifyDataSetChanged();
		}
	}

}
