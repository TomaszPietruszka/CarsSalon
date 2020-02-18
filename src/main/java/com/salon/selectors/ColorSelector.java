package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.Colors;

import java.util.Scanner;

public class ColorSelector extends CarTemplate {
    public Runner runner = new Runner();

    void setColor(Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getPrice());
                carSelector.selectCar(customer);
                break;
            case 1:
                setCase(customer, Colors.WHITE);
                break;
            case 2:
                setCase(customer, Colors.BLACK);
                break;
            case 3:
                setCase(customer, Colors.RED);
                break;
            case 4:
                setCase(customer, Colors.GREEN);
                break;
            case 5:
                setCase(customer, Colors.BLUE);
                break;
            default:
                setColor(customer);
                break;
        }
    }

    public void setCase(Customer customer, Colors color) {
        if (customer.getCustomerMoney() >= color.getCost()) {
            System.out.println("You chose a " + color + " car!");
            customer.getCustomerCar().setColor(color);
            takeMoney(customer, customer.getCustomerCar().getColor().getCost());
//            bodySelector.selectBody(customer);
        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            setColor(customer);
        }
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Select color of your car or press 0 too back select the car.");

        int number = 0;
        for (Colors value : Colors.values()) {
            number++;
            System.out.println("Number " + number + " color " + value + " cost $" + value.getCost());
        }

        System.out.print("Select color: ");
    }
}
