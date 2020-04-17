package lib.ui.ios;


import lib.ui.PopupObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSPopupObject extends PopupObject {

    static String CLOSE_SYNC_LIST_WINDOW_BUTTON = "id:places auth close";

    public IOSPopupObject(RemoteWebDriver driver) {
        super(driver);
    }
}
