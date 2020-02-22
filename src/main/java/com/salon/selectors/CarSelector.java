package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.Car;
import com.salon.car.CarsBase;

import java.util.Scanner;

public class CarSelector extends CarTemplate {

    public void selectCar(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                          FuelSelector fuel, EndTransaction end, Customer customer) {
        printWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                setCase(base, car, color, body, upholstery, fuel, end, customer, 0);
                break;
            case 2:
                setCase(base, car, color, body, upholstery, fuel, end, customer, 1);
                break;
            case 3:
                setCase(base, car, color, body, upholstery, fuel, end, customer, 2);
                break;
            case 4:
                setCase(base, car, color, body, upholstery, fuel, end, customer, 3);
                break;
            case 5:
                setCase(base, car, color, body, upholstery, fuel, end, customer, 4);
                break;
            default:
                selectCar(base, car, color, body, upholstery, fuel, end, customer);
                break;
        }
    }

    public void setCase(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                        FuelSelector fuel, EndTransaction end, Customer customer, int index) {
        if (customer.getCustomerMoney() >= base.getListOfCars().get(index).getPrice()) {
            customer.setCustomerCar(base.getListOfCars().get(index));
            System.out.println("Your car is " + customer.getCustomerCar().getModel());
            takeMoney(customer, customer.getCustomerCar().getPrice());

            color.setColor(base, car, color, body, upholstery, fuel, end, customer);
        } else {
            if (!checkNumberOfTry(customer)) {
                return;
            }
            selectCar(base, car, color, body, upholstery, fuel, end, customer);
        }
    }


    @Override
    public void printWelcomeMessage() {
        CarsBase carsBase = new CarsBase();
        System.out.println("Cars list: ");

        int number = 0;
        for (Car car : carsBase.getListOfCars()) {
            number++;
            System.out.println("Number " + number + " - car model: " + car.getModel() + " cost $" + car.getPrice());
        }

        System.out.print("Select number of car: ");
    }
}
