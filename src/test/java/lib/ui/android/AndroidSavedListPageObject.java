package lib.ui.android;


import lib.ui.SavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSavedListPageObject extends SavedListPageObject {

    static String ARTICLE_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='%s']";

    public AndroidSavedListPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
