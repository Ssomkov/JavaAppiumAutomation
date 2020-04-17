package lib.ui.android;


import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static String LIST_ITEM_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
