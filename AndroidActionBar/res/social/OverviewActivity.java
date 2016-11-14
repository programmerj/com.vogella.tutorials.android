package com.example.android.rssreader;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.Toolbar;

public class RssfeedActivity extends Activity implements
        MyListFragment.OnItemSelectedListener {

    SelectionStateFragment stateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);

        // #<1>
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(tb);
        // as before
    }

    // #<2>
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.inflateMenu(R.menu.mainmenu);
        tb.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }
                });
        return true;
    }

    // #<3>
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Action Settings selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRssItemSelected(String link) {
    	// as before
    }


}
