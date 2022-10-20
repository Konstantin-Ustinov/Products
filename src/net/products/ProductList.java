package net.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductList {
    private static Map<String, Product> productList = new HashMap<>();

    public static void add(String productName, Product product) {
        if (product != null && productName != null && !"".equals(productName)) {
            if (!productList.containsKey(productName)) {
                productList.put(productName, product);
                System.out.println(product.getName() + " - добавлен");
            } else {
                // Зачем в этом месте выбрасывать исключение, если можно просто вывести информацию в консоль?
                throw new IllegalArgumentException(product.getName() +  " - уже есть в списке!");
            }
        } else {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
    }

    public static void remove(String productName) {
        if (productName != null && !"".equals(productName)) {
            if (productList.remove(productName) != null) {
                System.out.println("Удаление продукта: " + productName + " прошло успешно.");
            } else {
                System.out.println("Такого продукта не нашлось в этом списке");
            }
        } else {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
    }

    public static Product getProduct(String productName) {
        if (productName != null && !"".equals(productName)) {
            if (productList.containsKey(productName)) {
                return productList.get(productName);
            } else {
                throw new IllegalArgumentException(productName + " в списке нет");
            }
        } else {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
    }

    public static void setBay(String productName) {
        if (productName != null && !"".equals(productName)) {
            Product product = productList.getOrDefault(productName, null);
            if (product != null) {
                product.setBayed(true);
                System.out.println("Продукт: " + product.getName() + " помечен купленным.");
            }
        } else {
            throw new IllegalArgumentException("Продукт не может быть null");
        }
    }

    public static Map<String, Product> getProductList() {
        return productList;
    }
}
