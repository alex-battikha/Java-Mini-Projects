package com.alex;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number % 5 == 0) {
            if (number % 3 == 0) {
                System.out.println("Fizz Buzz");
            }
            System.out.println("Fizz");
        }
        else if (number % 3 == 0) {
            System.out.println("Buzz");
        }
        else {
            System.out.println(number);
        }

    }
}
