package org.example.shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> _items;

    public Shop get_shop() {
        return _shop;
    }

    private Shop _shop;

    public Cart(Shop shop) {
        _items = new ArrayList<>();
        // Для работы с корзиной сохраняем репозиторий магазина магазина
        _shop = shop;
    }

    public void addProductToCart(Product product) {
        addProduct(product, 1);

    }

    public void addProductToCart(Product product, int count) {
        addProduct(product, count);
    }

    private void addProduct(Product product, int count) {
        Product productInCart = _items.stream().filter(x -> x.getId() == product.getId()).findFirst().orElse(null);
        _shop.decreaseProductQuantity(product, count);
        if (productInCart == null) {
            _items.add(new Product(product.getId(), product.getName(), product.getPrice(), count));
        } else {
            productInCart.setQuantity(product.getQuantity() + count);
        }
    }

    public void removeProductFromCart(Product product) {
        removeProduct(product, 1);
    }

    public void removeProductFromCart(Product product, int count) {
        removeProduct(product, count);
    }

    private void removeProduct(Product product, int count) {
        Product productInCart = _items.stream().filter(x -> x.getId() == product.getId()).findFirst().orElse(null);
        _shop.increaseProductQuantity(product, count);
        if (productInCart == null) {
            throw new NullPointerException("Указанного товара не найдено");
        }

        if (productInCart.getQuantity() == count) {
            _items.remove(productInCart);
        } else if (productInCart.getQuantity() > count) {
            productInCart.setQuantity(productInCart.getQuantity() - count);
        } else {
            throw new IllegalArgumentException("Недостаточное количество товара в корзине");
        }
    }

    public List<Product> get_items() {
        return _items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product item : _items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public boolean containsProduct(Product product) {
        return _items.contains(product);
    }
}