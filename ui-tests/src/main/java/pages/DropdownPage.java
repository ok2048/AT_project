package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage {
    public final SelenideElement dropdown = $x("//select[@id='dropdown']");
    public final SelenideElement option1 = $x("//option[@value='1']");
    public final SelenideElement option2 = $x("//option[@value='2']");
    public final ElementsCollection options = $$x("//option");

    public DropdownAssert check() {
        return DropdownAssert.assertThat(this);
    }

    @Step("Нажать на dropdown")
    public DropdownPage dropdownClick() {
        dropdown.should(visible).click();
        return this;
    }

    @Step("Выбрать option1")
    public DropdownPage option1Select() {
        option1.should(visible).click();
        return this;
    }

    @Step("Выбрать option2")
    public DropdownPage option2Select() {
        option2.should(visible).click();
        return this;
    }
}
