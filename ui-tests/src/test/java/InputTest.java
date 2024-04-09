import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.DataGenerator;

public class InputTest extends BasicTest {
    @Epic("UI тесты")
    @Feature("Inputs тесты")
    @DisplayName("Позитивный сценарий Inputs")
    @Test
    void inputsPositive() {
        mainPage.inputsButtonClick();
        int number = DataGenerator.generateInputTestData(10000).getFirst();
        inputsPage.inputNumber(number)
                .check()
                .inputValueEqualsTo(number);
    }
}
