package lib.ui.ios;


import lib.ui.SavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSavedListPageObject extends SavedListPageObject {

    static String ARTICLE_TITLE_TPL = "xpath://XCUIElementTypeLink[@name='%s']";

    public IOSSavedListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
