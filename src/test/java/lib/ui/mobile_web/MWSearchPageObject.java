package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_INIT_ELEMENT_PLACEHOLDER = "xpath://input[@name='search']";
        CLOSE_BUTTON = "css:div.header-action button.cancel";
        SEARCH_RESULTS_BLOCK = "xpath://div[@class='results']";
        SEARCH_RESULT_TITLE_ITEM_TPL = "xpath://a[contains(@data-title, '%s')]";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
