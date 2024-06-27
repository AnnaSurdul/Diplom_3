package praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
//    private final By textDescription = By.className("Account_text__fZAIn");
    private final By textDescription = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    private final By exitButton = By.xpath(".//button[text() = 'Выход']");
    private final By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");

    @Step("Проверка станицы личного кабинета пользователя")
    public boolean checkPageDescription() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textDescription));
        return driver.findElement(textDescription).isDisplayed();
    }

    @Step("Проверка перехода из личного кабинета пользователя в конструктор")
    public void openConstructor() {
        driver.findElement(constructorButton).click();
    }

    @Step("Проверка перехода из личного кабинета пользователя на главную страницу по клику на логотип")
    public void openMainPage() {
        driver.findElement(logoButton).click();
    }

    public void logout() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textDescription));
        driver.findElement(exitButton).click();
    }
}
