package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import praktikum.page.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BeforeAfterForTest {

    private MainPage mainPage;

    @Before
    public void initWebDriver() {
        mainPage = new MainPage(webDriver);
        mainPage.checkLoadPage();

    }

    @Test
    @DisplayName("Переход в раздел «Соусы»")
    @Description("Проверка перехода в раздел «Соусы» на главной странице")
    public void saucesTest() {
        assertTrue(mainPage.checkSauceButton());
    }

    @Test
    @DisplayName("Переход в раздел «Начинки»")
    @Description("Проверка перехода в раздел «Начинки» на главной странице")
    public void fillingsTest() {
        assertTrue(mainPage.checkFillingButton());
    }

    @Test
    @DisplayName("Переход в раздел «Булки»")
    @Description("Проверка перехода в раздел «Булки» на главной странице")
    public void bunTest() {
        assertTrue(mainPage.checkBunButton());
    }
}
