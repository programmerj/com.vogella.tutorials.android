@Override
public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	// more code...
	case R.id.preferences:
		// Launch settings activity
		Intent i = new Intent(this, SettingsActivity.class);
		startActivity(i);
		break;
		// more code...
	}
	// more code...
}