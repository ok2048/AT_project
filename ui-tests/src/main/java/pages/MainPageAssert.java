package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.Condition.visible;

public class MainPageAssert extends AbstractAssert<MainPageAssert, MainPage> {


    private MainPageAssert(MainPage actual) {
        super(actual, AbstractAssert.class);
    }

    public static MainPageAssert assertThat(MainPage actual) {
        return new MainPageAssert(actual);
    }

    public MainPage page() {
        return actual;
    }

    @Step("Проверить, что кнопка Checkboxes отображается")
    public MainPageAssert checkboxesButtonIsVisible() {
        actual.checkboxButton.should(visible);
        return this;
    }

    @Step("Проверить, что кнопка Dropdown отображается")
    public MainPageAssert dropdownButtonIsVisible() {
        actual.dropdownButton.should(visible);
        return this;
    }

    @Step("Проверить, что кнопка Disappearing Elements отображается")
    public MainPageAssert disappearingElementsButtonIsVisible() {
        actual.disappearingElementsButton.should(visible);
        return this;
    }

    @Step("Проверить, что кнопка Inputs отображается")
    public MainPageAssert inputsButtonIsVisible() {
        actual.inputsButton.should(visible);
        return this;
    }

}
