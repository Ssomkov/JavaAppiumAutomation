package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String SEARCH_INIT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
    private static final String SEARCH_INPUT = "//*[@resource-id='org.wikipedia:id/search_src_text']";
    private static final String SEARCH_INIT_ELEMENT_PLACEHOLDER = "//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']";
    private static final String CLOSE_BUTTON = "//*[@resource-id='org.wikipedia:id/search_close_btn']";
    private static final String SEARCH_RESULTS_BLOCK = "//*[@resource-id='org.wikipedia:id/fragment_search_results']";
    private static final String SEARCH_RESULT_TITLE_ITEM_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='%s']";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),
                "Не удалось найти строку инициализации поиска", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),
                "Не удалось найти строку инициализации поиска после клика");
    }

    public void typeSearchLine(String value) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT),
                "Не удалось найти строку поиска", value, 5);
    }

    public String getValueSearchInputPlaceholder() {
        return this.waitForElementAndGetText(By.xpath(SEARCH_INIT_ELEMENT_PLACEHOLDER),
                "Не удалось получить значение плейсхолдера для строки инициализации поиска", 5);
    }

    public void clickCloseButton() {
        this.waitForElementAndClick(By.xpath(CLOSE_BUTTON), "Кнопка закрытия результатов поиска не найдена", 5);
    }

    public void waitSearchResultsBlockNotPresent() {
        this.waitForElementNotPresent(By.xpath(SEARCH_RESULTS_BLOCK), "Блок с результатами поиска должен быть скрыт", 5);
    }

    public void waitSearchResultsBlockPresent() {
        this.waitForElementPresent(By.xpath(SEARCH_RESULTS_BLOCK), "Блок с результатами поиска должен отображаться", 5);
    }

    public void swipeToArticle(String articleTitle) {
        By article = By.xpath(String.format(SEARCH_RESULT_TITLE_ITEM_TPL, articleTitle));
        this.swipeUpToFindElement(article, "Не найдена статья: " + articleTitle, 10);
    }

    public void clickArticleTitle(String articleTitle) {
        By article = By.xpath(String.format(SEARCH_RESULT_TITLE_ITEM_TPL, articleTitle));
        this.waitForElementAndClick(article, "Не удалось выбрать статью: " + articleTitle, 5);
    }
}
