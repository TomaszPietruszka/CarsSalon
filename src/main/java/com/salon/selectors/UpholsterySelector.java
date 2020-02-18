package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.Upholstery;

import java.util.Scanner;

public class UpholsterySelector extends CarTemplate {

    void selectUpholstery(Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getBody().getCost());
                bodySelector.selectBody(customer);
                break;
            case 1:
                setCase(customer, Upholstery.VELOR);
                break;
            case 2:
                setCase(customer, Upholstery.LEATHER);
                break;
            case 3:
                setCase(customer, Upholstery.QUILTED);
                break;
            default:
                selectUpholstery(customer);
                break;
        }
    }

    private void setCase(Customer customer, Upholstery upholstery) {
        if (customer.getCustomerMoney() >= upholstery.getCost()) {
            System.out.println("You chose a " + upholstery + " upholstery!");
            customer.getCustomerCar().setUpholstery(upholstery);
            takeMoney(customer, customer.getCustomerCar().getUpholstery().getCost());
            fuelSelector.setFuel(customer);
        } else {
            if (!checkNumberOfTry(customer)) {
            return;
        }
        selectUpholstery(customer);
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
