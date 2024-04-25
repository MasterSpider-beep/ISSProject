package com.projectiss.domain;

import java.util.Objects;

public class Produs extends Entity{
    private String name;
    private float price;
    private int stock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Produs produs = (Produs) o;
        return Float.compare(price, produs.price) == 0 && stock == produs.stock && Objects.equals(name, produs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price, stock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Produs(String name, float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
