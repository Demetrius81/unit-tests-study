package org.example.shop;

import java.util.List;
import java.util.Scanner;

public class TextUserInterface {
    private Cart _cart;
    private Scanner _scanner;

    public TextUserInterface(Cart cart) {
        this._cart = cart;
        this._scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("1. Просмотреть продукты");
            System.out.println("2. Добавить продукт в корзину");
            System.out.println("3. Удалить продукт из корзины");
            System.out.println("4. Посмотреть корзину");
            System.out.println("5. Рассчитать общую стоимость корзины");
            System.out.println("0. Выйти");

            System.out.print("Выберите действие: ");
            choice = _scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    removeProductFromCart();
                    break;
                case 4:
                    displayCart();
                    break;
                case 5:
                    calculateTotal();
                    break;
                case 0:
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        } while (choice != 0);
    }

    public void displayProducts() {
        System.out.println("Список продуктов в магазине:");
        List<Product> products = _cart.get_shop().getAvailableProducts();
        displayList(products);
    }

    private void displayList(List<Product> products){
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void addProductToCart() {
// Логика добавления продукта в корзину
        System.out.println("Введите ID продукта >");
        int id = _scanner.nextInt();
        System.out.println("Введите количество товара для добавления в корзину >");
        int count = _scanner.nextInt();
        Product productToCart = _cart.get_shop().findProductById(id);
        _cart.addProductToCart(productToCart, count);
    }

    public void removeProductFromCart() {
// Логика удаления продукта из корзины
        System.out.println("Введите ID продукта >");
        int id = _scanner.nextInt();
        System.out.println("Введите количество товара для удаления из корзины >");
        int count = _scanner.nextInt();
        Product productToCart = _cart.get_shop().findProductById(id);
        _cart.removeProductFromCart(productToCart, count);
    }

    public void displayCart() {
// Отображение содержимого корзины
        System.out.println("Список продуктов в корзине:");
        List<Product> products = _cart.get_items();
        displayList(products);
        calculateTotal();
    }

    public void calculateTotal() {
        double total = _cart.calculateTotal();
        System.out.println("Общая стоимость корзины: " + total + " руб.");
    }

    public static void main(String[] args) {
// Создание экземпляров магазина и корзины
        Shop shop = Shop.getInstance();
        Cart cart = new Cart(shop);

// Создание интерфейса и запуск меню
        TextUserInterface ui = new TextUserInterface(cart);
        ui.displayMenu();
    }
}