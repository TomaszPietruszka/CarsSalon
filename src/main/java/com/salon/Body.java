package com.salon;

public enum Body {
    SEDAN(0),
    PICKUP(2000),
    HATCHBACK(1000),
    COMBI(1000);

    private int cost;

    Body(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
