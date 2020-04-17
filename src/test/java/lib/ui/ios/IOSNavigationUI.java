package lib.ui.ios;


import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUI {

    static String
            RETURN_TO_SEARCH_BUTTON = "id:Back";

    public IOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
