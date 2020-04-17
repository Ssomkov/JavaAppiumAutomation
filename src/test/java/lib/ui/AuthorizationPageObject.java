package lib.ui;


import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {

    private static final String
            LOGIN_BUTTON = "xpath://a[contains(text(), 'Log in')]",
            LOGIN_INPUT = "xpath://input[@name='wpName']",
            PASSWORD_INPUT = "xpath://input[@name='wpPassword']",
            SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton() {
        this.waitForElementPresent(LOGIN_BUTTON, "Не найдена кнопка авторизации", 10);
        this.waitForElementAndClick(LOGIN_BUTTON, "Не удалось нажать кнопку авторизации", 10);
    }

    public void enterLoginData(String login, String password) {
        this.waitForElementAndSendKeys(LOGIN_INPUT, "Не удалось ввести данные в поле логина", login, 5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, "Не удалось ввести данные в поле пароля", password, 5);
    }

    public void submitForm() {
        waitForElementAndClick(SUBMIT_BUTTON, "Не найдена кнопка подтверждения авторизации", 5);
    }
}
