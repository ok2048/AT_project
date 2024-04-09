package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class CheckboxesAssert extends AbstractAssert<CheckboxesAssert, CheckboxesPage> {

    private static final String CHECKED = "checked";

    private CheckboxesAssert(CheckboxesPage actual) {
        super(actual, AbstractAssert.class);
    }

    public static CheckboxesAssert assertThat(CheckboxesPage actual) {
        return new CheckboxesAssert(actual);
    }

    public CheckboxesPage page() {
        return actual;
    }

    @Step("Проверить, что checkbox{index} взведен")
    public CheckboxesAssert isChecked(int index) {
        Assertions.assertThat(actual.checkboxes.get(index - 1).getAttribute(CHECKED))
                .as("Check that element is checked")
                .isNotNull(); // Признаком взведенного checkbox'а является наличие взведенного атрибута checked
        return this;
    }

    @Step("Проверить, что checkbox{index} не взведен")
    public CheckboxesAssert isNotChecked(int index) {
        Assertions.assertThat(actual.checkboxes.get(index - 1).getAttribute(CHECKED))
                .as("Check that element is not checked")
                .isNull();
        return this;
    }

}