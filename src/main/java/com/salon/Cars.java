package com.salon;

public class Cars {
    private String model;
    private int price;
    private Colors color;
    private Body body;
    private Upholstery upholstery;
    private Fuel fuel;

    public Cars(String model, int price, Colors color, Body body, Upholstery upholstery, Fuel fuel) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.body = body;
        this.upholstery = upholstery;
        this.fuel = fuel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Upholstery getUpholstery() {
        return upholstery;
    }

    public void setUpholstery(Upholstery upholstery) {
        this.upholstery = upholstery;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
