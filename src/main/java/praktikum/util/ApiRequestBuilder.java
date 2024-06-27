package praktikum.util;

import com.github.javafaker.Faker;
import praktikum.model.User;

public class ApiRequestBuilder {

    private static final Faker faker = new Faker();

    public static final String USER_NAME = faker.funnyName().name();
    public static final String USER_EMAIL = faker.bothify("???????##@gm??l.com");
    public static final String PASSWORD = faker.bothify("?#?#???#???#??#");
    public static final String INCORRECT_PASSWORD = faker.bothify("?#?#");

    public static User getUser() {
//        USER_NAME = faker.funnyName().name();
//        USER_EMAIL = faker.bothify("???????##@gm??l.com");
//        PASSWORD = faker.bothify("?#?#???#???#??#");
        return User.builder()
                .email(USER_EMAIL)
                .password(PASSWORD)
                .name(USER_NAME)
                .build();
    }
}
