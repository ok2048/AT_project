package pages;

import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;

import static com.codeborne.selenide.CollectionCondition.size;

public class DisappearingElementsAssert extends AbstractAssert<DisappearingElementsAssert, DisappearingElementsPage> {
    private DisappearingElementsAssert(DisappearingElementsPage actual) {
        super(actual, AbstractAssert.class);
    }

    public static DisappearingElementsAssert assertThat(DisappearingElementsPage actual) {
        return new DisappearingElementsAssert(actual);
    }

    public DisappearingElementsPage page() {
        return actual;
    }

    @Step("Проверить, что на странице 5 элементов")
    public DisappearingElementsAssert numberOfElementsIsFive() {
        actual.elements.should(size(5));
        return this;

    }
}
