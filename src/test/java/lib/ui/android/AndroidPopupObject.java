package lib.ui.android;


import lib.ui.PopupObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidPopupObject extends PopupObject {

    static String SYNC_READING_LIST_NO_THANKS_BUTTON = "xpath://*[@resource-id='android:id/button2']";

    public AndroidPopupObject(RemoteWebDriver driver) {
        super(driver);
    }
}
