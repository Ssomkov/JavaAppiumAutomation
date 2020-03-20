package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    private static final By RETURN_TO_SEARCH_BUTTON = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickReturnToSearchButton() {
        this.waitForElementAndClick(RETURN_TO_SEARCH_BUTTON, "Не найдена кнопка возврата к результатам поиска", 5);
    }
}
