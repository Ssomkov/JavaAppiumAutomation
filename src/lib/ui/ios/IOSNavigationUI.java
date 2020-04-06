package lib.ui.ios;


import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI {

    static String
            RETURN_TO_SEARCH_BUTTON = "id:Back";

    public IOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
