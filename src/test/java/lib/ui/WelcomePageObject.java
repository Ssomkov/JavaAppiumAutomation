package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia";
    private static final String STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore";
    private static final String STEP_ADD_OR_EDIT_PREFERRED_LANG_TEXT = "id:Add or edit preferred languages";
    private static final String STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_TEXT = "id:Learn more about data collected";
    private static final String NEXT_BUTTON = "id:Next";
    private static final String GET_STARTED_BUTTON = "id:Get started";
    private static final String SKIP = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,
                "Не найдена ссылка 'Learn more about Wikipedia'", 10);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(NEXT_BUTTON,
                "Не найдена кнопка 'Next'", 10);
    }

    public void waitForNewWayToExploreText() {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Не найден текст 'New ways to explore'", 10);
    }

    public void waitForAddOrEditPreferredLangText() {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_TEXT,
                "Не найден текст 'Add or edit preferred languages'", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_TEXT,
                "Не найден текст 'Learn more about data collected'", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(GET_STARTED_BUTTON,
                "Не найдена кнопка 'Get started'", 10);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP, "Не найдена кнопка 'Skip'", 10);
    }
}
