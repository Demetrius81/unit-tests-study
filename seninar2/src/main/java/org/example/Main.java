package org.example;

import org.example.shop.*;

import java.util.List;

public class Main {
        public static void main(String[] args) {
// Создание экземпляров магазина и корзины
        Shop shop = Shop.getInstance();
        Cart cart = new Cart(shop);

// Создание интерфейса и запуск меню
        TextUserInterface ui = new TextUserInterface(cart);
        ui.displayMenu();
    }
//    public static void main(String[] args) {
//        Product product1 = new Product(1, "Товар 1", 500.0, 2);
//        Product product2 = new Product(2, "Товар 2", 300.0, 1);
//        Product product3 = new Product(3, "Товар 3", 200.0, 1);
//        Shop shop = Shop.getInstance();
//
//        shop.addProduct(product1);
//        shop.addProduct(product2);
//        shop.addProduct(product3);
//        shop.addProduct(product1);
//
//        shop.decreaseProductQuantity(product1, 3);
//
//        List<Product> products = shop.getAvailableProducts();
//        for (Product product : products) {
//            System.out.println(product.toString() + "|>" + product.getQuantity());
//        }
//    }
}
