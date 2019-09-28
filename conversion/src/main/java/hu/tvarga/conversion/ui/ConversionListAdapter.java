package hu.tvarga.conversion.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import hu.tvarga.conversion.R;
import hu.tvarga.conversion.R2;
import hu.tvarga.conversion.currencytocountry.CurrencyToCountryMapper;
import hu.tvarga.conversion.dto.ConversionListElement;
import hu.tvarga.rates.common.app.locale.LocaleProvider;
import hu.tvarga.rates.common.app.util.StringUtils;
import io.reactivex.subjects.PublishSubject;

import static hu.tvarga.conversion.currencytocountry.CurrencyToCountryMapper.UNKNOWN_CURRENCY_TO_COUNTRY_MAPPING;

public class ConversionListAdapter
		extends RecyclerView.Adapter<ConversionListAdapter.CurrencyListItemViewHolder> {

	private final LocaleProvider localeProvider;
	private final CurrencyToCountryMapper currencyToCountryMapper;
	private final PublishSubject<ConversionListElement> conversionListElementPublishSubject =
			PublishSubject.create();

	private List<ConversionListElement> listElements = new ArrayList<>();

	@Inject
	public ConversionListAdapter(LocaleProvider localeProvider,
			CurrencyToCountryMapper currencyToCountryMapper) {
		this.localeProvider = localeProvider;
		this.currencyToCountryMapper = currencyToCountryMapper;
	}

	@NonNull
	@Override
	public CurrencyListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversion_list_item,
				parent, false);
		return new CurrencyListItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull CurrencyListItemViewHolder holder, int position) {
		ConversionListElement conversionListElement = listElements.get(position);
		Locale currentLocale = localeProvider.getCurrentLocale();
		if (!holder.amount.isFocused()) {
			holder.amount.setText(conversionListElement.getValue());
		}
		String isoCodeString = conversionListElement.getISOCodeString();
		if (!isoCodeString.equals(holder.isoCode.getText().toString())) {
			holder.isoCode.setText(isoCodeString);
			holder.displayName.setText(conversionListElement.getDisplayName(currentLocale));
			Currency currency = Currency.getInstance(isoCodeString);

			String currencyCode = currency.getCurrencyCode();
			String countryCodeForCurrencyCode =
					currencyToCountryMapper.getCountryCodeForCurrencyCode(currencyCode);
			if (!UNKNOWN_CURRENCY_TO_COUNTRY_MAPPING.equals(countryCodeForCurrencyCode)) {
				Resources resources = holder.itemView.getResources();
				int resourceId = resources.getIdentifier(countryCodeForCurrencyCode.toLowerCase(),
						"drawable", holder.itemView.getContext().getPackageName());

				if (resourceId != 0) {
					Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);
					holder.flag.setImageBitmap(bitmap);
				}
				else {
					holder.flag.setImageResource(android.R.drawable.ic_menu_report_image);
				}
			}
		}
		holder.amount.setOnFocusChangeListener((v, hasFocus) -> {
			if (!hasFocus) {
				return;
			}
			if (position > 0) {
				List<ConversionListElement> newList = new ArrayList<>(listElements);
				newList.remove(position);
				Collections.sort(newList);
				newList.add(0, conversionListElement);
				DiffUtil.DiffResult diffResult = getDiffResult(this.listElements, newList);
				holder.itemView.post(() -> diffResult.dispatchUpdatesTo(this));

				listElements.clear();
				listElements.addAll(newList);

				conversionListElementPublishSubject.onNext(conversionListElement);
			}
		});
		holder.amount.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// not used
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// not used
			}

			@Override
			public void afterTextChanged(Editable s) {
				String newAmount = s.toString();
				if (!StringUtils.isNullOrEmpty(newAmount) && holder.amount.isFocused()) {
					conversionListElement.setValue(newAmount);
					listElements.get(0).setValue(newAmount);
					applyMultiplier(listElements);
					notifyItemRangeChanged(1, listElements.size() - 1);
					conversionListElementPublishSubject.onNext(conversionListElement);
				}
			}
		});
	}

	private void applyMultiplier(List<ConversionListElement> listElements) {
		for (int i = 1; i < listElements.size(); i++) {
			ConversionListElement listElement = listElements.get(i);
			listElement.setValue(getMultipliedAmountString(listElements, listElement));
		}
	}

	@NotNull
	private String getMultipliedAmountString(List<ConversionListElement> listElements,
			ConversionListElement conversionListElement) {
		String value = conversionListElement.getConversionRate();
		BigDecimal multiplied = new BigDecimal(value).multiply(
				new BigDecimal(listElements.get(0).getValue()));
		return String.format(localeProvider.getCurrentLocale(), "%.2f", multiplied);
	}

	public PublishSubject<ConversionListElement> getConversionListElementPublishSubject() {
		return conversionListElementPublishSubject;
	}

	@Override
	public int getItemCount() {
		return listElements.size();
	}

	void setConversionList(List<ConversionListElement> listElements) {
		applyMultiplier(listElements);
		//		DiffUtil.DiffResult diffResult = getDiffResult(this.listElements, listElements);
		//		diffResult.dispatchUpdatesTo(this);
		this.listElements.clear();
		this.listElements.addAll(listElements);
		notifyItemRangeChanged(1, listElements.size() - 1);
	}

	@NotNull
	private DiffUtil.DiffResult getDiffResult(List<ConversionListElement> oldList,
			List<ConversionListElement> newList) {
		return DiffUtil.calculateDiff(new DiffUtil.Callback() {

			@Override
			public int getOldListSize() {
				return oldList.size();
			}

			@Override
			public int getNewListSize() {
				return newList.size();
			}

			@Override
			public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
				return oldList.get(oldItemPosition).getCurrency().equals(
						newList.get(newItemPosition).getCurrency());
			}

			@Override
			public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
				return isEquals(oldItemPosition, newItemPosition);
			}

			private boolean isEquals(int oldItemPosition, int newItemPosition) {
				return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
			}

		});
	}

	class CurrencyListItemViewHolder extends RecyclerView.ViewHolder {

		@BindView(R2.id.amount)
		EditText amount;

		@BindView(R2.id.flag)
		ImageView flag;

		@BindView(R2.id.displayName)
		TextView displayName;

		@BindView(R2.id.isoCode)
		TextView isoCode;

		CurrencyListItemViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}

	}
}
