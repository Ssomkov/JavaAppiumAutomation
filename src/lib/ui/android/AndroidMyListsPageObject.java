package lib.ui.android;


import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static String LIST_ITEM_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";

    public AndroidMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
