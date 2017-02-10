package com.example.android.rssreader;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RssfeedActivity extends Activity implements
		MyListFragment.OnItemSelectedListener {

	private boolean isDualPaneMode;
	private String mLastSelectedLink;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		isDualPaneMode = getResources().getBoolean(R.bool.twoPaneMode);

		FragmentManager fm = getFragmentManager();

		// ensure that the list fragment is added
		FragmentTransaction trx = fm.beginTransaction();
		trx.add(R.id.listcontainer, new MyListFragment(), "list");

		// add second fragment if in dual pane mode
		if (isDualPaneMode) {
			trx.add(R.id.detailscontainer, new MyListFragment(), "detail");

		}
		trx.commit();

		if (savedInstanceState != null) {
			mLastSelectedLink = savedInstanceState.getString("selectedLink",
					null);
			onRssItemSelected(mLastSelectedLink);
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mLastSelectedLink != null) {
			outState.putString("selectedLink", mLastSelectedLink);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_refresh:
			MyListFragment fragment = (MyListFragment) getFragmentManager()
					.findFragmentByTag("list");
			if (fragment != null) {
				fragment.updateListContent();
			}
			break;
		case R.id.action_settings:
			Intent intent = new Intent(this, MyPreferenceActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public void onRssItemSelected(String link) {
		mLastSelectedLink = link;
		FragmentManager fm = getFragmentManager();
		DetailFragment detailFragment = (DetailFragment) fm
				.findFragmentByTag("detail");
		if (detailFragment != null && detailFragment.isInLayout()) {
			detailFragment.setText(link);
		} else {
			// create and initialize fragment
			detailFragment = new DetailFragment();
			// configure link
			Bundle bundle = new Bundle();
			bundle.putString("link", link);
			detailFragment.setArguments(bundle);

			// add fragment
			FragmentTransaction trx = fm.beginTransaction();
			trx.replace(R.id.listcontainer, detailFragment, "detail");
			trx.addToBackStack(null);
			trx.commit();
		}
				
	}
}
