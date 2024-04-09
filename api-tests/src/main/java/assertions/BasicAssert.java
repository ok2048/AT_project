package assertions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BasicAssert extends AbstractAssert<BasicAssert, Response> {

    public BasicAssert(Response actual) {
        super(actual, BasicAssert.class);
    }

    public static BasicAssert assertThat(Response actual) {
        return new BasicAssert(actual);
    }

    @Step("Проверить, что статус код равен {expectedStatusCode}")
    public BasicAssert statusCodeIsEqual(int expectedStatusCode) {
        Assertions.assertThat(actual.getStatusCode())
                .as("Статус код должен быть равен %d", expectedStatusCode)
                .isEqualTo(expectedStatusCode);
        return this;
    }

    public BasicAssert responseContainsField(String path) {
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Респонс должен содержать поле %s", path)
                .isNotNull();
        return this;
    }

    public BasicAssert responseFieldIsEqual(String path, String value) {
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Поле %s должно равняться %s", path, value)
                .isEqualTo(value);
        return this;
    }

    public BasicAssert responseFieldIsEqual(String path, int value) {
        Assertions.assertThat(actual.jsonPath().getInt(path))
                .as("Поле %s должно равняться %d", path, value)
                .isEqualTo(value);
        return this;
    }

    public BasicAssert responseFieldIsEqual(String path, float value) {
        Assertions.assertThat(actual.jsonPath().getFloat(path))
                .as("Поле %s должно равняться %f", path, value)
                .isEqualTo(value);
        return this;
    }

    public BasicAssert responseIsEmpty(String path) {
        Assertions.assertThat(actual.body().<String>path(path)).isNull();
        return this;
    }
}
