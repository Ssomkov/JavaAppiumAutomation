package lib.ui.ios;


import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "xpath://XCUIElementTypeApplication[@name='Wikipedia']//XCUIElementTypeSearchField";
        SEARCH_INIT_ELEMENT_PLACEHOLDER = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        CLOSE_BUTTON = "id:Close";
        SEARCH_RESULTS_BLOCK = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView";
        SEARCH_RESULT_TITLE_ITEM_TPL = "xpath://XCUIElementTypeLink[@name='%s']";
    }

    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
