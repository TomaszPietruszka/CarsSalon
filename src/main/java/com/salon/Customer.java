package com.salon;

import com.salon.car.Car;

public class Customer {
    private String name;
    private int customerMoney;
    private Car customerCar;

    public Customer(String name, int customerMoney) {
        this.name = name;
        this.customerMoney = customerMoney;
    }


    public int getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(int customerMoney) {
        this.customerMoney = customerMoney;
    }

    public Car getCustomerCar() {
        return customerCar;
    }

    public void setCustomerCar(Car customerCar) {
        this.customerCar = customerCar;
    }
}
