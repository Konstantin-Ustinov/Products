package net.products;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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
