package com.lorddead.calculator.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в калькулятор.");
        System.out.println("Вам необходимо будет выбрать знак действия (+,-,*,/).");
        System.out.println("Также необходимо будет ввести первое и второе число.\n");

        /*Ввод данных: знак, первое число, второе число*/
        var console = new Scanner(System.in);

        System.out.print("Введите знак действия - ");
        String sign = console.next();

        int val1 = readIntInput(console, "Введите первое число - ");
        int val2 = readIntInput(console, "Введите второе число - ");

        System.out.println("Xer");
        System.out.println(calcExp(val1, val2, sign));

        console.close();
    }


    private static int readIntInput(Scanner console, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число.");
                console.nextLine(); // Очистка буффера
            }
        }
    }

    private static String calcExp(int val1, int val2, String sign) {
        final String resExp = "Результат вашего выражения: ";
        switch (sign) {
            case "+":
                return resExp + (val1 + val2);
            case "*":
                return resExp + (val1 * val2);
            case "/":
                return val2 != 0 ? resExp + (val1 / val2) : "Ошибка: деление на ноль.";
            case "-":
                return resExp + (val1 - val2);
            default:
                return "Такой операции не существует!";
        }
    }
}