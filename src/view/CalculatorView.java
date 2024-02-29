package view;

import model.ComplexNumber;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Choose an operation on complex numbers:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
    }

    public String getOperationChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine();
    }

    public double getDoubleInput() {
        return scanner.nextDouble();
    }

    public void displayInputPrompt(String message) {
        System.out.print(message + " ");
    }

    public void displayResult(ComplexNumber result) {
        System.out.println("Result: " + result);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void waitForInput() {
        System.out.println("\nLet's continue...");
        scanner.nextLine();
    }
}