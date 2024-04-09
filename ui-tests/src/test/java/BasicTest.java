import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import utils.UiProps;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class BasicTest {

    UiProps props = ConfigFactory.create(UiProps.class);
    protected MainPage mainPage = new MainPage();
    protected CheckboxesPage checkboxesPage = new CheckboxesPage();
    protected DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();
    protected DropdownPage dropdownPage = new DropdownPage();
    protected InputsPage inputsPage = new InputsPage();

    @BeforeEach
    @Step("Открыть страницу https://the-internet.herokuapp.com/")
    void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true));
        open(props.baseUrl());
    }

    @AfterEach
    @Step("Закрыть браузер")
    void tearDown() {
        closeWindow();
    }

}
