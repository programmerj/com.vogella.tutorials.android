package com.vogella.android.test.robolectric;

import com.vogella.android.test.robolectric.BuildConfig;
import com.vogella.android.test.robolectric.R;
import com.vogella.android.test.robolectric.WelcomeActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)

public class WelcomeActivityTest
{
    private WelcomeActivity activity;

    @Before
    public void setUp() throws Exception
    {
        activity = Robolectric.buildActivity( WelcomeActivity.class )
                              .create()
                              .resume()
                              .get();
    }

    @Test
    public void shouldNotBeNull() throws Exception
    {
        assertNotNull( activity );
    }

    @Test
    public void shouldHaveWelcomeFragment() throws Exception
    {
        assertNotNull( activity.getFragmentManager().findFragmentById( R.id.welcome_fragment ) );
    }
}
