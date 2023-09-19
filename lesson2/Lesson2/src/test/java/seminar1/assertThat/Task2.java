package seminar1.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Проверка на наличие элемента
        assertThat(numbers).contains(2);

        // Проверка на отсутствие элемента
        assertThat(numbers).doesNotContain(4);

        // Проверка размера коллекции
        assertThat(numbers).hasSize(3);

        // Проверка на пустоту коллекции
        assertThat(numbers).isNotEmpty();
    }
}
