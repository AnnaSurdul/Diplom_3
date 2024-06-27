package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.model.response.UserResponse;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.RegisterPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static praktikum.config.ApiConfiguration.SUCCESS;
import static praktikum.util.ApiRequestBuilder.*;

public class RegistrationTest extends BeforeAfterForTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private boolean afterFlag;

    @Before
    public void initPages() {
        registerPage = new RegisterPage(webDriver);
        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        mainPage.checkLoadPage();
    }

    @Test
    @DisplayName("Успешная регистация пользователя")
    @Description("Проверка регистации с корректным логином и паролем")
    public void successfulRegistrationTest() {
        afterFlag = true;
        mainPage.openProfileButton();
        loginPage.openRegistrationPage();
        registerPage.register(USER_NAME, USER_EMAIL, PASSWORD);
        userSteps
                .login(getUser())
                .statusCode(200)
                .body(SUCCESS, is(true));
    }

    @Test
    @DisplayName("Регистация пользователя с неверным паролем")
    @Description("Проверка ошибки при регистрации пользоавтеля с некорректным паролем")
    public void registrationWithAnIncorrectPasswordTest() {
        afterFlag = false;
        mainPage.openProfileButton();
        loginPage.openRegistrationPage();
        registerPage.register(USER_NAME, USER_EMAIL, INCORRECT_PASSWORD);
        boolean isIncorrectPassword = registerPage.checkMessageInvalidPassword();
        assertTrue(isIncorrectPassword);
    }

    @After
    public void destroy() {
        if (afterFlag) {
            userResponse = userSteps
                    .login(getUser())
                    .statusCode(200)
                    .extract()
                    .as(UserResponse.class);
        }
        super.destroy();
    }
}
