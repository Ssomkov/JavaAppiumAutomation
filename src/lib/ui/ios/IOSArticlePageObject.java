package lib.ui.ios;


import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_TITLE_TPL = "id:Java (programming language)";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        BOOKMARK_POPUP_GOT_IT_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/onboarding_button']";
        OPTIONS_SAVED_LISTS_BUTTON = "id:Saved";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
