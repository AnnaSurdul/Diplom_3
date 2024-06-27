package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.model.response.UserResponse;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.PasswordRecoveryPage;
import praktikum.page.RegisterPage;

import static org.junit.Assert.assertTrue;
import static praktikum.util.ApiRequestBuilder.getUser;

public class LoginTest extends BeforeAfterForTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private PasswordRecoveryPage recoveryPage;

    @Before
    public void initWebDriver() {
        userResponse = userSteps
                .create(getUser())
                .statusCode(200)
                .extract()
                .as(UserResponse.class);
        registerPage = new RegisterPage(webDriver);
        recoveryPage = new PasswordRecoveryPage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        mainPage.checkLoadPage();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт»")
    @Description("Проверка логина пользователя через кнопку «Войти в аккаунт» на главной")
    public void loginUserWithEnterToAccountButtonTest() {
        mainPage.openLoginButton();
        loginPage.login();
        mainPage.checkLoadPage();
        assertTrue(mainPage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Вход по кнопке «Личный кабинет»")
    @Description("Проверка логина пользователя через кнопку «Личный кабинет» на главной")
    public void loginUserWithPersonalAccountButtonTest() {
        mainPage.openProfileButton();
        loginPage.login();
        mainPage.checkLoadPage();
        assertTrue(mainPage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Вход по кнопке в форме регистрации")
    @Description("Проверка логина пользователя через кнопку «Войти» в форме регистрации")
    public void loginUserFromRegistrationPageTest() {
        mainPage.openLoginButton();
        loginPage.openRegistrationPage();
        registerPage.openLoginPagePage();
        loginPage.login();
        mainPage.checkLoadPage();
        assertTrue(mainPage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Вход по кнопке в форме восстановления пароля")
    @Description("Проверка логина пользователя через кнопку «Войти» в форме восстановления пароля")
    public void loginUserFromForgotPasswordPageTest() {
        mainPage.openLoginButton();
        loginPage.openRecoverPasswordPage();
        recoveryPage.openLoginPage();
        loginPage.login();
        mainPage.checkLoadPage();
        assertTrue(mainPage.checkButtonPlaceOrder());
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
