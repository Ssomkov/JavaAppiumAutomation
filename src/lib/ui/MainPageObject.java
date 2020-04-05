package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String errorMessage, long timeOutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement checkForElementPresent(String locator, String errorMessage) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, 0);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(String locator, String errorMessage) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean waitForElementNotPresent(String locator, String errorMessage, long timeOutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public String waitForElementAndGetText(String locator, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeOutInSeconds);
        return element.getText();
    }

    public void waitForElementAndClick(String locator, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeOutInSeconds);
        element.click();
    }

    public void waitForElementAndSendKeys(String locator, String errorMessage, String value, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeOutInSeconds);
        element.sendKeys(value);
    }

    public String waitForElementAndGetTagName(String locator, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeOutInSeconds);
        return element.getTagName();
    }

    public String waitForElementAndGetAttributeName(String locator, String attribute, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeOutInSeconds);
        return element.getAttribute(attribute);
    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements > 0) {
            String defaultMeaasge = "An element '" + locator.toString() + "' suppused to be not present";
            throw new AssertionError(defaultMeaasge + " " + errorMessage);
        }
    }

    public void swipeUp(int timeOfSwipe) {
        TouchAction touchAction = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);
        int endY = (int) (size.getHeight() * 0.2);

        touchAction
                .press(PointOption.point(x, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpToFindElement(String locator, String errorMessage, int maxSwipes) {
        By by = this.getLocatorByString(locator);
        int alreadySwiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(locator, "Элемент не найден свайпами. \n" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            alreadySwiped++;
        }
    }

    public void swipeElementToLeft(String locator, String errorMessage) {
        WebElement element = waitForElementPresent(locator, errorMessage, 10);

        int leftX = element.getLocation().getX();
        int rigtX = leftX + element.getSize().getWidth();
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(PointOption.point(rigtX, middleY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();
    }

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath")) {
            return By.xpath(locator);
        } else if (byType.equals("id")) {
            return By.id(locator);
        } else throw new IllegalArgumentException("Не удалось получить тип локатора: " + locatorWithType);
    }

    public void swipeUpTillElementAppear(String locator, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;

        while (!isElementLocatedOnTheScreen(locator)) {
            if (alreadySwiped > maxSwipes) {
                Assert.assertTrue(errorMessage, this.isElementLocatedOnTheScreen(locator));
            }
            swipeUpQuick();
            ++maxSwipes;
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator) {
        int element_location_by_y = this
                .waitForElementPresent(locator, "Не удалось найти элемент", 10)
                .getLocation()
                .getY();
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }
}
