package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {

    static final String LIST_ITEM_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickListItemTitle(String listName) {
        String listItem = String.format(LIST_ITEM_TITLE_TPL, listName);
        this.waitForElementAndClick(listItem, "Не удалось найти сохраненный список: " + listName, 5);
    }

}
