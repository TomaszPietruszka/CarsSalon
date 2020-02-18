package com.salon.selectors;

import com.salon.Customer;

import java.util.Scanner;

public class EndTransaction extends CarTemplate {
    private BodySelector bodySelector = new BodySelector();

    boolean endTransaction(Customer customer) {

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
            bodySelector.selectBody(customer);
            return true;
        } else
            return true;
    }

    @Override
    public void printWelcomeMessage() {


    }
}
