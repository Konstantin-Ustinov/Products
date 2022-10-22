package net.products;

import net.products.collectionsTasks.Passport;
import net.products.collectionsTasks.Tasks;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");

        System.out.println("Добавляем продыкты в список");

        // add items to ProductList
        try {
            ProductList.add("Помидор", new Product("Помидор", 185.8, 5));
            ProductList.add("Сыр", new Product("Сыр", 600, 15));
            ProductList.add("Молоко", new Product("Молоко", 200.5, 20));
            ProductList.add("Апельсин", new Product("Апельсин", 40.6, 21));
            ProductList.add("Картофель", new Product("Картофель", 470, 4442));
            ProductList.add("Папайя", new Product("Папайя", 520.8, 44));
            ProductList.add("Манго", new Product("Манго", 615.3, 78));
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

        System.out.println("Выводим только купленные продукты");
        ProductList.getProductList().forEach((s, product) -> {
            if (product.isBayed()) {
            System.out.println(product.getName() + " куплен");} });

        System.out.println("Task 2");
        System.out.println("Создаем список рецептов");

        Set<Recipe> recipes = new HashSet<>();
        try {
            Recipe potato = new Recipe("Картофель в мундире",
                    new Product[]{ProductList.getProduct("Картофель"),
                            ProductList.getProduct("Молоко"),
                            ProductList.getProduct("Сыр")});
            Recipe sweet = new Recipe("Сладкое",
                    new Product[]{ProductList.getProduct("Апельсин"),
                            ProductList.getProduct("Манго"),
                            ProductList.getProduct("Папайя")});
            Recipe fruits = new Recipe("Фрукты",
                    new Product[]{ProductList.getProduct("Апельсин"),
                            ProductList.getProduct("Манго"),
                            ProductList.getProduct("Папайя")});

           addToRecipes(recipes, potato);
           addToRecipes(recipes, sweet);
           addToRecipes(recipes, potato);
           addToRecipes(recipes, fruits);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Выводим все рецепты:");
        System.out.println(recipes);

        System.out.println("Задания про числа в множестве");
        removeOddNumbersFromSet();

        System.out.println("Задания на коллекции");
        Tasks.task3_2();

        System.out.println("Задание с паспортом");

        var petrov = new Passport(151515, "Петров", "Иван", "Максимович", "1998-05-05");
        var ivanov = new Passport(565656, "Иванов", "Петр", "Ильич", "1981-09-08");
        var sidorov = new Passport(989898, "Сидоров", "Илья", "Иванович", "1985-01-22");

        HashMap<Integer, Passport> passports = new HashMap<>();
        passports.put(petrov.getPassNumber(), petrov);
        passports.put(ivanov.getPassNumber(), ivanov);
        passports.put(sidorov.getPassNumber(), sidorov);

        System.out.println(passports.get(565656));
        System.out.println(passports.get(5865656));

        System.out.println("3 урок задание 1");
        Tasks.telephoneDirectory();
    }

    private static void addToRecipes(Set<Recipe> recipes, Recipe recipe) {
        if (!recipes.add(recipe)) {
            // Зачем здесь использовать выброс исключения?
            System.out.println("Рецепт " + recipe.getName() + " уже есть в списке рецептов");
        }
    }

    private static void removeOddNumbersFromSet() {
        Set<Integer> set = new HashSet<>();
        var random = new Random();
        for (int i = 0; i < 20; i++) {
            set.add(random.nextInt(1000));
        }
        System.out.println("Заполненное множество");
        System.out.println(set);
        System.out.println("Множество без нечетных");

        set.removeIf(integer -> integer % 2 == 0);
        System.out.println(set);
    }
}
