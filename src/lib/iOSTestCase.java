package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class iOSTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String appiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone7");
        capabilities.setCapability("platformVersion", "13.3");
        capabilities.setCapability("app", "/Users/hairbaton/Documents/IdeaProjects/JavaAppiumAutomation/apks/wiki.app");
        capabilities.setCapability("orientation", "PORTRAIT");

        driver = new IOSDriver(new URL(appiumURL), capabilities);
        rotateToPortrait();
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

}
