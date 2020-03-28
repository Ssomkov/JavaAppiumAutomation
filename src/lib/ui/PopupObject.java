package lib.ui;

import io.appium.java_client.AppiumDriver;

public class PopupObject extends MainPageObject {

    private static final String SYNC_READING_LIST_NO_THANKS_BUTTON = "xpath://*[@resource-id='android:id/button2']";


    public PopupObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSyncReadingListNoThanksButton() {
        this.waitForElementAndClick(SYNC_READING_LIST_NO_THANKS_BUTTON, "Не найдена кнопка 'No thanks'  в окне синхронизации списков", 5);
    }
}
