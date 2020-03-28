package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {

    private static final String PLAFORM_IOS = "ios";
    private static final String PLAFORM_ANDROID = "android";

    protected AppiumDriver driver;
    protected String apkFilePath;
    protected DesiredCapabilities capabilities;
    private static String appiumURL = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        capabilities = getCapabilitiesByPlatformEnv();

        driver = getDriverByPlatformEnv();
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

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLAFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "6.0");
            capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/hairbaton/Documents/IdeaProjects/JavaAppiumAutomation/apks/wiki.apk");
            capabilities.setCapability("orientation", "PORTRAIT");
        } else if (platform.equals(PLAFORM_IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone7");
            capabilities.setCapability("platformVersion", "13.3");
            capabilities.setCapability("app", "/Users/hairbaton/Documents/IdeaProjects/JavaAppiumAutomation/apks/wiki.app");
            capabilities.setCapability("orientation", "PORTRAIT");
        } else throw new Exception("Cannot ger platform name from env");

        return capabilities;
    }

    private AppiumDriver getDriverByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        AppiumDriver appiumDriver = null;
        if (platform.equals(PLAFORM_ANDROID)) {
            return new AndroidDriver(new URL(appiumURL), capabilities);
        } else if (platform.equals(PLAFORM_IOS)) {
            new IOSDriver(new URL(appiumURL), capabilities);
        } else throw new Exception("Cannot ger platform name from env");
        return appiumDriver;
    }
}
