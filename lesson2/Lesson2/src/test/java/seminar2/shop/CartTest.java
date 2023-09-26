package seminar2.shop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для класса Cart.
 */
public class CartTest {
    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
    }

    /**
     * Тест на добавление продукта в корзину.
     */
    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Test Product", 10.0, 5);
        cart.addProduct(product);

        // Проверка количества продуктов в корзине
        assertEquals(1, cart.getItems().size());
    }

    /**
     * Тест на удаление продукта из корзины.
     */
    @Test
    public void testRemoveProduct() {
        Product product = new Product(1, "Test Product", 10.0, 5);
        cart.addProduct(product);
        cart.removeProduct(product);

        // Проверка количества продуктов в корзине после удаления
        assertEquals(0, cart.getItems().size());
    }

    // Другие тесты для класса Cart
}
