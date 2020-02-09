package com.salon;

public enum Colors {
    WHITE(0),
    BLACK(0),
    RED(500),
    GREEN(500),
    BLUE(500);

    private int cost;

    Colors(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
