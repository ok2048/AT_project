package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.text;

public class DropdownAssert extends AbstractAssert<DropdownAssert, DropdownPage> {
    private DropdownAssert(DropdownPage actual) {
        super(actual, AbstractAssert.class);
    }

    public static DropdownAssert assertThat(DropdownPage actual) {
        return new DropdownAssert(actual);
    }

    public DropdownPage page() {
        return actual;
    }

    @Step("Проверить, что все опции отображаются")
    public DropdownAssert allOptionsAreVisible() {
        actual.options.should(allMatch(
                "Check that options are visible",
                WebElement::isDisplayed
        ));
        return this;
    }

    @Step("Проверить, что выбрана option1")
    public DropdownAssert option1Selected() {
        actual.dropdown.should(text("Option 1"));
        return this;
    }

    @Step("Проверить, что выбрана option2")
    public DropdownAssert option2Selected() {
        actual.dropdown.should(text("Option 2"));
        return this;
    }

}
