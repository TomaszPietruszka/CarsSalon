package com.salon.car;

public enum Upholstery {
    VELOR(0),
    LEATHER(1000),
    QUILTED(2000);

    private int cost;

    Upholstery(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
