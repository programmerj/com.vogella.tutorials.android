package com.vogella.android.robolectric;

import android.content.Intent;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class AdditionalMainActivityTest {

	private MainActivity activity;

	@Before
	public void setup()  {
		activity = Robolectric.buildActivity(MainActivity.class).create().get();
	}

	@Test
	public void checkActivityNotNull() throws Exception {
		assertNotNull(activity);
	}

	@Test
	public void shouldHaveCorrectAppName() throws Exception {
		String hello = activity.getResources().getString(R.string.app_name);
		assertThat(hello, equalTo("Hello world!"));
	}


	@Test
	public void buttonClickShouldStartNewActivity() throws Exception 
	{
	    Button button = (Button) activity.findViewById( R.id.button2 );
	    button.performClick();
	    Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
	    assertEquals(SecondActivity.class.getCanonicalName(), intent.getComponent().getClassName());
	}
	
	@Test
	public void testButtonClick() throws Exception {
		MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
		Button view = (Button) activity.findViewById(R.id.button1);
		assertNotNull(view);
		view.performClick();
		assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Lala") );
	}

}