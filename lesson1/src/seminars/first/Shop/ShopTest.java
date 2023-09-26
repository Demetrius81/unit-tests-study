package seminars.first.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import seminars.first.Shop.Product;
import seminars.first.Shop.Shop;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    public static void main(String[] args) {
    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
        Shop shop = new Shop();
        Random rnd = new Random();
        int count = 100;
        Product[] products = new Product[count];

        for (int i = 1; i <= count; i++){
            String title = "product" + i;
            Product p = new Product();
            p.setTitle(title);
            p.setCost(1 + rnd.nextInt(100));
            products[i - 1] = p;
        }

        shop.setProducts(Arrays.stream(products).toList());

    // Напишите тесты, чтобы проверить,
    // что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).

        assertThat(shop.getProducts().isEmpty()).isEqualTo(false);
        assertThat(shop.getProducts().size()).isEqualTo(count);
        assertThat(shop.getProducts().get(shop.getProducts().size() - 1).getClass()).isEqualTo(new Product().getClass());

    // Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.

        int max = 0;

        for (Product p:
                products) {
            if (max < p.getCost()) {
                max = p.getCost();
            }
        }
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(max);

    // Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).

        int[] costs = new int[count];

        for (int i = 0; i < products.length; i++){
            costs[i] = products[i].getCost();
        }

        costs = Arrays.stream(costs).sorted().toArray();

        int i = 0;

        for (Product p:
                shop.sortProductsByPrice()) {
            assertThat(p.getCost()).isEqualTo(costs[i]);
            i++;
        }

    // Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов.

    }
}