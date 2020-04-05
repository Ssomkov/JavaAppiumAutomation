package lib.ui.ios;


import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeApplication[@name='Wikipedia']//XCUIElementTypeSearchField";
        SEARCH_INIT_ELEMENT_PLACEHOLDER = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        CLOSE_BUTTON = "xpath://XCUIElementTypeButton[@name='Close']";
        SEARCH_RESULTS_BLOCK = "xpath://XCUIElementTypeCollectionView";
        SEARCH_RESULT_TITLE_ITEM_TPL = "xpath://XCUIElementTypeLink[@name='%s']";
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
