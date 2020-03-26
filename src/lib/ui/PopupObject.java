package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PopupObject extends MainPageObject {

    private static final By SYNC_READING_LIST_NO_THANKS_BUTTON = By.xpath("//*[@resource-id='android:id/button2']");


    public PopupObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSyncReadingListNoThanksButton() {
        this.waitForElementAndClick(SYNC_READING_LIST_NO_THANKS_BUTTON, "Не найдена кнопка 'No thanks'  в окне синхронизации списков", 5);
    }
}
