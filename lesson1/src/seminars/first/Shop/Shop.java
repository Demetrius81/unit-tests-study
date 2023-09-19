package seminars.first.Shop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Мы хотим улучшить функциональность нашего интернет-магазина.
    // Ваша задача - добавить два новых метода в класс Shop:
    // Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        Product[] productsArr = new Product[getProducts().size()];
        getProducts().toArray(productsArr);
        sortArr(productsArr);
        return Arrays.stream(productsArr).toList();
    }

    private static void sortArr(Product[] sortArr) {
        int j;
        for (int i = 1; i < sortArr.length; i++) {
            Product swap = sortArr[i];
            for (j = i; j > 0 && swap.compareCost(sortArr[j - 1]) < 0; j--) {
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }


    // Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно

        return sortProductsByPrice().get(products.size() - 1);
    }
}