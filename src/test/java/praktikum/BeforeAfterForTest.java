package praktikum;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import praktikum.config.WebDriverFactory;
import praktikum.model.response.UserResponse;
import praktikum.step.UserSteps;

import static java.util.Objects.nonNull;
import static praktikum.config.ApiConfiguration.HOST;
import static praktikum.model.response.UserResponse.clear;
import static praktikum.util.ApiRequestBuilder.*;

public class BeforeAfterForTest {

    WebDriver webDriver;
    UserSteps userSteps = new UserSteps();
    UserResponse userResponse;

    @Before
    public void init() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(HOST)
                .build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        webDriver = WebDriverFactory.getWebDriver(System.getProperty("browser", "chrome"));
        webDriver.get(HOST);
    }

    @After
    public void destroy() {
        if (nonNull(userResponse)) {
            userSteps.delete(userResponse.getAccessToken());
            userResponse = clear();
        }
        webDriver.quit();
    }
}