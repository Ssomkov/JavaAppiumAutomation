package lib.ui.android;


import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {

    static String
            RETURN_TO_SEARCH_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";


    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
