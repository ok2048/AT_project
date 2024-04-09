package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.refresh;

public class DisappearingElementsPage {
    public final ElementsCollection elements = $$x("//li");

    public DisappearingElementsAssert check() {
        return DisappearingElementsAssert.assertThat(this);
    }

    @Step("Обновить страницу")
    public DisappearingElementsPage disappearingElementsPageRefresh() {
        refresh();
        return this;
    }
}
