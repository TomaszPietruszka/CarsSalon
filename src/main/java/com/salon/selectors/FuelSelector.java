package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.Fuel;

import java.util.Scanner;

public class FuelSelector extends CarTemplate {

    void setFuel(Customer customer) {

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getUpholstery().getCost());
                upholsterySelector.selectUpholstery(customer);
                break;
            case 1:
                setCase(customer, Fuel.PETROL);
                break;
            case 2:
                setCase(customer, Fuel.DIESEL);
                break;
            case 3:
                setCase(customer, Fuel.HYBRID);
                break;
            default:
                setFuel(customer);
                break;
        }
    }

    private void setCase(Customer customer, Fuel fuel) {
        if (customer.getCustomerMoney() >= fuel.getCost()) {
            System.out.println("You chose + " + fuel + " car!");
            customer.getCustomerCar().setFuel(fuel);
            takeMoney(customer, customer.getCustomerCar().getFuel().getCost());
            endTransaction.endTransaction(customer);

        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            setFuel(customer);
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
