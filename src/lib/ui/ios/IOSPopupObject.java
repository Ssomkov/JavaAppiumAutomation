package lib.ui.ios;


import io.appium.java_client.AppiumDriver;
import lib.ui.PopupObject;

public class IOSPopupObject extends PopupObject {

    static String CLOSE_SYNC_LIST_WINDOW_BUTTON = "id:places auth close";

    public IOSPopupObject(AppiumDriver driver) {
        super(driver);
    }
}
