package com.salon;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Picker {
    private List<Cars> listOfCars = createListOfCar();
    private Scanner scanner = new Scanner(System.in);
    private Cars customerCar;
    private int numberOfTry = 0;


    private List<Cars> createListOfCar() {
        Cars car1 = new Cars("Audi A3", 15000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car2 = new Cars("Passat B5", 8000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car3 = new Cars("Fiat Panda", 5000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car4 = new Cars("Porsche 911", 120500, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);
        Cars car5 = new Cars("Opel Vectra", 10000, Colors.WHITE, Body.COMBI, Upholstery.VELOR, Fuel.PETROL);

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
            System.out.println("Number " + number + " - car model: " + car.getModel() + " cost $" + car.getPrice());
        }

        System.out.print("Pick number of car: ");
        int picker = scanner.nextInt();
        switch (picker) {
            case 1:
                if (customer.getCustomerMoney() >= listOfCars.get(0).getPrice()) {
                    customerCar = listOfCars.get(0);
                    System.out.println("Your car is " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    pickColor(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickCar(customer);
                }
                break;
            case 2:
                if (customer.getCustomerMoney() >= listOfCars.get(1).getPrice()) {
                    customerCar = listOfCars.get(1);
                    System.out.println("Your car is " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    pickColor(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickCar(customer);
                }
                break;
            case 3:
                if (customer.getCustomerMoney() >= listOfCars.get(2).getPrice()) {
                    customerCar = listOfCars.get(2);
                    System.out.println("Your car is " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    pickColor(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickCar(customer);
                }
                break;
            case 4:
                if (customer.getCustomerMoney() >= listOfCars.get(3).getPrice()) {
                    customerCar = listOfCars.get(3);
                    System.out.println("Your car is " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    pickColor(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickCar(customer);
                }
                break;
            case 5:
                if (customer.getCustomerMoney() >= listOfCars.get(4).getPrice()) {
                    customerCar = listOfCars.get(4);
                    System.out.println("Your car is " + customerCar.getModel());
                    setCustomerMoney(customer, customerCar.getPrice());
                    pickColor(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickCar(customer);
                }
                break;
            default:
                pickCar(customer);
                break;
        }
    }

    private void pickColor(Customer customer) {
        System.out.println("Pick color of your car or press 0 too back pick the car.");

        int number = 0;
        for (Colors value : Colors.values()) {
            number++;
            System.out.println("Number " + number + " color " + value + " cost $" + value.getCost());
        }
        System.out.print("Pick color: ");
        int picker = scanner.nextInt();
        switch (picker) {
            case 0:
                numberOfTry = 0;
                turnMoneyToCustomer(customer, customerCar.getPrice());
                pickCar(customer);
                break;
            case 1:
                System.out.println("You chose a white car!");
                customerCar.setColor(Colors.WHITE);
                pickBody(customer);
                break;
            case 2:
                System.out.println("You chose a black car!");
                customerCar.setColor(Colors.BLACK);
                pickBody(customer);
                break;
            case 3:
                if (customer.getCustomerMoney() >= Colors.RED.getCost()) {
                    System.out.println("You chose a red car!");
                    customerCar.setColor(Colors.RED);
                    setCustomerMoney(customer, customerCar.getColor().getCost());
                    pickBody(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickColor(customer);
                }
                break;
            case 4:
                if (customer.getCustomerMoney() >= Colors.GREEN.getCost()) {
                    System.out.println("You chose a green car!");
                    customerCar.setColor(Colors.GREEN);
                    setCustomerMoney(customer, customerCar.getColor().getCost());
                    pickBody(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickColor(customer);
                }
                break;
            case 5:
                if (customer.getCustomerMoney() >= Colors.BLUE.getCost()) {
                    System.out.println("You chose a blue car!");
                    customerCar.setColor(Colors.BLUE);
                    setCustomerMoney(customer, customerCar.getColor().getCost());
                    pickBody(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickColor(customer);
                }
                break;
            default:
                pickColor(customer);
                break;
        }
    }

    private void pickBody(Customer customer) {
        System.out.println("\nPick body of your car or press 0 too back pick a color of car.");

        int number = 0;
        for (Body value : Body.values()) {
            number++;
            System.out.println("Number " + number + " body " + value + " cost $" + value.getCost());
        }
        System.out.print("Pick body: ");
        int picker = scanner.nextInt();
        switch (picker) {
            case 0:
                numberOfTry = 0;
                turnMoneyToCustomer(customer, customerCar.getColor().getCost());
                pickColor(customer);
                break;
            case 1:
                System.out.println("You chose a sedan body!");
                customerCar.setBody(Body.SEDAN);
                pickUpholstery(customer);
                break;
            case 2:
                if (customer.getCustomerMoney() >= Body.PICKUP.getCost()) {
                    System.out.println("You chose a pick-up body!");
                    customerCar.setBody(Body.PICKUP);
                    setCustomerMoney(customer, customerCar.getBody().getCost());
                    pickUpholstery(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickBody(customer);
                }
                break;
            case 3:
                if (customer.getCustomerMoney() >= Body.HATCHBACK.getCost()) {
                    System.out.println("You chose a hatchback body!");
                    customerCar.setBody(Body.HATCHBACK);
                    setCustomerMoney(customer, customerCar.getBody().getCost());
                    pickUpholstery(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickBody(customer);
                }
                break;
            case 4:
                if (customer.getCustomerMoney() >= Body.COMBI.getCost()) {
                    System.out.println("You chose a combi body!");
                    customerCar.setBody(Body.COMBI);
                    setCustomerMoney(customer, customerCar.getBody().getCost());
                    pickUpholstery(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickBody(customer);
                }
                break;
            default:
                pickBody(customer);
                break;
        }
    }

    private void pickUpholstery(Customer customer) {
        System.out.println("\nPick upholstery in your car or press 0 too back pick body of the car.");

        int number = 0;
        for (Upholstery value : Upholstery.values()) {
            number++;
            System.out.println("Number " + number + " upholstery " + value + " cost $" + value.getCost());
        }

        System.out.print("Pick upholstery: ");
        int picker = scanner.nextInt();
        switch (picker) {
            case 0:
                numberOfTry = 0;
                turnMoneyToCustomer(customer, customerCar.getBody().getCost());
                pickBody(customer);
                break;
            case 1:
                System.out.println("You chose a velor upholstery!");
                customerCar.setUpholstery(Upholstery.VELOR);
                pickFuel(customer);
                break;
            case 2:
                if (customer.getCustomerMoney() >= Upholstery.LEATHER.getCost()) {
                    System.out.println("You chose a leather upholstery!");
                    customerCar.setUpholstery(Upholstery.LEATHER);
                    setCustomerMoney(customer, customerCar.getUpholstery().getCost());
                    pickFuel(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickUpholstery(customer);
                }
                break;
            case 3:
                if (customer.getCustomerMoney() >= Upholstery.QUILTED.getCost()) {
                    System.out.println("You chose a quilted upholstery!");
                    customerCar.setUpholstery(Upholstery.QUILTED);
                    setCustomerMoney(customer, customerCar.getUpholstery().getCost());
                    pickFuel(customer);
                } else {
                    if (!checkNumberOfTry(customer)) {
                        return;
                    }
                    pickUpholstery(customer);
                }
                break;
            default:
                pickUpholstery(customer);
                break;
        }
    }

    private void pickFuel(Customer customer) {
        System.out.println("\nPick fuel in your car or press 0 too back pick the upholstery.");

        int number = 0;
        for (Fuel value : Fuel.values()) {
            number++;
            System.out.println("Number " + number + " fuel " + value + " cost $" + value.getCost());
        }

        System.out.print("Pick fuel: ");
        int picker = scanner.nextInt();
        switch (picker) {
            case 0:
                numberOfTry = 0;
                turnMoneyToCustomer(customer, customerCar.getUpholstery().getCost());
                pickUpholstery(customer);
            break;
            case 1:
                System.out.println("You chose petrol car!");
                customerCar.setFuel(Fuel.PETROL);
                endTransaction(customer);
            break;
            case 2:
                if (customer.getCustomerMoney() >= Fuel.DIESEL.getCost()) {
                    System.out.println("You chose diesel car!");
                    customerCar.setFuel(Fuel.DIESEL);
                    setCustomerMoney(customer, customerCar.getFuel().getCost());
                    endTransaction(customer);
                    break;
                } else {
                    if (!checkNumberOfTry(customer)) {
                        break;
                    }
                    pickFuel(customer);
                }
                break;
            case 3:
                if (customer.getCustomerMoney() >= Fuel.HYBRID.getCost()) {
                    System.out.println("You chose hybrid car!");
                    customerCar.setFuel(Fuel.HYBRID);
                    setCustomerMoney(customer, customerCar.getFuel().getCost());
                    endTransaction(customer);
                    break;
                } else {
                    if (!checkNumberOfTry(customer)) {
                        break;
                    }
                    pickFuel(customer);
                }
                break;
            default:
                pickFuel(customer);
                break;
        }
    }

    private boolean endTransaction(Customer customer) {
        numberOfTry = 0;
        System.out.println("\nThere are parameters of your car");
        System.out.println("Model: " + customerCar.getModel() + "\n" +
                "Basic price: $" + customerCar.getPrice() + "\n" +
                "Color: " + customerCar.getColor() + "\n" +
                "Body: " + customerCar.getBody() + "\n" +
                "Upholstery: " + customerCar.getUpholstery() + "\n" +
                "Fuel: " + customerCar.getFuel());
        System.out.println("If you agree it press 1 or ");
        System.out.println("If you wanna back press 0 ");
        int picker = scanner.nextInt();
        if (picker == 1) {
            System.out.println("Congratulations! You bought a car!");
            System.out.println("You have left $" + customer.getCustomerMoney());
            return false;
        } else if (picker == 0) {
            pickFuel(customer);
            return true;
        } else
            return true;
    }

    private boolean checkNumberOfTry(Customer customer) {
        numberOfTry++;
        if (numberOfTry == 1) {
            System.out.println("You haven't enough money! (You have $" + customer.getCustomerMoney() + ") You can pick again two more time. \n");
            return true;
        } else if (numberOfTry == 2) {
            System.out.println("You haven't enough money! (You have $" + customer.getCustomerMoney() + ") You can pick again one more time \n");
            return true;
        } else if (numberOfTry == 3) {
            System.out.println("You have try three time! GOODBYE!");
            return false;
        }
        return true;
    }

    private void turnMoneyToCustomer(Customer customer, int moneyToBack) {
        int cashBack = moneyToBack;
        customer.setCustomerMoney(customer.getCustomerMoney() + cashBack);
    }

    private static void setCustomerMoney(Customer customer, int cost) {
        int temp = customer.getCustomerMoney() - cost;
        customer.setCustomerMoney(temp);
        System.out.println("Now you have: $" + customer.getCustomerMoney() + "\n");
    }
}


