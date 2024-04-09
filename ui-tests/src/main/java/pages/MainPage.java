package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public final SelenideElement checkboxButton = $x("//a[@href='/checkboxes']");
    public final SelenideElement dropdownButton = $x("//a[@href='/dropdown']");
    public final SelenideElement disappearingElementsButton =
            $x("//a[@href='/disappearing_elements']");
    public final SelenideElement inputsButton = $x("//a[@href='/inputs']");

    public MainPageAssert check() {
        return MainPageAssert.assertThat(this);
    }

    @Step("Нажать на кнопку Checkboxes")
    public MainPage checkboxButtonClick() {
        checkboxButton.should(visible).click();
        return this;
    }

    @Step("Нажать на кнопку Dropdown")
    public MainPage dropdownButtonClick() {
        dropdownButton.should(visible).click();
        return this;
    }

    @Step("Нажать на кнопку Disappearing Elements")
    public MainPage diappearingElementsButtonClick() {
        disappearingElementsButton.should(visible).click();
        return this;
    }

    @Step("Нажать на кнопку Inputs")
    public MainPage inputsButtonClick() {
        inputsButton.should(visible).click();
        return this;
    }

}
