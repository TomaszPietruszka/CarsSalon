package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.CarsBase;
import com.salon.car.Fuel;

import java.util.Scanner;

public class FuelSelector extends CarTemplate {

    public void setFuel(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                        FuelSelector fuel, EndTransaction end, Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getUpholstery().getCost());
                upholstery.setUpholstery(base, car, color, body, upholstery, fuel, end, customer);
                break;
            case 1:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Fuel.PETROL);
                break;
            case 2:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Fuel.DIESEL);
                break;
            case 3:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Fuel.HYBRID);
                break;
            default:
                setFuel(base, car, color, body, upholstery, fuel, end, customer);
                break;
        }
    }

    private void setCase(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                         FuelSelector fuel, EndTransaction end, Customer customer, Fuel fuels) {
        if (customer.getCustomerMoney() >= fuels.getCost()) {
            System.out.println("You chose + " + fuels + " car!");
            customer.getCustomerCar().setFuel(fuels);
            takeMoney(customer, customer.getCustomerCar().getFuel().getCost());
            end.endTransaction(base, car, color, body, upholstery, fuel, end, customer);

        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            setFuel(base, car, color, body, upholstery, fuel, end, customer);
        }
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("\nPick fuel in your car or press 0 too back pick the upholstery.");

        int number = 0;
        for (Fuel value : Fuel.values()) {
            number++;
            System.out.println("Number " + number + " fuel " + value + " cost $" + value.getCost());
        }

        System.out.print("Pick fuel: ");
    }
}
