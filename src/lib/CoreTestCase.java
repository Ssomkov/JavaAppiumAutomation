package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utility.OsCheck;

import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    protected String apkFilePath;
    private static String appiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        OsCheck.OSType osType = OsCheck.getOperatingSystemType();
        switch (osType) {
            case Windows:
                apkFilePath = "C:\\Users\\ssomk\\IdeaProjects\\JavaAppiumAutomation\\apks\\wiki.apk";
                break;
            case MacOS:
                apkFilePath = "/Users/hairbaton/Documents/IdeaProjects/JavaAppiumAutomation/apks/wiki.apk";
                break;
            default:
                apkFilePath = "C:\\Users\\ssomk\\IdeaProjects\\JavaAppiumAutomation\\apks\\wiki.apk";
                break;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", apkFilePath);
        capabilities.setCapability("orientation", "PORTRAIT");

        driver = new AndroidDriver(new URL(appiumURL), capabilities);
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
        WebElement skipButton = driver.findElementByXPath("//*[@resource-id='org.wikipedia:id/fragment_onboarding_skip_button']");
        skipButton.click();
    }
}
