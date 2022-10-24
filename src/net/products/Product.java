package net.products;


import java.util.Objects;

public class Product {
    private String name;
    private double cost;
    private int count;
    private boolean isBayed;

    public Product(String name, double cost, int count) {
        if (name != null && !name.isEmpty() && cost > 0 && count > 0) {
            this.name = name;
            this.cost = cost;
            this.count = count;
            isBayed = false;
        } else {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Аргумент функции указан не корректно");
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost > 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Аргумент функции указан не корректно");
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count > 0) {
            this.count = count;
        } else {
            throw new IllegalArgumentException("Аргумент функции указан не корректно");
        }
    }

    public boolean isBayed() {
        return isBayed;
    }

    public void setBayed(boolean bayed) {
        isBayed = bayed;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                ", isBayed=" + isBayed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cost == product.cost && Double.compare(product.count, count) == 0 && isBayed == product.isBayed && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, count, isBayed);
    }
}
