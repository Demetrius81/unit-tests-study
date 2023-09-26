package seminar1;

import org.assertj.core.api.Assertions; // Импортируем необходимые классы из библиотек
import org.junit.jupiter.api.Test;

public class Main {
    // Создаем класс MyTest, в котором будут размещены тесты
    // Аннотация @Test указывает, что метод testAssertions() является тестовым методом
    @Test
    public void testAssertions() {
        // Примеры использования AssertJ для проверки утверждений

        // Создаем строку для тестирования
        String text = "Hello, World";

        // Проверяем, что строка не равна null
        Assertions.assertThat(text).isNotNull();

        // Проверяем, что строка начинается с "Hello"
        Assertions.assertThat(text).startsWith("Hello");

        // Проверяем, что строка заканчивается на "World"
        Assertions.assertThat(text).endsWith("World");

        // Проверяем, что строка содержит подстроку "lo, W"
        Assertions.assertThat(text).contains("lo, W");
    }
}

