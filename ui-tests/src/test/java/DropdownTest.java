import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DropdownTest extends BasicTest {
    @Epic("UI тесты")
    @Feature("Dropdown тесты")
    @DisplayName("Позитивный сценарий Dropdown")
    @Test
    void dropdownPositive() {
        mainPage.dropdownButtonClick();
        dropdownPage.dropdownClick()
                .check()
                .allOptionsAreVisible()
                .page()
                .option1Select()
                .check()
                .option1Selected()
                .page()
                .dropdownClick()
                .check()
                .allOptionsAreVisible()
                .page()
                .option2Select()
                .check()
                .option2Selected();
    }
}
