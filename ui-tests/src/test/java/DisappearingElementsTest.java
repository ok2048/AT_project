import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DisappearingElementsTest extends BasicTest {
    @Epic("UI тесты")
    @Feature("DisappearingElements тесты")
    @DisplayName("Позитивный сценарий DisappearingElements")
    @Test
    void disappearingElementsPositive() {
        mainPage.diappearingElementsButtonClick();
        disappearingElementsPage.disappearingElementsPageRefresh()
                .check()
                .numberOfElementsIsFive();
    }
}
