package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Platform {

    private static final String PLAFORM_IOS = "ios";
    private static final String PLAFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform() {
    }

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    private DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/hairbaton/Documents/IdeaProjects/JavaAppiumAutomation/apks/wiki.apk");
        capabilities.setCapability("orientation", "PORTRAIT");

        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone7");
        capabilities.setCapability("platformVersion", "13.3");
        capabilities.setCapability("app", "/Users/hairbaton/Documents/IdeaProjects/JavaAppiumAutomation/apks/wiki.app");
        capabilities.setCapability("orientation", "PORTRAIT");

        return capabilities;
    }

    private boolean isPlatform(String myPlatform) {
        String platform = getPlatformVar();
        return myPlatform.equals(platform);
    }

    private String getPlatformVar() {
        return System.getenv("PLATFORM");
    }

    public boolean isAndroid() {
        return isPlatform(PLAFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLAFORM_IOS);
    }

    public AppiumDriver getDriver() throws Exception {
        URL url = new URL(APPIUM_URL);

        if (this.isAndroid()) {
            return new AndroidDriver(url, this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()) {
            return new IOSDriver(url, getIOSDesiredCapabilities());
        } else throw new Exception("Не удалось определить тип драйвера. Имя платформы: " + this.getPlatformVar());
    }
}
