package com.salon.selectors;

import com.salon.Customer;

public abstract class CarTemplate {
    public int numberOfTry = 0;

    public abstract void printWelcomeMessage();

    void backMoney(Customer customer, int moneyToBack) {
        customer.setCustomerMoney(customer.getCustomerMoney() + moneyToBack);
        System.out.println("Now you have: $" + customer.getCustomerMoney() + "\n");
    }

    void takeMoney(Customer customer, int cost) {
        customer.setCustomerMoney(customer.getCustomerMoney() - cost);
        System.out.println("Now you have: $" + customer.getCustomerMoney() + "\n");
    }

    boolean checkNumberOfTry(Customer customer) {
        int firstTry = 1;
        int secondTry = 2;
        int thirdTry = 3;

        numberOfTry++;
        if (numberOfTry == firstTry) {
            System.out.println("You haven't enough money! (You have $" + customer.getCustomerMoney() + ") You can pick again two more time. \n");
            return true;
        } else if (numberOfTry == secondTry) {
            System.out.println("You haven't enough money! (You have $" + customer.getCustomerMoney() + ") You can pick again one more time \n");
            return true;
        } else if (numberOfTry == thirdTry) {
            System.out.println("You have try three time! GOODBYE!");
            return false;
        }
        return true;
    }
}
