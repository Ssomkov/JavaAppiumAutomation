package lib.ui.android;


import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

    static String
            RETURN_TO_SEARCH_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";


    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
