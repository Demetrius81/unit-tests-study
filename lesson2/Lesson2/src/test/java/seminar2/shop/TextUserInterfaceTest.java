package seminar2.shop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для класса TextUserInterface.
 */
public class TextUserInterfaceTest {
    private Shop shop;
    private Cart cart;
    private TextUserInterface ui;

    @BeforeEach
    public void setUp() {
        shop = new Shop();
        cart = new Cart();
        ui = new TextUserInterface(shop, cart);
    }

    /**
     * Тест отображения меню и взаимодействия пользователя.
     */
    @Test
    public void testDisplayMenu() {
        // Тестирование метода displayMenu() взаимодействия с пользователем
        // и проверка его реакции на выбор пользователя
    }

    // Другие тесты для класса TextUserInterface
}
