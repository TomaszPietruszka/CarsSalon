package com.salon.car;

import java.util.ArrayList;
import java.util.List;

public class CarsBase {
    private List<Car> listOfCars = createListOfCar();

    private List<Car> createListOfCar() {
        Car car1 = new Car("Audi A3", 15000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Car car2 = new Car("Passat B5", 2000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Car car3 = new Car("Fiat Panda", 5000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Car car4 = new Car("Porsche 911", 120500, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Car car5 = new Car("Opel Vectra", 19999, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);

        List<Car> listOfCars = new ArrayList<>();
        listOfCars.add(car1);
        listOfCars.add(car2);
        listOfCars.add(car3);
        listOfCars.add(car4);
        listOfCars.add(car5);
        return listOfCars;
    }

    public List<Car> getListOfCars() {
        return listOfCars;
    }
}
