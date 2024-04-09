package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class InputsPage {
    public final SelenideElement input = $x("//input[@type='number']");

    public InputsAssert check() {
        return InputsAssert.assertThat(this);
    }

    @Step("Ввести в input число {number}")
    public InputsPage inputNumber(int number) {
        input.should(visible).sendKeys("" + number);
        return this;
    }
}
