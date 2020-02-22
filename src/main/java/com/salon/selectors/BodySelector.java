package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.Body;
import com.salon.car.CarsBase;

import java.util.Scanner;

public class BodySelector extends CarTemplate {

    public void setBody(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                        FuelSelector fuel, EndTransaction end, Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getColor().getCost());
                color.setColor(base, car, color, body, upholstery, fuel, end, customer);
                break;
            case 1:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Body.SEDAN);
                break;
            case 2:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Body.PICKUP);
                break;
            case 3:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Body.HATCHBACK);
                break;
            case 4:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Body.COMBI);
                break;
            default:
                setBody(base, car, color, body, upholstery, fuel, end, customer);
                break;
        }
    }

    private void setCase(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                         FuelSelector fuel, EndTransaction end, Customer customer, Body bodies) {
        if (customer.getCustomerMoney() >= bodies.getCost()) {
            System.out.println("You chose a " + bodies + " bodies!");
            customer.getCustomerCar().setBody(bodies);
            takeMoney(customer, customer.getCustomerCar().getBody().getCost());
            upholstery.setUpholstery(base, car, color, body, upholstery, fuel, end, customer);
        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            setBody(base, car, color, body, upholstery, fuel, end, customer);
        }
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("\nSelect body of your car or press 0 too back select a color of car.");

        int number = 0;
        for (Body value : Body.values()) {
            number++;
            System.out.println("Number " + number + " body " + value + " cost $" + value.getCost());
        }
        System.out.print("Select body: ");
    }

}
