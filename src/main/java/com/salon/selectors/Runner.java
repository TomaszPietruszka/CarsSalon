package com.salon.selectors;

import com.salon.Customer;

public class Runner extends CarTemplate {

    public void run(Customer customer) {

        printWelcomeMessage();

        CarSelector carSelector = new CarSelector();
        carSelector.selectCar(customer);
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Welcome in our Cars Salon!\n");
    }

}


