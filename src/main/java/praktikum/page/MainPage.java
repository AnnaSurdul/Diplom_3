package praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MainPage {

    private static String CURRENT_TAB_CLASS = "tab_tab_type_current__2BEPc";

    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By bunButton = By.xpath(".//span[text() = 'Булки']");
    private final By divBun = By.xpath(".//span[text() = 'Булки']/..");
    private final By sauceButton = By.xpath(".//span[text() = 'Соусы']");
    private final By divSauces = By.xpath(".//span[text() = 'Соусы']/..");
    private final By fillingButton = By.xpath(".//span[text() = 'Начинки']");
    private final By divFilling = By.xpath(".//span[text() = 'Начинки']/..");
    private final By headlineAssembleBurger = By.xpath(".//h1[text() = 'Соберите бургер']");
    private final By profileButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By enterToAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By placeOrderButton = By.xpath(".//button[text()= 'Оформить заказ']");

    @Step("Переход на страницу прфиля")
    public void openProfileButton() {
        driver.findElement(profileButton).click();
    }

    @Step("Переход на на страницу Входа")
    public void openLoginButton() {
        driver.findElement(enterToAccountButton).click();
    }

    @Step("Проверка загрузки главной страницы")
    public boolean checkLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headlineAssembleBurger));
        return driver.findElement(headlineAssembleBurger).isDisplayed();
    }

    @Step("Проверить, что есть кнопка Оформить заказ")
    public boolean checkButtonPlaceOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElementLocated(placeOrderButton, "Оформить заказ"));
        return driver.findElement(placeOrderButton).isDisplayed();
    }

    @Step("Проверка перехода в раздел «Соусы»")
    public boolean checkSauceButton() {
        driver.findElement(sauceButton).click();
        List<String> classList = Arrays.asList(driver.findElement(divSauces).getAttribute("class").split(" "));
        return classList.contains(CURRENT_TAB_CLASS);
    }

    @Step("Проверка перехода в раздел «<Булки>»")
    public boolean checkBunButton() {
        driver.findElement(sauceButton).click();
        driver.findElement(bunButton).click();
        List<String> classList = Arrays.asList(driver.findElement(divBun).getAttribute("class").split(" "));
        return classList.contains(CURRENT_TAB_CLASS);
    }

    @Step("Проверка перехода в раздел «Начинки»")
    public boolean checkFillingButton() {
        driver.findElement(fillingButton).click();
        List<String> classList = Arrays.asList(driver.findElement(divFilling).getAttribute("class").split(" "));
        return classList.contains(CURRENT_TAB_CLASS);
    }
}
