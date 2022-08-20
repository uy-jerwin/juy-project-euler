package com.carandang.cart;

public class CartItem {

    private int index;
    private String name;
    private double cost;

    public CartItem(int index, String name, double cost) {
        this.index = index;
        this.name = name;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

}
