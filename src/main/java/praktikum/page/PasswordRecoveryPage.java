package praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By titlePasswordRecovery = By.xpath(".//h2[text() = 'Восстановление пароля']");
    private final By linkToLoginPage = By.className("Auth_link__1fOlj");

    @Step("Переход настраэнцу Входа")
    public void openLoginPage() {
        driver.findElement(linkToLoginPage).click();
    }
}
