package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.CarsBase;
import com.salon.car.Colors;

import java.util.Scanner;

public class ColorSelector extends CarTemplate {

    public void setColor(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                         FuelSelector fuel, EndTransaction end, Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 0:
                numberOfTry = 0;
                backMoney(customer, customer.getCustomerCar().getPrice());
                car.selectCar(base, car, color, body, upholstery, fuel, end, customer);
                break;
            case 1:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Colors.WHITE);
                break;
            case 2:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Colors.BLACK);
                break;
            case 3:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Colors.RED);
                break;
            case 4:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Colors.GREEN);
                break;
            case 5:
                setCase(base, car, color, body, upholstery, fuel, end, customer, Colors.BLUE);
                break;
            default:
                setColor(base, car, color, body, upholstery, fuel, end, customer);
                break;
        }
    }

    public void setCase(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                        FuelSelector fuel, EndTransaction end, Customer customer, Colors colors) {
        if (customer.getCustomerMoney() >= colors.getCost()) {
            System.out.println("You chose a " + colors + " car!");
            customer.getCustomerCar().setColor(colors);
            takeMoney(customer, customer.getCustomerCar().getColor().getCost());
            body.setBody(base, car, color, body, upholstery, fuel, end, customer);
        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            setColor(base, car, color, body, upholstery, fuel, end, customer);
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
