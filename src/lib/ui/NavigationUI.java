package lib.ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject {

    private static final String RETURN_TO_SEARCH_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickReturnToSearchButton() {
        this.waitForElementAndClick(RETURN_TO_SEARCH_BUTTON, "Не найдена кнопка возврата к результатам поиска", 5);
    }
}
