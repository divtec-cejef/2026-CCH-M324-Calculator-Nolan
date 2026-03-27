package ch.divtec;

import java.util.Scanner;

public class Calculator {

//    public int add(int a, int b) {
//        return a + b;
//    }
//
//    public int subtract(int a, int b) {
//        return a - b;
//    }
//
//    public int multiply(int a, int b) {
//        return a * b;
//    }
//
//    public int divide(int a, int b) {
//        return a / b;
//    }

    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible.");
        }
        return a / b;
    }

    long factorial(double n) {
        if (n != (int)n) {
            throw new IllegalArgumentException("Le factoriel est défini uniquement pour les entiers.");
        }

        long fact = 1;
        for (int i = 1; i <= (int) n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        double num1, num2 = 0.;
        Scanner sc = new Scanner(System.in);

        System.out.println("Allowed operators: + - * / !");
        System.out.println("Enter the operation to compute :");

        num1 = sc.nextDouble();
        char operator = sc.next().charAt(0);
        if (operator != '!') {
            num2 = sc.nextDouble();
        }

        final Calculator calc = new Calculator();

        double result;
        switch (operator) {
            case '+':
                result = calc.add(num1, num2);
                break;
            case '-':
                result = calc.subtract(num1, num2);
                break;
            case '*':
                result = calc.multiply(num1, num2);
                break;
            case '/':
                result = calc.divide(num1, num2);
                break;
            case '!':
                result = calc.factorial(num1);
                break;
            default:
                System.out.println("Invalid operator.");
                return;
        }
        System.out.println("The final result: " + num1 + " " + operator + " " + num2 + " = " + result);
    }
}