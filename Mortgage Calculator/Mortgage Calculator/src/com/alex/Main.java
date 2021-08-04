package com.alex;

import java.text.NumberFormat;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

	    int percent = 100;
	    int months = 12;

	    //P value - principal
        System.out.print("Principal ($1K - $1M): ");
        int principal = scanner.nextInt();
        while(principal < 1000 || principal > 1000000) {
            System.out.print("Please enter a number between $1,000 and $1,000,000: ");
            principal = scanner.nextInt();
        }

        //R value - monthly interest rate
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextInt();
        float monthlyInterestRate = (annualInterestRate/percent) / months;
        while(annualInterestRate <= 0 || annualInterestRate >= 30) {
            System.out.print("Please enter a value greater than 0 and less than or equal to 30: ");
            annualInterestRate = scanner.nextInt();
        }

        //N value - number of payments
        System.out.print("Period (Years): ");
        int periodYears = scanner.nextInt();
        int periodMonths = periodYears * months;
        while(periodYears < 1 || periodYears > 30) {
            System.out.print("Please enter a value in between 1 and 30: ");
            periodYears = scanner.nextInt();
        }

        double interestRateExponent = Math.pow((1 + monthlyInterestRate), periodMonths);
        double topHalfFraction = (monthlyInterestRate * interestRateExponent);
        double bottomHalfFraction = interestRateExponent - 1;

        double mortgagePayment = principal * (topHalfFraction / bottomHalfFraction);
        String mortgagePaymentFormatted = currencyFormatter.format(mortgagePayment);

//        System.out.println(principal);
//        System.out.println(annualInterestRate);
//        System.out.println(periodMonths);
        System.out.println(mortgagePaymentFormatted);

    }
}
