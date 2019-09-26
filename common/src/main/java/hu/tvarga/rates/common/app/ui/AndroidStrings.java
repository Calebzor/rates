package hu.tvarga.rates.common.app.ui;

import android.content.res.Resources;

import androidx.annotation.ArrayRes;
import androidx.annotation.StringRes;

public class AndroidStrings implements Strings {

	private Resources res;

	public AndroidStrings(Resources res) {
		this.res = res;
	}

	@Override
	public String getString(@StringRes int resId) {
		return res.getString(resId);
	}

	@Override
	public String getString(@StringRes int resId, Object... formatArgs) {
		return res.getString(resId, formatArgs);
	}

	@Override
	public String[] getStringArray(@ArrayRes int resId) {
		return res.getStringArray(resId);
	}

}