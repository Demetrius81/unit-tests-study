package seminar1.assertThat;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3 {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25);
        Person person2 = new Person("Bob", 30);

        // Проверка на равенство объектов с учетом полей
        assertThat(person1).isEqualToComparingFieldByField(person2);

        // Проверка на равенство объектов с учетом выбранных полей
        assertThat(person1).isEqualToComparingOnlyGivenFields(person2, "name");
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}