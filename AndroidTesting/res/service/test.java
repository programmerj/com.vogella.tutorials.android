@RunWith(AndroidJUnit4.class)
@MediumTest
public class MyServiceTest {

    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();

    // test for a service which is started with startService
    @Test
    public void testWithStartedService() {
        mServiceRule.
        startService(new Intent(InstrumentationRegistry.getTargetContext(), 
        		MyService.class));
        // test code
    }

    @Test
 // test for a service which is started with bindService
    public void testWithBoundService() {
        IBinder binder = mServiceRule.
        		bindService(new Intent(InstrumentationRegistry.getTargetContext(), 
        				MyService.class));
        MyService service = ((MyService.LocalBinder) binder).getService();
        assertTrue("True wasn't returned", service.doSomethingToReturnTrue());
    }
}