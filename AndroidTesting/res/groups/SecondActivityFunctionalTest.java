import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;

public class ExampleTest {

    @Test
    @SmallTest
    public void validateSecondActivity() {
        // Do something not so long...
    }

    @Test
    @MediumTest
    public void validateSecondActivityAgain() {
        // Do something which takes more time....
    }

}
