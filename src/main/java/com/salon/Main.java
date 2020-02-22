package com.salon;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Tomasz", 20000);
        Runner runner = new Runner();
        runner.run(customer);
    }
}
