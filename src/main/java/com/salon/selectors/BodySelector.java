package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.Body;

import java.util.Scanner;

public class BodySelector extends CarTemplate {

    void selectBody(Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getColor().getCost());
                colorSelector.setColor(customer);
                break;
            case 1:
                setCase(customer, Body.SEDAN);
                break;
            case 2:
                setCase(customer, Body.PICKUP);
                break;
            case 3:
                setCase(customer, Body.HATCHBACK);
                break;
            case 4:
                setCase(customer, Body.COMBI);
                break;
            default:
                selectBody(customer);
                break;
        }
    }

    private void setCase(Customer customer, Body body) {
        if (customer.getCustomerMoney() >= body.getCost()) {
            System.out.println("You chose a " + body + " body!");
            customer.getCustomerCar().setBody(body);
            takeMoney(customer, customer.getCustomerCar().getBody().getCost());
            upholsterySelector.selectUpholstery(customer);
        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            selectBody(customer);
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
