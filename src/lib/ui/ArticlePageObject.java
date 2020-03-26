package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ArticlePageObject extends MainPageObject {

    private static final String ARTICLE_TITLE_TPL = "//android.view.View[@content-desc='%s']";
    private static final By BOOKMARK_BUTTON = By.xpath("//*[@resource-id='org.wikipedia:id/article_menu_bookmark']");
    private static final By BOOKMARK_POPUP_GOT_IT_BUTTON = By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_button']");
    private static final By BOOKMARK_MENU_CREATE_NEW_BUTTON = By.xpath("//*[@resource-id='org.wikipedia:id/create_button']");
    private static final By BOOKMARK_CREATE_LIST_NAME_FIELD = By.xpath("//*[@resource-id='org.wikipedia:id/text_input']");
    private static final By BOOKMARK_CREATE_LIST_OK_BUTTON = By.xpath("//*[@resource-id='android:id/button1']");
    private static final String BOOKMARK_MENU_LIST_ITEM_TITLE_TPL = "//*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";
    private static final By SHOW_OVERFLOW_MENU_BUTTON = By.xpath("//*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']");
    private static final By OVERFLOW_MENU_READING_LISTS_BUTTON = By.xpath("//*[@resource-id='org.wikipedia:id/page_action_overflow_reading_lists']");

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkArticleTitlePresent(String articleTitle) {
        By title = By.xpath(String.format(ARTICLE_TITLE_TPL, articleTitle));
        this.checkForElementPresent(title, "Не найден заголовок статьи: " + articleTitle);
    }

    public void clickBookMarkButton() {
        this.waitForElementAndClick(BOOKMARK_BUTTON, "Не найдена иконка закладок", 5);
    }

    public void clickGotItButton() {
        this.waitForElementAndClick(BOOKMARK_POPUP_GOT_IT_BUTTON, "Не найдена кнопка 'GOT IT' в информационном окне закладок", 5);
    }

    public void clickBookMarkMenuCreateNewButton() {
        this.waitForElementAndClick(BOOKMARK_MENU_CREATE_NEW_BUTTON, "Не найден пункт меню 'CreateNew' в окне закладок", 5);
    }

    public void typeBookMarkCreateListNameField(String listName) {
        this.waitForElementAndSendKeys(BOOKMARK_CREATE_LIST_NAME_FIELD, "Не найдено поле ввода имени нового списка в закладках", listName, 5);
    }

    public void typeBookMarkCreateListOkButton() {
        this.waitForElementAndClick(BOOKMARK_CREATE_LIST_OK_BUTTON, "Не найдена кнопка 'OK' нового списка в закладках", 5);
    }

    public void clickBookMarkMenuListItemTitle(String listName) {
        By bookMarkListItem = By.xpath(String.format(BOOKMARK_MENU_LIST_ITEM_TITLE_TPL, listName));
        this.waitForElementAndClick(bookMarkListItem, "Не удалось найти сохраненный список: " + listName, 5);
    }

    public void clickShowOverflowMenuButton() {
        this.waitForElementAndClick(SHOW_OVERFLOW_MENU_BUTTON, "Кнопка всплывающего меню не найдена", 5);
    }

    public void clickOverflowMenuReadingListsButton() {
        this.waitForElementAndClick(OVERFLOW_MENU_READING_LISTS_BUTTON, "Пункт всплывающего меню 'Reading lists' не найден", 5);
    }

    public String getValueArticleTitle(String articleTitle) {
        By title = By.xpath(String.format(ARTICLE_TITLE_TPL, articleTitle));
        return this.waitForElementAndGetTagName(title, "Не удалось получить заголовок статьи: " + articleTitle, 10);
    }
}
