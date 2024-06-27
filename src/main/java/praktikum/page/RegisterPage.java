package praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By textRegistration = By.xpath(".//h2[text() = 'Регистрация']");
    private final By inputName = By.xpath(".//label[text() = 'Имя']/../input");
    private final By inputEmail = By.xpath(".//label[text() = 'Email']/../input");
    private final By inputPassword = By.xpath(".//input[@type = 'password']");
    private final By buttonRegister = By.xpath(".//button[text()  = 'Зарегистрироваться']");
    private final By linkToLoginPage = By.xpath(".//a[text() = 'Войти']");
    private final By invalidPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    @Step("Ввести name, email, пароль и нажать кнопку зарегистрироваться")
    public void register(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonRegister).click();
    }

    @Step("Перейти на страницу Вход через кнопку Войти")
    public void openLoginPagePage() {
        driver.findElement(linkToLoginPage).click();
    }

    @Step("Проверить, что отображается текст Некорректный пароль")
    public boolean checkMessageInvalidPassword() {
        return driver.findElement(invalidPassword).isDisplayed();
    }
    @Step("Ожидание загрузки страницы")
    public void waitingForLoadPage() {

    }





}