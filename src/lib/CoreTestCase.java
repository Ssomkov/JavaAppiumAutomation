package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {

        super.setUp();
        driver = Platform.getInstance().getDriver();
        rotateToPortrait();
        //skip start window
        skipStartWindow();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }

    protected void rotateToPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateToLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void skipStartWindow() {
        if (Platform.getInstance().isAndroid()) {
            WebElement skipButton = driver.findElementByXPath("//*[@resource-id='org.wikipedia:id/fragment_onboarding_skip_button']");
            skipButton.click();
        } else if (Platform.getInstance().isIOS()) {
            WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
            welcomePageObject.clickSkip();
        }
    }

}
