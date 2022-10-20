package net.products;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    private String name;
    private double summaryCost = 0;
    private Set<Product> products = new HashSet<>();

    public Recipe(String name, Product[] products) {
        if (name != null && !"".equals(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Рецепт не может быть без названия");
        }
        if (products != null) {
            this.products.addAll(Arrays.asList(products));
            for (Product product : products) {
                this.summaryCost += product.getCost();
            }
        } else {
            throw new IllegalArgumentException("Рецепт не может быть без продуктов");
        }
    }

    public String getName() {
        return name;
    }

    public double getSummaryCost() {
        return summaryCost;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", summaryCost=" + summaryCost +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Double.compare(recipe.summaryCost, summaryCost) == 0 && name.equals(recipe.name) && products.equals(recipe.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, summaryCost, products);
    }
}
