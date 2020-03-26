package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject {

    private static final String LIST_ITEM_TITLE_TPL = "//*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickListItemTitle(String listName) {
        By listItem = By.xpath(String.format(LIST_ITEM_TITLE_TPL, listName));
        this.waitForElementAndClick(listItem, "Не удалось найти сохраненный список: " + listName, 5);
    }

}
