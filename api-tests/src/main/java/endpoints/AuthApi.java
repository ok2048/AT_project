package endpoints;

import dto.Credentials;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.RestApiBuilder;

public class AuthApi {
    @Step("Зарегистрировать нового пользователя")
    public static Response registerNewUser(Credentials credentials) {
        return new RestApiBuilder(Urls.BASE_URI).build()
                .body(credentials)
                .post(Urls.REGISTER);
    }

    @Step("Войти в систему")
    public static Response loginUser(Credentials credentials) {
        return new RestApiBuilder(Urls.BASE_URI).build()
                .body(credentials)
                .post(Urls.LOGIN);
    }
}
