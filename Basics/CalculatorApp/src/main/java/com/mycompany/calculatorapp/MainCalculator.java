package com.mycompany.calculatorapp;

import java.util.Scanner;

class Calculation {
    public int addition(int a, int b, int c) {
        return a + b + c;
    }
}

class Arithmetic extends Calculation {
    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public double division(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return (double) a / b;
    }
}

// Main class (public, matches file name)
public class MainCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        Arithmetic calc = new Arithmetic();

        System.out.println("\n--- Results ---");
        System.out.println("Addition of all three numbers: " + calc.addition(num1, num2, num3));
        System.out.println("Subtraction (first - second): " + calc.subtraction(num1, num2));
        System.out.println("Multiplication (second * third): " + calc.multiplication(num2, num3));
        System.out.println("Division (first / third): " + calc.division(num1, num3));

        sc.close();
    }
}
