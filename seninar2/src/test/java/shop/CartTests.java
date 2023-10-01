package shop;

import org.example.shop.Cart;
import org.example.shop.Product;
import org.example.shop.Shop;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CartTests {

    private Cart _cart;
    private Shop _shop;
    private Product _product1;
    private Product _product2;


    @BeforeEach
    public void setUp() {
        _shop = Shop.getInstance();
        _shop.getProducts().removeAll(new ArrayList<Product>());
        _cart = new Cart(_shop);
        _product1 = new Product(1, "Product1", 500, 2);
        _product2 = new Product(2, "Product2", 300, 1);


    }

    @Test
    void calculateTotal_CorrectProductList_CorrectTest() {
        // Arrange

        Random rnd = new Random();
        int count = 10;
        double expectedTotalPrice = 0;

        for (int i = 0; i < count; i++) {
            Product temp = new Product(i, "Product" + i, rnd.nextDouble(1000) + 1, rnd.nextInt(100) + 1);
            _shop.addProduct(temp);
            _cart.addProductToCart(temp);
            expectedTotalPrice += temp.getPrice();
        }

        // Act

        double actualTotalPrice = _cart.calculateTotal();

        // Assert

        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

    @Test
    public void testCalculateTotalWithMultipleProducts() {
// Создаем несколько продуктов
        Product product1 = new Product(1, "Товар 1", 500.0, 1);
        Product product2 = new Product(2, "Товар 2", 300.0, 1);
        Product product3 = new Product(3, "Товар 3", 200.0, 1);

        _shop.addProduct(product1);
        _shop.addProduct(product2);
        _shop.addProduct(product3);

// Добавляем продукты в корзину
        _cart.addProductToCart(product1);
        _cart.addProductToCart(product2);
        _cart.addProductToCart(product3);

// Проверяем, что общая стоимость корзины рассчитывается корректно
        double expectedTotalPrice = 1000.0; // 500 + 300 + 200
        double actualTotalPrice = _cart.calculateTotal();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01); // Погрешность 0.01 для сравнения с плавающей точкой
    }

    @Test
    public void testCalculateTotalWithEmptyCart() {
// Проверяем, что общая стоимость пустой корзины равна 0.0
        double expectedTotalPrice = 0.0;
        double actualTotalPrice = _cart.calculateTotal();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

    @Test
    public void testCalculateTotalWithSingleProduct() {
// Создаем один продукт
        Product product = new Product(1, "Товар 1", 500.0, 1);
        _shop.addProduct(product);
// Добавляем продукт в корзину
        _cart.addProductToCart(product);

// Проверяем, что общая стоимость корзины с одним товаром равна цене этого товара
        double expectedTotalPrice = 500.0;
        double actualTotalPrice = _cart.calculateTotal();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

    @Test
    public void testCalculateTotalWithManyProduct() {
        // Arrange

        int count = 10000;
        double expectedTotalPrice = 0;

        for (int i = 0; i < count; i++) {
            Product temp = new Product(i, "Product" + i, 1000, 1);
            _shop.addProduct(temp);
            _cart.addProductToCart(temp);
            expectedTotalPrice += temp.getPrice() * temp.getQuantity();

        }

        // Act

        double actualTotalPrice = _cart.calculateTotal();

        // Assert

        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }

    /*
    Задание №3
Напишите модульный тест для проверки, что при удалении товара из
корзины происходит перерасчет общей стоимости корзины.
💡 Ожидаемый результат: Вызывается метод пересчета стоимости
корзины, стоимость корзины меняется
*/

    @Test
    void testRecalculateTotalAfterRemovingProduct() {
        // Arrange
        _shop.addProduct(_product1);
        _shop.addProduct(_product2);

        _cart.addProductToCart(_product1);
        _cart.addProductToCart(_product2);

        // Act

        double initialTotalPrice = _cart.calculateTotal();
        _cart.removeProductFromCart(_product1);
        double updateTotalPrice = _cart.calculateTotal();

        // Assert

        assertNotEquals(initialTotalPrice, updateTotalPrice, 0.01);
    }


//  Разработайте модульный тест для проверки, что при добавлении определенного количества
//  товара в корзину, общее количество этого товара в магазине соответствующим образом
//  уменьшается.
//  💡 Ожидаемый результат: Количество товара в магазине
//  уменьшается на число продуктов в корзине пользователя


    @Test
    void testProductRemoveFromShopWhenAddedToCart() {
        _shop.addProduct(_product1);
        _cart.addProductToCart(_product1);

        int expectedQuantityInShop = 1;
        int actualQuantityInShop = _shop.findProductById(_product1.getId()).getQuantity();
        assertEquals(expectedQuantityInShop, actualQuantityInShop);
    }

//    Задание №5
//    Создайте модульный тест для проверки, что если пользователь забирает все имеющиеся
//    продукты определенного типа из магазина, эти продукты больше не доступны для заказа.
//    💡 Ожидаемый результат: Больше такой продукт
//    заказать нельзя, он не появляется на полке

    @Test
    void testProductNotAvailableWhenRemoveAllItemsOfCurrentProductFromShopToCart() {
        Product product1 = new Product(1, "Товар 1", 500.0, 3);
        Product product2 = new Product(2, "Товар 2", 300.0, 1);
        Product product3 = new Product(3, "Товар 3", 200.0, 1);


        _shop.addProduct(product1);
        _shop.addProduct(product2);
        _shop.addProduct(product3);

        _cart.addProductToCart(product1, 3);

        int expectedQuantityInShop = 0;

        int actualQuantityInShop = _shop.findProductById(product1.getId()).getQuantity();

        assertEquals(expectedQuantityInShop, actualQuantityInShop);
    }

//    Разработайте параметризованный модульный тест для проверки, что при вводе неверного
//    идентификатора товара генерируется исключение RuntimeException.
    @Test
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void testAnRuntimeExceptionIsGeneratedIfAddANonExistentProductInCart(int argument) {
        Product product1 = new Product(1, "Товар 1", 500.0, 3);
        Product product2 = new Product(2, "Товар 2", 300.0, 1);
        Product product3 = new Product(3, "Товар 3", 200.0, 1);

        _shop.addProduct(product1);
        _shop.addProduct(product2);
        _shop.addProduct(product3);

        Exception ex = assertThrows(RuntimeException.class, () -> _cart.addProductToCart(new Product(argument, "test", 200, 4), 3));

        assertEquals("Указанного товара не найдено", ex.getMessage());
    }

//    Создайте модульный тест для проверки, что при попытке удалить из корзины больше
//    товаров, чем там есть, генерируется исключение RuntimeException.


    @Test
    void testAnRuntimeExceptionIsGeneratedIfRemoveANonExistentProductFromCart() {
        Product product1 = new Product(1, "Товар 1", 500.0, 3);
        Product product2 = new Product(2, "Товар 2", 300.0, 1);
        Product product3 = new Product(3, "Товар 3", 200.0, 1);

        _shop.addProduct(product1);
        _shop.addProduct(product2);
        _shop.addProduct(product3);


        Exception ex = assertThrows(RuntimeException.class, () -> _cart.removeProductFromCart(product2, 2));

        assertEquals("Указанного товара не найдено", ex.getMessage());
    }

    // boolean Сломанный-Тест() {
    // // Assert (Проверка утверждения)
    //
    // assertThat(cart.getTotalPrice()).isEqualTo(cart.getTotalPrice());
    // // Act (Выполнение)
    // cart.addProductToCartByID(2); // 250
    // cart.addProductToCartByID(2); // 250
    // // Arrange (Подготовка)
    // Shop shop = new Shop(getStoreItems());
    // Cart cart = new Cart(shop);
    // }

    @Test
    void testFixed() {
        // Arrange (Подготовка)

        Shop shop = Shop.getInstance();
        Cart cart = new Cart(shop);
        Product product1 = new Product(1, "Товар 1", 250, 1);
        Product product2 = new Product(2, "Товар 2", 250, 1);
        shop.addProduct(product1);
        shop.addProduct(product2);

        // Act (Выполнение)

        cart.addProductToCart(product1); // 250
        cart.addProductToCart(product2); // 250

        // Assert (Проверка утверждения)

        assertThat(cart.calculateTotal()).isEqualTo(500);
    }

//    Задание №10
//    Нужно оптимизировать тестовый метод, согласно следующим условиям:
//      1. Отображаемое имя - "Advanced test for calculating TotalPrice"
//      2. Тест должен повторяться 10 раз
//      3. Установлен таймаут на выполнение теста 70 Миллисекунд (unit = TimeUnit.MILLISECONDS)
//      4. После проверки работоспособности теста, его нужно выключить

    @RepeatedTest(value = 10, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("Advanced test for calculating TotalPrice")
    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
    void advancedTestForCalculatingTotalPrice() {
        // Arrange

        Random rnd = new Random();
        int count = 10;
        double expectedTotalPrice = 0;

        for (int i = 0; i < count; i++) {
            Product temp = new Product(i, "Product" + i, rnd.nextDouble(1000) + 1, rnd.nextInt(100) + 1);
            _shop.addProduct(temp);
            _cart.addProductToCart(temp);
            expectedTotalPrice += temp.getPrice();
        }

        // Act

        double actualTotalPrice = _cart.calculateTotal();

        // Assert

        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }
}

