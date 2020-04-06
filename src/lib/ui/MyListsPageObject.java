package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class MyListsPageObject extends MainPageObject {

    static final String LIST_ITEM_TITLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickListItemTitle(String listName) {
        String listItem = String.format(LIST_ITEM_TITLE_TPL, listName);
        this.waitForElementAndClick(listItem, "Не удалось найти сохраненный список: " + listName, 5);
    }

}
