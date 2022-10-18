package net.products;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private static List<Product> productList = new ArrayList<>();

    public static void add(Product product) {
        if (product != null) {
            if (!productList.contains(product)) {
                productList.add(product);
                System.out.println(product.getName() + " - добавлен");
            } else {
                throw new IllegalArgumentException(product.getName() +  " - уже есть в списке!");
            }
        } else {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
    }

    public static void remove(Product product) {
        if (product != null) {
            if (productList.remove(product)) {
                System.out.println("Удаление продукта: " + product.getName() + " прошло успешно.");
            } else {
                System.out.println("Такого продукта не нашлось в этом списке");
            }
        } else {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
    }

    public static void checkBay(Product product) {
        if (product != null) {
            productList.get(productList.indexOf(product)).setBayed(true);
            System.out.println("Продукт: " + product.getName() + " помечен купленным.");
        } else {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
    }

    public static List<Product> getProductList() {
        return productList;
    }
}
