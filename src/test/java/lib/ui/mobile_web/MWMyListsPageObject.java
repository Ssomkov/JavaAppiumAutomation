package lib.ui.mobile_web;


import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {

    static String LIST_ITEM_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='%s')]";

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
