package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.model.response.UserResponse;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.ProfilePage;
import praktikum.page.RegisterPage;

import static org.junit.Assert.assertTrue;
import static praktikum.util.ApiRequestBuilder.getUser;

public class PersonalAccountTest extends BeforeAfterForTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ProfilePage profilePage;

    @Before
    public void initWebDriver() {
        userResponse = userSteps
                .create(getUser())
                .statusCode(200)
                .extract()
                .as(UserResponse.class);
        registerPage = new RegisterPage(webDriver);
        profilePage = new ProfilePage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        mainPage.checkLoadPage();
        mainPage.openLoginButton();
        loginPage.login();

    }

    @Test
    @DisplayName("Переход по клику на кнопку «Личный кабинет»")
    @Description("Проверка перехода в личный кабинет с главной страници после успешной регистрации")
    public void transferPersonalAccountTest() {
        mainPage.openProfileButton();
        assertTrue(profilePage.checkPageDescription());
    }

    @Test
    @DisplayName("Переход в «Конструктор»")
    @Description("Проверка перехода в «Конструктор» из личного кабинета")
    public void switchingConstructorTest() {
        mainPage.openProfileButton();
        profilePage.openConstructor();
        assertTrue(mainPage.checkLoadPage());
    }

    @Test
    @DisplayName("Переход при нажатии на логотип Stellar Burgers")
    @Description("Проверка перехода на главную страицу из личного кабинета нажатием на логотип Stellar Burgers")
    public void GoMainPageTest() {
        mainPage.openProfileButton();
        profilePage.openMainPage();
        assertTrue(mainPage.checkLoadPage());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода из аккаунта при нажатии кнопки «Выйти» в личном кабинете")
    public void logOutAccountTest() {
        mainPage.openProfileButton();
        profilePage.logout();
        assertTrue(loginPage.checkHeaderEntry());
    }

    @After
    public void destroy() {
        userResponse = userSteps
                .login(getUser())
                .statusCode(200)
                .extract()
                .as(UserResponse.class);
        super.destroy();
    }
}
