package com.codewithnishanth;

import java.util.ArrayList;
import java.util.Scanner;


public class BankingApplication {
    static double balance = 1000;
    static ArrayList<Double> transactionList = new ArrayList<Double>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---------------Banking Application------------------");
            System.out.println("1. Credit\n2. Debit\n3. Check Balance\n4. Transaction History\n5. Exit");
            System.out.println("----------Please Enter your choice-----------");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter number of credits:");
                    int numCredits = scanner.nextInt();
                    for (int i = 0; i < numCredits; i++) {
                        System.out.println("Enter credit amount:");
                        double creditAmount = scanner.nextDouble();
                        balance += creditAmount;
                        transactionList.add(creditAmount);
                    }
                    System.out.println("Total Balance: " + balance);
                    break;

                case 2:
                    System.out.println("Enter number of debits:");
                    int numDebits = scanner.nextInt();
                    double totalCredits = 0;
                    for (double amount : transactionList) {
                        totalCredits += amount;
                    }
                    for (int i = 0; i < numDebits; i++) {
                        System.out.println("Enter debit amount:");
                        double debitAmount = scanner.nextDouble();
                        //if fix the minimum balance as 1000 Rs. then add this condition --> && balance >= debitAmount
                        if (totalCredits >= debitAmount) {
                            balance -= debitAmount;
                            transactionList.add(-debitAmount);
                        } else {
                            System.out.println("Insufficient funds for the debit transaction.");
                        }
                    }
                    System.out.println("Total Balance: " + balance);
                    break;

                case 3:
                    System.out.println("Total Balance: " + balance);
                    break;

                case 4:
                    System.out.println("Your Transaction History : ");
                    System.out.println(transactionList);
                    break;

                case 5:
                    System.out.println("Exiting the banking application. Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid choice.");

            }

        } while (choice != 5);
        scanner.close();
    }
}
