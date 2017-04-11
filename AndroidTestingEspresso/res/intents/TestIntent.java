package testing.android.vogella.com.simpleactivity;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class TestIntent {

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = 
    	new IntentsTestRule<>(MainActivity.class);

    @Test
    public void triggerIntentTest() {
        onView(withId(R.id.button)).perform(click());
        intended(allOf(
                hasAction(Intent.ACTION_CALL),
                hasData(INTENT_DATA_PHONE_NUMBER),
                toPackage(PACKAGE_ANDROID_DIALER)));
    }

}
