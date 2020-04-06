package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class PopupObject extends MainPageObject {

    static String
            SYNC_READING_LIST_NO_THANKS_BUTTON,
            CLOSE_SYNC_LIST_WINDOW_BUTTON;


    public PopupObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSyncReadingListNoThanksButton() {
        this.waitForElementAndClick(SYNC_READING_LIST_NO_THANKS_BUTTON, "Не найдена кнопка 'No thanks'  в окне синхронизации списков", 5);
    }

    public void clickCloseSyncReadingListWindowButton() {
        this.waitForElementAndClick(CLOSE_SYNC_LIST_WINDOW_BUTTON, "Не найдена кнопка 'x'  в окне синхронизации списков", 5);
    }
}
