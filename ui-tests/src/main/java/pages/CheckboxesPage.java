package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;

public class CheckboxesPage {
    public final ElementsCollection checkboxes = $$x("//input[@type='checkbox']");

    public CheckboxesAssert check() {
        return CheckboxesAssert.assertThat(this);
    }

    @Step("Кликнуть на checkbox{index}")
    public CheckboxesPage checkboxClick(int index) {
        checkboxes.get(index - 1)
                .should(visible)
                .click();
        return this;
    }
}
