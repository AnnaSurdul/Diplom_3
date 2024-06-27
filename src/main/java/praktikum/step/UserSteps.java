package praktikum.step;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import praktikum.model.User;

import static io.restassured.RestAssured.given;
import static praktikum.config.ApiConfiguration.*;

public class UserSteps {

    public ValidatableResponse create(User user) {
        return given()
                .body(user)
                .when()
                .post(CREATE_USER)
                .then();
    }

    public ValidatableResponse login(User user) {
        return given()
                .body(user)
                .when()
                .post(LOGIN)
                .then();
    }

    public
    Response delete(String accessToken) {
        return given()
                .header(AUTHORIZATION, accessToken)
                .when()
                .delete(USER);
    }
}