package net.products;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");

        System.out.println("Добавляем продыкты в список");

        // add items to ProductList
        try {
            ProductList.add("Помидор", new Product("Помидор", 185.8, 5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        ProductList.add("Сыр", new Product("Сыр", 600, 15));
        ProductList.add("Молоко", new Product("Молоко", 200.5, 20));
        ProductList.add("Апельсин", new Product("Апельсин", 40.6, 21));
        ProductList.add("Картофель", new Product("Картофель", 470, 4442));
        ProductList.add("Папайя", new Product("Папайя", 520.8, 44));
        ProductList.add("Манго", new Product("Манго", 615.3, 78));
        try {
            ProductList.add("Манго", new Product("Манго", 615.3, 78));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ProductList.getProductList());

        System.out.println("Удаляем помидор");
        ProductList.remove("Помидор");
        System.out.println(ProductList.getProductList());

        System.out.println("Удаляем несуществующий Перец");
        ProductList.remove("Перец");

        // set item bayed status true
        System.out.println("Меняем статус Сыра и Апельсина на \"Куплено\"");
        ProductList.setBay("Сыр");
        ProductList.setBay("Апельсин");
        System.out.println(ProductList.getProductList());


    }
}
