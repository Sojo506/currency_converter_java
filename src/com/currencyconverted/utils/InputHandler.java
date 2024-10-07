package com.currencyconverted.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {

    // Gets the value (amount) the user wants to convert
    public static int getAmount(Scanner scanner) {
        System.out.print("Enter the value you want to convert: ");
        int amount = 0;
        try {
            amount = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount entered. Please try again.");
            scanner.nextLine();  // Clears the buffer
        }
        return amount;
    }

    // Gets the option selected by the user
    public int getUserOption(Scanner scanner) {
        int option = -1;
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter only numbers please!");
            scanner.nextLine();  // Clears the buffer
        }
        return option;
    }
}
