package lib.ui.ios;


import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static String LIST_ITEM_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='%s')]";

    public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
