package lib.ui.android;


import io.appium.java_client.AppiumDriver;
import lib.ui.SavedListPageObject;

public class AndroidSavedListPageObject extends SavedListPageObject {

    static String ARTICLE_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='%s']";

    public AndroidSavedListPageObject(AppiumDriver driver) {
        super(driver);
    }
}
