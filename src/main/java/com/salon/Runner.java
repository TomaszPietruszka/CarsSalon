package com.salon;

import com.salon.car.CarsBase;
import com.salon.selectors.*;

public class Runner extends CarTemplate {
    private CarsBase base = new CarsBase();
    private CarSelector car = new CarSelector();
    private ColorSelector color = new ColorSelector();
    private BodySelector body = new BodySelector();
    private UpholsterySelector upholstery = new UpholsterySelector();
    private FuelSelector fuel = new FuelSelector();
    private EndTransaction end = new EndTransaction();

    public void run(Customer customer) {
        printWelcomeMessage();
        car.selectCar(base, car, color, body, upholstery, fuel, end, customer);
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome in our Cars Salon!\n");
    }
}


