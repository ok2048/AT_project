package utils;

import dto.Credentials;
import dto.ProductDto;
import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import net.datafaker.Faker;
import org.instancio.Gen;
import org.instancio.Instancio;

import static org.instancio.Select.field;

@UtilityClass
public class GenerationUtil {

    @Step("Сгенерировать случайный товар")
    public static ProductDto generateProduct() {
        Faker faker = new Faker();
        return Instancio.of(ProductDto.class)
                .set(field(ProductDto::getName), faker.device().modelName())
                .set(field(ProductDto::getCategory), faker.industrySegments().sector())
                .set(field(ProductDto::getPrice), (float) faker.number().numberBetween(1, 1000))
                .set(field(ProductDto::getDiscount), (float) faker.number().numberBetween(0, 99))
                .create();
    }

    @Step("Сгенерировать случайный id")
    public static long generateId() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1000000, 9999999);
    }

    @Step("Сгенерировать случайный логин и пароль")
    public static Credentials generateCredentials() {
        String username = Gen.string().length(6).get();
        String password = Gen.string().length(8).get();
        return new Credentials(username, password);
    }

}
