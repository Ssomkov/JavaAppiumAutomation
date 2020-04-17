package lib.ui.mobile_web;


import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {

    static String
            OPEN_NAVIGATION = "css:#mw-mf-main-menu-btton",
            MY_LISTS_LINK = "css:a[data-event-name='watchlist']";

    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
