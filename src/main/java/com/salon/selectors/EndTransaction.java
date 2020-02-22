package com.salon.selectors;

import com.salon.Customer;
import com.salon.car.CarsBase;

import java.util.Scanner;

public class EndTransaction extends CarTemplate {

    public boolean endTransaction(CarsBase base, CarSelector car, ColorSelector color, BodySelector body, UpholsterySelector upholstery,
                           FuelSelector fuel, EndTransaction end, Customer customer) {

        printWelcomeMessage();

        System.out.println(customer.getCustomerCar().toString());
        System.out.println("If you agree it press 1 \n" + "If you wanna back press 0 " + "\n");

        numberOfTry = 0;
        int accept = 1;
        int cancel = 0;

        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        if (select == accept) {
            System.out.println("Congratulations! You bought a car!");
            System.out.println("You have left $" + customer.getCustomerMoney());
            return false;
        } else if (select == cancel) {
            fuel.setFuel(base, car, color, body, upholstery, fuel, end, customer);
            return true;
        } else
            return true;
    }

    @Override
    public void printWelcomeMessage() {


    }
}
