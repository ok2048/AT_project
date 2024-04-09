package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.value;

public class InputsAssert extends AbstractAssert<InputsAssert, InputsPage> {
    private InputsAssert(InputsPage actual) {
        super(actual, AbstractAssert.class);
    }

    public static InputsAssert assertThat(InputsPage actual) {
        return new InputsAssert(actual);
    }

    public InputsPage page() {
        return actual;
    }

    @Step("Проверить, что значение input равно {number}")
    public InputsAssert inputValueEqualsTo(int number) {
        actual.input.should(value("" + number));
        return this;
    }
}
