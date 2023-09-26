package seminar1.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1 {
    public static void main(String[] args) {
        String text = "Hello, World";

        // Проверка на равенство строки
        assertThat(text).isEqualTo("Hello, World");

        // Проверка на наличие подстроки
        assertThat(text).contains("Hello");

        // Проверка на длину строки
        assertThat(text).hasSize(12);

        // Проверка на null
        assertThat(text).isNotNull();
    }
}
