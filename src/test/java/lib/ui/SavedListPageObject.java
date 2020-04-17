package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SavedListPageObject extends MainPageObject {

    static String ARTICLE_TITLE_TPL;
    static String REMOVE_FROM_LIST_BUTTON;

    public SavedListPageObject(RemoteWebDriver driver) {
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

    public void deleteArticleByButton() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(REMOVE_FROM_LIST_BUTTON, "Не найдена кнопка удаления статьи", 5);
            driver.navigate().refresh();
        }
    }
}
