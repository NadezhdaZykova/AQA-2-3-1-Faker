package patterns;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate todayPlus = LocalDate.now();
        return todayPlus.plusDays(shift+3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.numerify("+7##########");
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.address().city();
    }

    public static class Registration {
        private Registration() {
        }

        public static User generateByCard(String locale) {
            return new User(
                    generateName(locale),
                    generatePhone(locale),
                    generateCity(locale)
            );
        }
    }

    @Data
    @RequiredArgsConstructor
    public static class User {
        private final String name;
        private final String phone;
        private final String city;
    }
}
