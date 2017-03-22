from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice
import commands
import sys
import os

# starting the application and test
print "Starting the monkeyrunner script"

if not os.path.exists("screenshots"):
    print "creating the screenshots directory"
    os.makedirs("screenshots")

# connection to the current device, and return a MonkeyDevice object
device = MonkeyRunner.waitForConnection()

apk_path = device.shell('pm path com.vogella.android.test.simpleactivity')
if apk_path.startswith('package:'):
    print "application installed."
else:
    print "not installed, install APK"
    device.installPackage('com.vogella.android.test.simpleactivity.apk')

print "starting application...."
device.startActivity(component='com.vogella.android.test.simpleactivity/[...CONTINUE]
com.vogella.android.test.simpleactivity.MainActivity')

#screenshot
MonkeyRunner.sleep(1)
result = device.takeSnapshot()
result.writeToFile('./screenshots/splash.png','png')
print "screenshot taken and stored on device"

#sending an event which simulate a click on the menu button
device.press('KEYCODE_MENU', MonkeyDevice.DOWN_AND_UP)

print "Finishing the test"
