package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            RETURN_TO_SEARCH_BUTTON;

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickReturnToSearchButton() {
        this.waitForElementAndClick(RETURN_TO_SEARCH_BUTTON, "Не найдена кнопка возврата к результатам поиска", 5);
    }
}
