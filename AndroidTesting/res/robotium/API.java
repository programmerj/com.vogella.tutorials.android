
// check that we have the right activity
solo.assertCurrentActivity("wrong activity", SimpleActivity.class);

// Click a button which will start a new Activity
// Here we use the ID of the string to find the right button
solo.clickOnButton(solo.getString(R.string.button1));
// Validate that the Activity is the correct one
solo.assertCurrentActivity("wrong activity", SimpleListActivity.class);
solo.clickInList(1);
// searchForText has a timeout of 5 seconds
assertTrue(solo.waitForText("Android")); // Assertion
solo.clickInList(2);
assertTrue(solo.waitForText("iPhone")); // Assertion
solo.clickInList(3);
assertTrue(solo.waitForText("Blackberry")); // Assertion
solo.goBack();
solo.clickOnButton("Button2");
solo.clickOnButton("Button3");

// Open the menu
solo.sendKey(Solo.MENU);
solo.clickOnText("Preferences");
solo.clickOnText("User");
solo.clearEditText(0);
Assert.assertTrue(solo.searchText(""));
solo.enterText(0, "http//:www.vogella.com");
Assert.assertTrue(solo.searchText("http//:www.vogella.com"));
solo.goBack();
