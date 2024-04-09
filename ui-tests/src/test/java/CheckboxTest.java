import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckboxTest extends BasicTest {
    @Epic("UI тесты")
    @Feature("Checkboxes тесты")
    @DisplayName("Позитивный сценарий Checkboxes")
    @Test
    void checkboxPositive() {
        mainPage.checkboxButtonClick();
        checkboxesPage.checkboxClick(1)
                .checkboxClick(2)
                .check()
                .isChecked(1)
                .isNotChecked(2);

    }

}
