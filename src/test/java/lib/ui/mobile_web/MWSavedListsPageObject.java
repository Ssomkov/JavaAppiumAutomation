package lib.ui.mobile_web;


import lib.ui.SavedListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSavedListsPageObject extends SavedListPageObject {

    static String ARTICLE_TITLE_TPL = "xpath://div[@id='mw-content-text']//h3[text()='%s']";

    public MWSavedListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
