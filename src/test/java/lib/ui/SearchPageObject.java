package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_INIT_ELEMENT_PLACEHOLDER,
            CLOSE_BUTTON,
            SEARCH_RESULTS_BLOCK,
            SEARCH_RESULT_TITLE_ITEM_TPL;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT,
                "Не удалось найти строку инициализации поиска", 100);
        this.waitForElementPresent(SEARCH_INPUT,
                "Не удалось найти строку инициализации поиска после клика");
    }

    public void typeSearchLine(String value) {
        this.waitForElementAndSendKeys(SEARCH_INPUT,
                "Не удалось найти строку поиска", value, 5);
    }

    public String getValueSearchInputPlaceholder() {
        return this.waitForElementAndGetText(SEARCH_INIT_ELEMENT_PLACEHOLDER,
                "Не удалось получить значение плейсхолдера для строки инициализации поиска", 5);
    }

    public void clickCloseButton() {
        this.waitForElementAndClick(CLOSE_BUTTON, "Кнопка закрытия результатов поиска не найдена", 5);
    }

    public void waitSearchResultsBlockNotPresent() {
        this.waitForElementNotPresent(SEARCH_RESULTS_BLOCK, "Блок с результатами поиска должен быть скрыт", 5);
    }

    public void waitSearchResultsBlockPresent() {
        this.waitForElementPresent(SEARCH_RESULTS_BLOCK, "Блок с результатами поиска должен отображаться", 5);
    }

    public void swipeToArticle(String articleTitle) {
        String article = String.format(SEARCH_RESULT_TITLE_ITEM_TPL, articleTitle);
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(article, "Не найдена статья: " + articleTitle, 10);
        } else this.swipeUpTillElementAppear(article, "Не найдена статья: " + articleTitle, 10);
    }

    public void clickArticleTitle(String articleTitle) {
        String article = String.format(SEARCH_RESULT_TITLE_ITEM_TPL, articleTitle);
        this.waitForElementAndClick(article, "Не удалось выбрать статью: " + articleTitle, 5);
    }
}
