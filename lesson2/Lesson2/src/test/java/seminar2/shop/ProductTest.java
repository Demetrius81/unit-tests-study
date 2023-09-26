package seminar2.shop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для класса Product.
 */
public class ProductTest {

    /**
     * Тест на создание объекта Product.
     */
    @Test
    public void testProductCreation() {
        Product product = new Product(1, "Test Product", 10.0, 5);

        // Проверка атрибутов продукта
        assertEquals(1, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals(10.0, product.getPrice(), 0.001);
        assertEquals(5, product.getQuantity());

    }

    // Другие тесты для класса Product
}