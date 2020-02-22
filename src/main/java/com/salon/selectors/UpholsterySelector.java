package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.CarsBase;
import com.salon.car.Upholstery;

import java.util.Scanner;

public class UpholsterySelector extends CarTemplate {

    public void setUpholstery(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                       FuelSelector fuel, EndTransaction end, Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getBody().getCost());
                body.setBody(base, car, color, body, upholstery, fuel, end, customer);
                break;
            case 1:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Upholstery.VELOR);
                break;
            case 2:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Upholstery.LEATHER);
                break;
            case 3:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Upholstery.QUILTED);
                break;
            default:
                setUpholstery(base, car, color, body, upholstery, fuel, end, customer);
                break;
        }
    }

    private void setCase(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                         FuelSelector fuel, EndTransaction end, Customer customer, Upholstery upholsterys) {
        if (customer.getCustomerMoney() >= upholsterys.getCost()) {
            System.out.println("You chose a " + upholsterys + " upholsterys!");
            customer.getCustomerCar().setUpholstery(upholsterys);
            takeMoney(customer, customer.getCustomerCar().getUpholstery().getCost());
            fuel.setFuel(base, car, color, body, upholstery, fuel, end, customer);
        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            setUpholstery(base, car, color, body, upholstery, fuel, end, customer);
        }
    }


    @Override
    public void printWelcomeMessage() {
        System.out.println("\nPick upholstery in your car or press 0 too back pick body of the car.");

        int number = 0;
        for (Upholstery value : Upholstery.values()) {
            number++;
            System.out.println("Number " + number + " upholstery " + value + " cost $" + value.getCost());
        }
        System.out.print("Pick upholstery: ");
    }
}
