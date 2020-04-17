package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class SavedListPageObject extends MainPageObject {

    static String ARTICLE_TITLE_TPL;

    public SavedListPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void deleteArticleBySwipeToLeft(String articleTitle) {
        String title = String.format(ARTICLE_TITLE_TPL, articleTitle);
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(title, "Не найдена статья: " + articleTitle, 10);
        } else swipeUpTillElementAppear(title, "Не найдена статья: " + articleTitle, 40);
        if (Platform.getInstance().isIOS()) {
            this.ckickElementToTheRightUpperCorner(title, "Не найдена статья: " + articleTitle);
        }
        this.swipeElementToLeft(title, "Не удалось свайпнуть элемент: " + articleTitle);
    }

    public void waitArticleNotPresent(String articleTitle) {
        String title = String.format(ARTICLE_TITLE_TPL, articleTitle);
        this.waitForElementNotPresent(title, "Статья не должна отображаться: " + articleTitle, 5);
    }

    public void clickListItemTitle(String articleTitle) {
        String title = String.format(ARTICLE_TITLE_TPL, articleTitle);
        this.waitForElementAndClick(title, "Не найдена статья: " + articleTitle, 5);
    }
}
