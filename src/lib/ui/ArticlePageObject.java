package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            ARTICLE_TITLE_TPL,
            BOOKMARK_BUTTON,
            BOOKMARK_POPUP_GOT_IT_BUTTON,
            BOOKMARK_MENU_CREATE_NEW_BUTTON,
            BOOKMARK_CREATE_LIST_NAME_FIELD,
            BOOKMARK_CREATE_LIST_OK_BUTTON,
            BOOKMARK_MENU_LIST_ITEM_TITLE_TPL,
            SHOW_OVERFLOW_MENU_BUTTON,
            OVERFLOW_MENU_READING_LISTS_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_SAVED_LISTS_BUTTON;

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void checkArticleTitlePresent(String articleTitle) {
        String title = String.format(ARTICLE_TITLE_TPL, articleTitle);
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
        String bookMarkListItem = String.format(BOOKMARK_MENU_LIST_ITEM_TITLE_TPL, listName);
        this.waitForElementAndClick(bookMarkListItem, "Не удалось найти сохраненный список: " + listName, 5);
    }

    public void clickShowOverflowMenuButton() {
        this.waitForElementAndClick(SHOW_OVERFLOW_MENU_BUTTON, "Кнопка всплывающего меню не найдена", 5);
    }

    public void clickOverflowMenuReadingListsButton() {
        this.waitForElementAndClick(OVERFLOW_MENU_READING_LISTS_BUTTON, "Пункт всплывающего меню 'Reading lists' не найден", 5);
    }

    public String getValueArticleTitle(String articleTitle) {
        String title = String.format(ARTICLE_TITLE_TPL, articleTitle);
        if (Platform.getInstance().isAndroid()) {
            return this.waitForElementAndGetTagName(title, "Не удалось получить заголовок статьи: " + articleTitle, 10);
        } else
            return this.waitForElementAndGetAttributeName(title, "name", "Не удалось получить заголовок статьи: " + articleTitle, 10);
    }

    public void addArticlesToMySaved() {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Не удалось найти опцию добавления статьи в сохраненный список", 10);
    }

    public void openSavedArticlesList() {
        this.waitForElementAndClick(OPTIONS_SAVED_LISTS_BUTTON, "Не удалось найти опцию открытия списка сохраненных статей", 10);
    }
}
