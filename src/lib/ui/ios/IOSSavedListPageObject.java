package lib.ui.ios;


import io.appium.java_client.AppiumDriver;
import lib.ui.SavedListPageObject;

public class IOSSavedListPageObject extends SavedListPageObject {

    static String ARTICLE_TITLE_TPL = "xpath://XCUIElementTypeLink[@name='%s']";

    public IOSSavedListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
