package net.products;

import java.util.*;

public class Recipe {
    private String name;
    private Map<Product, Integer> products = new HashMap<>();

    public Recipe(String name) {
        if (name != null && !"".equals(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Рецепт не может быть без названия");
        }
    }

    public String getName() {
        return name;
    }

    public double getSummaryCost() {

        double summaryCost = 0;

        Set<Product> productSet = new HashSet<>(products.keySet());
        for (Product product : productSet) {
            summaryCost += product.getCost() * products.get(product);
        }
        return summaryCost;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    // Объеденил задание 1-2 и 1-3.
    public void setProduct(Product product, Integer count) {
        count = Math.max(count, 1);
        if (!Objects.equals(products.get(product), count)) {
            products.put(product, count);
        } else {
            throw new IllegalArgumentException("Такой продукт с таким количеством уже есть в рецепте");
        }
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", summaryCost=" + getSummaryCost() +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name) && products.equals(recipe.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }
}
