package hu.tvarga.rates.common.ui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.DaggerFragment;

/**
 * This helps us with view binding and class injection
 */
public class BaseFragment extends DaggerFragment {

	private Unbinder unbinder;

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		unbinder = ButterKnife.bind(this, view);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (unbinder != null) {
			unbinder.unbind();
		}
	}

	protected void replaceFragment(BaseFragment baseFragment) {
		FragmentActivity activity = getActivity();
		if (activity instanceof FragmentNavigator) {
			((FragmentNavigator) activity).replaceFragment(baseFragment);
		}
	}

	protected void setToolbarTitle(@StringRes int titleStringRes) {
		FragmentActivity activity = getActivity();
		if (activity instanceof DaggerAppCompatActivity) {
			ActionBar supportActionBar = ((DaggerAppCompatActivity) activity).getSupportActionBar();
			if (supportActionBar != null) {
				supportActionBar.setTitle(titleStringRes);
			}
		}
	}

	public interface FragmentNavigator {

		void replaceFragment(BaseFragment baseFragment);

	}
}
