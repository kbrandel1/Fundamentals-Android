package com.kbrandel.week_03;

import java.util.Scanner;

public class Main {

        static double getTemperature()
            {
                System.out.println("Enter a temperature.");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                return Double.parseDouble(input);

             }

        static double fahrenheitToCelsius (double fahrenheit)
            {
                return 5.0/9 * (fahrenheit - 32);

            }

        static void displayTemperature(double temperature)
            {
                System.out.println("The temperature is " + temperature);

            }

        public static void main(String[] args)
            {
                Double userInput = getTemperature();
                while (userInput >= -460)
                    {
                        displayTemperature(fahrenheitToCelsius(userInput));
                        userInput = getTemperature();
                    }

            }

}
