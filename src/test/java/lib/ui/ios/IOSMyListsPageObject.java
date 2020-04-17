package lib.ui.ios;


import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {

    static String LIST_ITEM_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='%s')]";

    public IOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
