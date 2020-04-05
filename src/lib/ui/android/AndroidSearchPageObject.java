package lib.ui.android;


import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
        SEARCH_INPUT = "xpath://*[@resource-id='org.wikipedia:id/search_src_text']";
        SEARCH_INIT_ELEMENT_PLACEHOLDER = "xpath://*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
        CLOSE_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_close_btn']";
        SEARCH_RESULTS_BLOCK = "xpath://*[@resource-id='org.wikipedia:id/fragment_search_results']";
        SEARCH_RESULT_TITLE_ITEM_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='%s']";
    }

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
