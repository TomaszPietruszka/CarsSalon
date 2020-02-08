package com.salon;

public class Customer {
    private String name;
    private int customerMoney;

    public Customer(String name, int customerMoney) {
        this.name = name;
        this.customerMoney = customerMoney;
    }

    public String getName() {
        return name;
    }

    public int getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(int customerMoney) {
        this.customerMoney = customerMoney;
    }
}
