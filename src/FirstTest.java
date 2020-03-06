import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.OsCheck;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;
    private String apkFilePath;

    private By searchFieldFirstPagePlaceholder = By.xpath("//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']");

    @Before
    public void setUP() throws Exception {

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

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //skip start window
        WebElement skipButton = driver.findElementByXPath("//*[@resource-id='org.wikipedia:id/fragment_onboarding_skip_button']");
        skipButton.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkValueSearchStringPlaceholderFirstPage() {
        String textFromField = waitForElementAndGetText(searchFieldFirstPagePlaceholder,
                "Поле ввода 'Search string' не найдено", 10);
        Assert.assertTrue("Значение плейсхолдера в поле ввода 'Search string' отличается от ожидаемого",
                textFromField.contains("Search"));
    }

    private WebElement waitForElementPresent(By by, String errorMessage, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private String waitForElementAndGetText(By by, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        return element.getText();
    }
}
