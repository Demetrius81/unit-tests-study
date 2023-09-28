package Shop;

import org.example.Shop.Product;
import org.example.Shop.Shop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    private static Shop _shop;
    private static int _count;
    private static Product[] _products;

    @BeforeAll
    static void loadParameters() {
        _shop = new Shop();
        Random rnd = new Random();
        _count = 100;
        _products = new Product[_count];

        for (int i = 1; i <= _count; i++) {
            String title = "product" + i;
            Product p = new Product();
            p.setTitle(title);
            p.setCost(1 + rnd.nextInt(100));
            _products[i - 1] = p;
        }

        _shop.setProducts(Arrays.stream(_products).toList());

    }

    @Test
    void getProducts_CorrectShop_IsCorrectStorageTest() {

        // Напишите тесты, чтобы проверить,
        // что магазин хранит не пустой список продуктов

        assertThat(_shop.getProducts())
                .describedAs("The product list should not be empty")
                .isNotEmpty();

        // что магазин хранит правильное количество продуктов
        assertThat(_shop.getProducts())
                .describedAs("The product list should size should be %d", _count)
                .hasSize(_count);

        // что магазин хранит верное содержимое корзины
        assertThat(_shop
                .getProducts()
                .get(_shop
                        .getProducts()
                        .size() - 1))
                .describedAs("The product list should be instance of Product class")
                .isInstanceOf(Product.class);
    }

    @Test
    void getMostExpensiveProduct_CorrectShop_IsCorrectStorageTest() {
        // Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.

        int max = 0;

        for (Product p :
                this._products) {
            if (max < p.getCost()) {
                max = p.getCost();
            }
        }
        assertThat(this._shop.getMostExpensiveProduct().getCost()).describedAs("This method must return product with highest price").isEqualTo(max);
    }

    @Test
    void sortProductsByPrice_CorrectShop_IsCorrectSortedStorageTest() {
        // Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).

        int[] costs = new int[this._count];

        for (int i = 0; i < this._products.length; i++) {
            costs[i] = this._products[i].getCost();
        }

        Arrays.sort(costs);

        int i = 0;

        for (Product p :
                this._shop.sortProductsByPrice()) {
            assertThat(p.getCost()).isEqualTo(costs[i]);
            i++;
        }
    }
}