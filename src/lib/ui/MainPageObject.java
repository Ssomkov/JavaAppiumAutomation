package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String errorMessage, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement checkForElementPresent(By by, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 0);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementPresent(By by, String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean waitForElementNotPresent(By by, String errorMessage, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public String waitForElementAndGetText(By by, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        return element.getText();
    }

    public void waitForElementAndClick(By by, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        element.click();
    }

    public void waitForElementAndSendKeys(By by, String errorMessage, String value, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        element.sendKeys(value);
    }

    public String waitForElementAndGetTagName(By by, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        return element.getTagName();
    }

    public int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(By by, String errorMessage) {
        int amountOfElements = getAmountOfElements(by);
        if (amountOfElements > 0) {
            String defaultMeaasge = "An element '" + by.toString() + "' suppused to be not present";
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
                .press(x, startY)
                .waitAction(timeOfSwipe)
                .moveTo(x, endY)
                .release()
                .perform();
    }

    public void swipeUpQuick() {
        swipeUp(200);
    }

    public void swipeUpToFindElement(By by, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(by, "Элемент не найден свайпами. \n" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            alreadySwiped++;
        }
    }

    public void swipeElementToLeft(By by, String errorMessage) {
        WebElement element = waitForElementPresent(by, errorMessage, 10);

        int leftX = element.getLocation().getX();
        int rigtX = leftX + element.getSize().getWidth();
        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(rigtX, middleY)
                .waitAction(300)
                .moveTo(leftX, middleY)
                .release()
                .perform();
    }
}
