package com.salon.car;

public enum Fuel {
    PETROL(0),
    DIESEL(10000),
    HYBRID(15000);

    private int cost;

    Fuel(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
