package com.vogella.android.test.simpleactivity.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vogella.android.test.simpleactivity.R;

import com.vogella.android.test.simpleactivity.MainActivity;
import com.vogella.android.test.simpleactivity.SecondActivity;

public class MainActivityFunctionalTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityFunctionalTest() {
		super(MainActivity.class);
	}

	public void testStartSecondActivity() throws Exception {
		
		MainActivity activity = getActivity();
		
		// add monitor to check for the second activity
		ActivityMonitor monitor = getInstrumentation().addMonitor(
				SecondActivity.class.getName(), null, false);

		// find button and click it
		Button view = (Button) activity.findViewById(R.id.button1);
		TouchUtils.clickView(this, view);
		
		// Wait 2 seconds for the start of the activity
		SecondActivity startedActivity = (SecondActivity) monitor
				.waitForActivityWithTimeout(2000);
		assertNotNull(startedActivity);

		// Search for the textView 
		TextView textView = (TextView) startedActivity.findViewById(R.id.resultText);
		
		// check that the TextView is on the screen
		ViewAsserts.assertOnScreen(startedActivity.getWindow().getDecorView(),
				textView);
		// Validate the text on the TextView
		assertEquals("Text incorrect", "Started", textView.getText().toString());
		
		// Press back and click again
		this.sendKeys(KeyEvent.KEYCODE_BACK);
		TouchUtils.clickView(this, view);

	}

}
