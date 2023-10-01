package org.example.Shop;

import java.util.Arrays;
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

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        Product[] productsArr = new Product[getProducts().size()];
        getProducts().toArray(productsArr);
        sortArr(productsArr);
        return Arrays.stream(productsArr).toList();
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        return sortProductsByPrice().get(products.size() - 1);
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

}