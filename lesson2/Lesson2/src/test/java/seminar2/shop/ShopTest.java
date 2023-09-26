package seminar2.shop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для класса Shop.
 */
public class ShopTest {
    private Shop shop;

    @BeforeEach
    public void setUp() {
        shop = new Shop();
    }

    /**
     * Тест на добавление продукта в магазин.
     */
    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Test Product", 10.0, 5);
        shop.addProduct(product);

        // Проверка количества продуктов в магазине
        assertEquals(1, shop.getProducts().size());
    }

    // Другие тесты для класса Shop
}