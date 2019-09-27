package hu.tvarga.rates.main;

import android.os.Bundle;
import android.transition.Slide;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import dagger.android.support.DaggerAppCompatActivity;
import hu.tvarga.conversion.ui.ConversionFragment;
import hu.tvarga.rates.R;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class MainActivity extends DaggerAppCompatActivity
		implements hu.tvarga.rates.common.ui.BaseFragment.FragmentNavigator,
		FragmentManager.OnBackStackChangedListener {

	public static final int FRAGMENT_CONTAINER_ID = R.id.fragmentContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		FragmentManager supportFragmentManager = getSupportFragmentManager();
		supportFragmentManager.addOnBackStackChangedListener(this);

		if (savedInstanceState == null) {
			setInitialFragment(ConversionFragment.newInstance());
		}
		else {
			onBackStackChanged();
		}
	}

	protected void setInitialFragment(hu.tvarga.rates.common.ui.BaseFragment fragment) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(FRAGMENT_CONTAINER_ID, fragment);
		ft.addToBackStack(fragment.getClass().getName()).commit();
	}

	@Override
	public void replaceFragment(hu.tvarga.rates.common.ui.BaseFragment fragment) {
		replaceFragment(fragment, true);
	}

	public void replaceFragment(hu.tvarga.rates.common.ui.BaseFragment fragment,
			boolean addToBackStack) {
		Slide transition = new Slide();
		fragment.setEnterTransition(transition);
		fragment.setExitTransition(transition);
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(FRAGMENT_CONTAINER_ID, fragment);
		if (addToBackStack) {
			fragmentTransaction.addToBackStack(fragment.getClass().getName());
		}
		fragmentTransaction.commit();
	}

	@Override
	public void onBackStackChanged() {
		boolean isUp = isUp();

		ActionBar supportActionBar = getSupportActionBar();
		if (supportActionBar != null) {
			supportActionBar.setDisplayHomeAsUpEnabled(isUp);
			supportActionBar.show();
			if (!isUp) {
				supportActionBar.hide();
			}
		}
	}

	private boolean isUp() {
		FragmentManager supportFragmentManager = getSupportFragmentManager();
		int stackEntryCount = supportFragmentManager.getBackStackEntryCount();

		return stackEntryCount > 1;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home && isUp()) {
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		if (isUp()) {
			super.onBackPressed();
		}
	}
}
