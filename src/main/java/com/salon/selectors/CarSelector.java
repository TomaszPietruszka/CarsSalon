package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.Car;
import com.salon.car.Cars;

import java.util.Scanner;

public class CarSelector extends CarTemplate {
    private Cars cars = new Cars();

    void selectCar(Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                setCase(customer, 0);
                break;
            case 2:
                setCase(customer, 1);
                break;
            case 3:
                setCase(customer, 2);
                break;
            case 4:
                setCase(customer, 3);
                break;
            case 5:
                setCase(customer, 4);
                break;
            default:
                selectCar(customer);
                break;
        }
    }

    public void setCase(Customer customer, int index) {
        if (customer.getCustomerMoney() >= cars.getListOfCars().get(index).getPrice()) {
            customer.setCustomerCar(cars.getListOfCars().get(index));
            System.out.println("Your car is " + customer.getCustomerCar().getModel());
            takeMoney(customer, customer.getCustomerCar().getPrice());

           colorSelector.setColor(customer);
        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            selectCar(customer);
        }
    }


    @Override
    public void printWelcomeMessage() {
        System.out.println("Cars list: ");

        int number = 0;
        for (Car car : cars.getListOfCars()) {
            number++;
            System.out.println("Number " + number + " - car model: " + car.getModel() + " cost $" + car.getPrice());
        }

        System.out.print("Select number of car: ");
    }
}
