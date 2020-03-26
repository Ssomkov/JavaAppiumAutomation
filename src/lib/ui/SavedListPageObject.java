package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SavedListPageObject extends MainPageObject {

    private static final String ARTICLE_TITLE_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='%s']";

    public SavedListPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void deleteArticleBySwipeToLeft(String articleTitle) {
        By title = By.xpath(String.format(ARTICLE_TITLE_TPL, articleTitle));
        this.swipeUpToFindElement(title, "Не найдена статья: " + articleTitle, 10);
        this.swipeElementToLeft(title, "Не удалось свайпнуть элемент: " + articleTitle);
    }

    public void waitArticleNotPresent(String articleTitle) {
        By title = By.xpath(String.format(ARTICLE_TITLE_TPL, articleTitle));
        this.waitForElementNotPresent(title, "Статья не должна отображаться: " + articleTitle, 5);
    }

    public void clickListItemTitle(String articleTitle) {
        By title = By.xpath(String.format(ARTICLE_TITLE_TPL, articleTitle));
        this.waitForElementAndClick(title, "Не найдена статья: " + articleTitle, 5);
    }
}
