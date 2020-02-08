package com.salon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Picker {
    private List<Cars> listOfCars = createListOfCar();
    private Scanner scanner = new Scanner(System.in);
    private Cars customerCar;


    private List<Cars> createListOfCar() {
        Cars car1 = new Cars("Audi A3", 130000000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car2 = new Cars("Passat B5", 8000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car3 = new Cars("Fiat Panda", 5000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car4 = new Cars("Porsche 911", 25000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car5 = new Cars("Opel Vectra", 1000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);

        List<Cars> listOfCars = new ArrayList<>();
        listOfCars.add(car1);
        listOfCars.add(car2);
        listOfCars.add(car3);
        listOfCars.add(car4);
        listOfCars.add(car5);
        return listOfCars;
    }

    public void pickCar(Customer customer) {
        System.out.println("Car list: ");
        int number = 0;
        for (Cars car : listOfCars) {
            number++;
            System.out.println("Number " + number + " - car model: " + car.getModel() + " cost " + car.getPrice() + "$");
        }

        System.out.print("Pick number of car: ");

        int picker = scanner.nextInt();
        /*try {

        } catch (Exception ex) {
            pickCar(customer);
            return;
        }*/
        //TODO catch a exeption

        switch (picker) {
            case 1:
                if (customer.getCustomerMoney() > listOfCars.get(0).getPrice()) {
                    customerCar = listOfCars.get(0);
                    System.out.println("Your car is : " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    break;
                } else {
                    System.out.println("You haven't enough money! Pick once again \n");
                    pickCar(customer);
                    break;
                }
            case 2:
                if (customer.getCustomerMoney() > listOfCars.get(1).getPrice()) {
                    customerCar = listOfCars.get(1);
                    System.out.println("Your car is : " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    break;
                } else {
                    System.out.println("You haven't enough money! Pick once again \n");
                    pickCar(customer);
                    break;
                }
            case 3:
                if (customer.getCustomerMoney() > listOfCars.get(2).getPrice()) {
                    customerCar = listOfCars.get(2);
                    System.out.println("Your car is : " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    break;
                } else {
                    System.out.println("You haven't enough money! Pick once again \n");
                    pickCar(customer);
                    break;
                }
            case 4:
                if (customer.getCustomerMoney() > listOfCars.get(3).getPrice()) {
                    customerCar = listOfCars.get(3);
                    System.out.println("Your car is : " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    break;
                } else {
                    System.out.println("You haven't enough money! Pick once again \n");
                    pickCar(customer);
                    break;
                }
            case 5:
                if (customer.getCustomerMoney() > listOfCars.get(4).getPrice()) {
                    customerCar = listOfCars.get(4);
                    System.out.println("Your car is : " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    break;
                } else {
                    System.out.println("You haven't enough money! Pick once again \n");
                    pickCar(customer);
                    break;
                }
            default:

                pickCar(customer);
                break;
        }


    }


    public void pickColor(Customer customer) {

        System.out.println("Pick color of your car or press 0 too back pick the car");
        int number = 0;
        for (Colors value : Colors.values()) {
            number++;
            System.out.println("Number " + number + " color " + value + " cost " + value.getCost() + "$");
        }


        int picker = scanner.nextInt();
        switch (picker){
            case 0:


        }



    }


    private static void setCustomerMoney (Customer customer, int cost) {
        int temp = customer.getCustomerMoney() - cost;
        customer.setCustomerMoney(temp);
        System.out.println("Now you have: " + customer.getCustomerMoney() + "$ \n");
    }
}


