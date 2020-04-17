package lib.ui.factories;


import lib.Platform;
import lib.ui.PopupObject;
import lib.ui.android.AndroidPopupObject;
import lib.ui.ios.IOSPopupObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PopupObjectFactory {

    public static PopupObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidPopupObject(driver);
        } else return new IOSPopupObject(driver);
    }
}
