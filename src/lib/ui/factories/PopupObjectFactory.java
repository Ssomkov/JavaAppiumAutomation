package lib.ui.factories;


import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.PopupObject;
import lib.ui.android.AndroidPopupObject;
import lib.ui.ios.IOSPopupObject;

public class PopupObjectFactory {

    public static PopupObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidPopupObject(driver);
        } else return new IOSPopupObject(driver);
    }
}
