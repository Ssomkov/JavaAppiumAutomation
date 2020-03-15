import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.OsCheck;

import java.net.URL;
import java.util.List;

public class FirstTest {

    private AppiumDriver driver;
    private String apkFilePath;

    private By searchFieldFirstPage = By.xpath("//*[@resource-id='org.wikipedia:id/search_container']");
    private By searchFieldSecondPage = By.xpath("//*[@resource-id='org.wikipedia:id/search_src_text']");
    private By closeButtonSecondPage = By.xpath("//*[@resource-id='org.wikipedia:id/search_close_btn']");
    private By searchResultsBlock = By.xpath("//*[@resource-id='org.wikipedia:id/fragment_search_results']");
    private By searchFieldFirstPagePlaceholder = By.xpath("//*[@resource-id='org.wikipedia:id/search_container']//*[@class='android.widget.TextView']");
    private String searhResultTitleItem = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='%s']";
    private By bookMarkButton = By.xpath("//*[@resource-id='org.wikipedia:id/article_menu_bookmark']");
    private By bookMarkInfoWindowGotItButton = By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_button']");
    private By bookMarkMenuCreateNewButton = By.xpath("//*[@resource-id='org.wikipedia:id/create_button']");
    private By bookMarkCreateListNameField = By.xpath("//*[@resource-id='org.wikipedia:id/text_input']");
    private By bookMarkCreateListOkButton = By.xpath("//*[@resource-id='android:id/button1']");
    private String bookMarkListTitle = "//*[@resource-id='org.wikipedia:id/item_title'][@text='%s']";
    private By returnToSearchButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    private By syncReadingListNoButton = By.xpath("//*[@resource-id='android:id/button2']");
    private By overflowMenuButton = By.xpath("//*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']");
    private By overflowMenuReadingListsButton = By.xpath("//*[@resource-id='org.wikipedia:id/page_action_overflow_reading_lists']");
    private String articleTitle = "//android.view.View[@content-desc='%s']";


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

    @Test
    public void checkCancelSearch() {
        boolean isSearchResultsNotPresent = false;
        waitForElementAndClick(searchFieldFirstPage, "Поле ввода 'Search string' не найдено", 10);
        waitForElementAndSendKeys(searchFieldSecondPage, "Поле ввода 'Search Wikipedia' не найдено", "Japan", 5);
        waitForElementAndClick(closeButtonSecondPage, "Кнопка закрытия результатов поиска не найдена", 5);
        isSearchResultsNotPresent = waitForElementNotPresent(searchResultsBlock, "Блок с результатами поиска должен быть скрыт", 5);
        Assert.assertTrue("Блок с результатами поиска должен быть скрыт", isSearchResultsNotPresent);
    }

    @Test
    public void checkDeletedArticles() {
        String listName = "test bookmark list";
        String firstSearchValue = "Java";
        String secondSearchValue = "Oracle";
        String firstArticleName = "Java (programming language)";
        String secondArticleName = "Oracle Corporation";
        //поиск 1 статьи
        waitForElementAndClick(searchFieldFirstPage, "Поле ввода 'Search string' не найдено", 10);
        waitForElementAndSendKeys(searchFieldSecondPage, "Поле ввода 'Search Wikipedia' не найдено", firstSearchValue, 5);
        waitForElementPresent(searchResultsBlock, "Блок с результатами поиска не найден", 5);
        By firstArticleTitle = By.xpath(String.format(searhResultTitleItem, firstArticleName));
        //выбор 1 статьи
        swipeUpToFindElement(firstArticleTitle, "Не найдена статья: " + firstArticleName, 10);
        waitForElementAndClick(firstArticleTitle, "Не удалось выбрать статью: " + firstArticleName, 5);
        //выбор закладок
        waitForElementAndClick(bookMarkButton, "Не удалось найти иконку закладок", 5);
        //закрытие всплывающего окна
        waitForElementAndClick(bookMarkInfoWindowGotItButton, "Не удалось найти кнопку 'GOT IT' в информационном окне закладок", 5);
        //создание нового списка
        waitForElementAndClick(bookMarkMenuCreateNewButton, "Пункт меню 'CreateNew'  в закладках не найден", 5);
        waitForElementAndSendKeys(bookMarkCreateListNameField, "Поле ввода имени нового списка в закладках не найдено", listName, 5);
        waitForElementAndClick(bookMarkCreateListOkButton, "Не найдена кнопка 'OK' нового списка в закладках", 5);
        //возврат к результатам поиска
        waitForElementAndClick(returnToSearchButton, "Не найдена кнопка возврата к результатам поиска", 5);
        //закрытие всплывающего окна
        waitForElementAndClick(syncReadingListNoButton, "Не найдена кнопка 'No thanks'  в окне синхронизации списков", 5);
        //поиск 2 статьи
        waitForElementAndClick(searchFieldFirstPage, "Поле ввода 'Search string' не найдено", 10);
        waitForElementAndSendKeys(searchFieldSecondPage, "Поле ввода 'Search Wikipedia' не найдено", secondSearchValue, 5);
        waitForElementPresent(searchResultsBlock, "Блок с результатами поиска не найден", 5);
        By secondArticleTitle = By.xpath(String.format(searhResultTitleItem, secondArticleName));
        //выбор 2 статьи
        swipeUpToFindElement(secondArticleTitle, "Не найдена статья: " + secondArticleName, 10);
        waitForElementAndClick(secondArticleTitle, "Не удалось выбрать статью: " + secondArticleTitle, 5);
        //выбор закладок
        waitForElementAndClick(bookMarkButton, "Не удалось найти иконку закладок", 5);
        //сохранение 2 статьи в список
        By bookMarkListItem = By.xpath(String.format(bookMarkListTitle, listName));
        waitForElementAndClick(bookMarkListItem, "Не удалось найти сохраненный список: " + listName, 5);
        //открытие сохраненного списка
        waitForElementAndClick(overflowMenuButton, "Кнопка всплывающего меню не найдена", 5);
        waitForElementAndClick(overflowMenuReadingListsButton, "Пункт всплывающего меню 'Reading lists' не найден", 5);
        waitForElementAndClick(syncReadingListNoButton, "Не найдена кнопка 'No thanks'  в окне синхронизации списков", 5);
        waitForElementAndClick(bookMarkListItem, "Не удалось найти сохраненный список: " + listName, 5);
        //удаление статьи
        swipeUpToFindElement(secondArticleTitle, "Не найдена статья: " + secondArticleTitle, 10);
        swipeElementToLeft(secondArticleTitle, "Не удалось свайпнуть элемент: " + secondArticleTitle);
        //проверка что статья удалена
        waitForElementNotPresent(secondArticleTitle, "Статья не должна отображаться", 5);
        //проверка заголовка оставшейся статьи
        waitForElementAndClick(firstArticleTitle, "Не найдена статья: " + firstArticleTitle, 5);
        By t = By.xpath(String.format(articleTitle, firstArticleName));
        String titleOfFirstArticle = waitForElementAndGetTagName(t, "Не удалось получить заголовок статьи: " + firstArticleTitle, 5);
        Assert.assertEquals("Заголовок статьи не совпадает", firstArticleName, titleOfFirstArticle);
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

    private boolean waitForElementNotPresent(By by, String errorMessage, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private String waitForElementAndGetText(By by, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        return element.getText();
    }

    private void waitForElementAndClick(By by, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        element.click();
    }

    private void waitForElementAndSendKeys(By by, String errorMessage, String value, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        element.sendKeys(value);
    }


    private String waitForElementAndGetTagName(By by, String errorMessage, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, errorMessage, timeOutInSeconds);
        return element.getTagName();
    }

    private int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String errorMessage) {
        int amountOfElements = getAmountOfElements(by);
        if (amountOfElements > 0) {
            String defaultMeaasge = "An element '" + by.toString() + "' suppused to be not present";
            throw new AssertionError(defaultMeaasge + " " + errorMessage);
        }
    }

    private void swipeUp(int timeOfSwipe) {
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

    private void swipeUpQuick() {
        swipeUp(200);
    }

    private void swipeUpToFindElement(By by, String errorMessage, int maxSwipes) {
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

    private void swipeElementToLeft(By by, String errorMessage) {
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
