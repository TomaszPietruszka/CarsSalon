package com.salon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Customer customer = new Customer("Tomasz", 20000);

        Scanner scanner = new Scanner(System.in);

        Picker picker = new Picker();

        picker.pickCar(customer);

        picker.pickColor(customer);



    }



}
