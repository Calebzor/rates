package hu.tvarga.conversion.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import hu.tvarga.conversion.R;
import hu.tvarga.conversion.R2;
import hu.tvarga.conversion.currencytocountry.CurrencyToCountryMapper;
import hu.tvarga.conversion.dto.ConversionListElement;
import hu.tvarga.rates.common.app.locale.LocaleProvider;

import static hu.tvarga.conversion.currencytocountry.CurrencyToCountryMapper.UNKNOWN_CURRENCY_TO_COUNTRY_MAPPING;

public class ConversionListAdapter
		extends RecyclerView.Adapter<ConversionListAdapter.CurrencyListItemViewHolder> {

	private final LocaleProvider localeProvider;
	private final CurrencyToCountryMapper currencyToCountryMapper;

	private List<ConversionListElement> listElements;

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
		holder.amount.setText(conversionListElement.getValue());
		String isoCodeString = conversionListElement.getISOCodeString();
		holder.isoCode.setText(isoCodeString);
		holder.displayName.setText(conversionListElement.getDisplayName(currentLocale));
		Currency currency = Currency.getInstance(isoCodeString);

		String currencyCode = currency.getCurrencyCode();
		String countryCodeForCurrencyCode = currencyToCountryMapper.getCountryCodeForCurrencyCode(
				currencyCode);
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

	@Override
	public int getItemCount() {
		if (listElements == null) {
			return 0;
		}
		return listElements.size();
	}

	void setConversionList(List<ConversionListElement> listElements) {
		this.listElements = listElements;
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
