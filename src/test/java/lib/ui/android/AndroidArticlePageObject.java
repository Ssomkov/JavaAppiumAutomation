package lib.ui.android;


import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_TITLE_TPL = "xpath://android.view.View[@content-desc='%s']";
        BOOKMARK_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/article_menu_bookmark']";
        BOOKMARK_POPUP_GOT_IT_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/onboarding_button']";
        BOOKMARK_MENU_CREATE_NEW_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/create_button']";
        BOOKMARK_CREATE_LIST_NAME_FIELD = "xpath://*[@resource-id='org.wikipedia:id/text_input']";
        BOOKMARK_CREATE_LIST_OK_BUTTON = "xpath://*[@resource-id='android:id/button1']";
        BOOKMARK_MENU_LIST_ITEM_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";
        SHOW_OVERFLOW_MENU_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']";
        OVERFLOW_MENU_READING_LISTS_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_action_overflow_reading_lists']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
