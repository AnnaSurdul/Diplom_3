package praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.util.ApiRequestBuilder.PASSWORD;
import static praktikum.util.ApiRequestBuilder.USER_EMAIL;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By headerEntry = By.xpath(".//h2[text() = 'Вход']");
    private final By inputEmail = By.xpath(".//input[@type = 'text']");
    private final By inputPassword = By.xpath(".//input[@type = 'password']");
    private final By buttonEnter = By.xpath(".//button[text() = 'Войти']");
    private final By linkRegister = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final By linkRecoverPassword = By.xpath(".//a[text() = 'Восстановить пароль']");

    @Step("Переход на страницу регистраии")
    public void openRegistrationPage() {
        driver.findElement(linkRegister).click();
    }

    @Step("Заполнение полей почты и пароля и нажать кнопку 'Войти'")
    public void login() {
        driver.findElement(inputEmail).sendKeys(USER_EMAIL);
        driver.findElement(inputPassword).sendKeys(PASSWORD);
        driver.findElement(buttonEnter).click();
    }

    @Step("Переход на страницу восстановления пароля")
    public void openRecoverPasswordPage() {
        driver.findElement(linkRecoverPassword).click();
    }

    public boolean checkHeaderEntry() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headerEntry));
        return driver.findElement(headerEntry).isDisplayed();
    }
}
