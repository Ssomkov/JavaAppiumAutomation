package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
            RETURN_TO_SEARCH_BUTTON,
            MY_LISTS_LINK,
            OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation() {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Не найдена кнопка меню навигации", 5);
        } else
            System.out.println("Метод openNavigation не работает для платформы: " + Platform.getInstance().getPlatformVar());
    }

    public void clickReturnToSearchButton() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(RETURN_TO_SEARCH_BUTTON, "Не найдена кнопка возврата к результатам поиска", 5);
        }
    }

    public void clickMyLists() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(MY_LISTS_LINK, "Не найдена кнопка Watchlist", 5);
        }
    }
}
