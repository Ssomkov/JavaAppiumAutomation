package lib.ui.mobile_web;


import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_TITLE_TPL = "css:#content h1";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://a[@data-event-name='menu.watch']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[@data-event-name='menu.unwatch']";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
