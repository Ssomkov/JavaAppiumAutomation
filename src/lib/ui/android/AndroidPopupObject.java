package lib.ui.android;


import io.appium.java_client.AppiumDriver;
import lib.ui.PopupObject;

public class AndroidPopupObject extends PopupObject {

    static String SYNC_READING_LIST_NO_THANKS_BUTTON = "xpath://*[@resource-id='android:id/button2']";

    public AndroidPopupObject(AppiumDriver driver) {
        super(driver);
    }
}
