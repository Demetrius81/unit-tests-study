package org.example.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> _products;
    private static Shop _instance;

    private Shop() {
        _products = new ArrayList<>();
    }
    // Делаю синглтон для имитации работы БД. Данный класс должен быть репозиторием для работы с БД,
    // и список продуктов в магазине должен храниться в БД.
    public static Shop getInstance() {
        return _instance == null ? new Shop() : _instance;
    }

    public void addProduct(Product product) {
        Product currentProduct = findProductById(product.getId());
        if (currentProduct != null) {
            currentProduct.setQuantity(product.getQuantity() + currentProduct.getQuantity());
        } else {
            _products.add(product.clone());
        }
    }

    public boolean removeProduct(Product product) {
        if (findProductById(product.getId()) != null) {
            _products.remove(product);
            return true;
        }
        return false;
    }

    public List<Product> getProducts() {
        return _products;
    }

    public List<Product> getAvailableProducts() {
        return _products.stream().filter(x -> x.getQuantity() > 0).toList();
    }

    public Product findProductById(int id) {
        return _products.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void decreaseProductQuantity(Product product, int quantity) {
        Product shopProduct = findProductById(product.getId());
        if (shopProduct != null && shopProduct.getQuantity() >= quantity) {
            shopProduct.setQuantity(shopProduct.getQuantity() - quantity);
        } else if (shopProduct == null) {
            throw new NullPointerException("Указанного товара не найдено");
        } else {
            throw new IllegalArgumentException("Недостаточное количество товара в магазине");
        }
    }

    public void increaseProductQuantity(Product product, int quantity) {
        Product shopProduct = findProductById(product.getId());
        if (shopProduct != null) {
            shopProduct.setQuantity(shopProduct.getQuantity() + quantity);
        } else if (shopProduct == null) {
            throw new NullPointerException("Указанного товара не найдено");
        }
    }
}