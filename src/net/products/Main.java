package net.products;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");

        try {
            ProductList.add(new Product("Помидор", 185.8, 5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        ProductList.add(new Product("Сыр", 600, 15));
        ProductList.add(new Product("Молоко", 200.5, 20));
        ProductList.add(new Product("Апельсин", 40.6, 21));
        ProductList.add(new Product("Картофель", 470, 4442));
        ProductList.add(new Product("Папайя", 520.8, 44));
        ProductList.add(new Product("Манго", 615.3, 78));
        try {
            ProductList.add(new Product("Манго", 615.3, 78));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ProductList.getProductList());
    }
}
