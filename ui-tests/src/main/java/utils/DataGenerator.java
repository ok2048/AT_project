package utils;

import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@UtilityClass
public class DataGenerator {
    @Step("Сгенерировать случайное число для ввода")
    public static List<Integer> generateInputTestData(int size) {
        List<Integer> result = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(10000) + 1;
            result.add(randomNumber);
        }
        return result;
    }

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Step("Сгенерировать последовательность клавиш для нажатия")
    public static List<Object> generateKeyPressedTestData(int size) {
        List<Object> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(LETTERS.length());
            result.add(LETTERS.substring(randomNumber, randomNumber + 1));
        }
        result.add(Keys.ENTER);
        result.add(Keys.CONTROL);
        result.add(Keys.ALT);
        result.add(Keys.TAB);
        return result;
    }
}

