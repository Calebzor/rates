package hu.tvarga.rates.common.app.ui;

import androidx.annotation.ArrayRes;
import androidx.annotation.StringRes;

public interface Strings {

	String getString(@StringRes int resId);

	String getString(@StringRes int resId, Object... formatArgs);

	String[] getStringArray(@ArrayRes int resId);
}