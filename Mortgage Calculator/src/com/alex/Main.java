package com.alex;

import java.text.NumberFormat;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

	    byte percent = 100;
	    byte months = 12;

	    //P value - principal
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        //R value - monthly interest rate
        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextInt();
        float monthlyInterestRate = (annualInterestRate/percent) / months;

        //N value - number of payments
        System.out.print("Period(Years): ");
        int periodYears = scanner.nextInt();
        int periodMonths = periodYears / months;

        double interestRateExponent = Math.pow((1 + monthlyInterestRate), periodMonths);
        double topHalfFraction = (monthlyInterestRate * interestRateExponent);
        double bottomHalfFraction = interestRateExponent - 1;

        double mortgagePayment = principal * (topHalfFraction / bottomHalfFraction);
        String mortgagePaymentFormatted = currencyFormatter.format(mortgagePayment);

	    // System.out.println(principal);
	    // System.out.println(annualInterestRate);
	    // System.out.println(period);
        System.out.println(mortgagePaymentFormatted);

    }
}
