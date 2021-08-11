package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int count = index; count < products.length - 1; count++) {
            products[count] = products[count + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}