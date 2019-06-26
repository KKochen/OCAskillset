package oca_skills;

import java.util.Scanner;

public class Loops {
	public static void main(String[] args) {
		//setting up used variables and objects
		Scanner input = new Scanner(System.in);
		
		//Showing a nested loop with string formatting to create a number pyramid that is roughly symmetrical
		System.out.println("                                          1");
		int loopy = 1;
		int j = 0;
		int loopy2;
		String inbetween1 = "";
		String inbetween2 = "";
		String space = "                                          ";
		StringBuilder tryout = new StringBuilder();
			for(int i = 1; i <= 7; i++) {	
				for(j = i - 1; j < i; j++) {
					loopy *= 3;
					//inbetween1 += loopy + "   ";
					inbetween1 += String.format("%6s", loopy);
					loopy2 = loopy;
					loopy2 /= 3;
					if(loopy2 >= 3) {
						String inFront = String.format("%6s", loopy2);
						tryout.insert(0, inFront + "");
					}
					if(space.length() > 0) {
						space = space.substring(6);	
					}
					inbetween2 = tryout.toString();
					System.out.print(space + "1" + inbetween1 + inbetween2 + "     1");
					System.out.println();
				}
			}
		
		//Setup of an ISBN-13 check using a loop and selection statements
		System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
		String isbn = input.next();
		while(isbn.length() != 12) {
			System.out.println(isbn + " is an invalid input");
			System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
			isbn = input.next();
		}
		int isbnsum = 0;
		int num13 = 0;
		for(int i = 0; i < 12; i++) {
			if(i % 2 == 0) {
				isbnsum += isbn.charAt(i) - 48;
			}
			else {
				isbnsum += 3 * (isbn.charAt(i) - 48);
			}			
		}
		if(10 - (isbnsum % 10) == 10) {
			num13 = 0;
		}
		else {
			num13 = 10 - (isbnsum % 10);
		}
		System.out.println("The ISBN-13 number is: " + isbn + num13);
		
		//Rock,Paper,Scissors game using selection statements and a while-loop with termination condition
		int playerWin = 0;
		int compWin = 0;
		while(playerWin <= 3 && compWin <= 3) {
			System.out.print("Scissors (0), Rock (1), Paper (2): ");
			int choice = input.nextInt();
			int compChoice = (int)(Math.random() * 3);
			if(choice == 0) {
				if(compChoice == 2) {
					System.out.println("The computer is Paper. You are Scissors. You won!");
					playerWin++;
				}
				else if(compChoice == 1) {
					System.out.println("The computer is Rock. You are Scissors. You lost :(.");
					compWin++;
				}
				else if(compChoice == 0) {
					System.out.println("The computer is Scissors. You are Scissors too. It is a draw.");
				}
			}
			if(choice == 1) {
				if(compChoice == 2) {
					System.out.println("The computer is Paper. You are Rock. You lost :(.");
					compWin++;
				}
				else if(compChoice == 1) {
					System.out.println("The computer is Rock. You are Rock too. It is a draw.");
				}
				else if(compChoice == 0) {
					System.out.println("The computer is Scissors. You are Rock. You won!");
					playerWin++;
				}
			}	
			if(choice == 2) {
				if(compChoice == 2) {
					System.out.println("The computer is Paper. You are Paper too. It is a draw.");
				}
				else if(compChoice == 1) {
					System.out.println("The computer is Rock. You are Paper. You won!");
					playerWin++;
				}
				else if(compChoice == 0) {
					System.out.println("The computer is Scissors. You are Paper. You lost :(.");
					compWin++;
		 		}				
			}
			System.out.println("Player won " + playerWin + " times. Computer won " + compWin + " times.");
		}
		System.out.println("End of the game.");
		
		//Calculation of a loan amortization schema
		System.out.print("Loan amount: ");
		int amount = input.nextInt();
		System.out.print("Number of years: ");
		int numOfYears = input.nextInt();
		System.out.print("Annual interest rate: ");
		int interestRate = input.nextInt();
		
		double monthlyInterestRate = interestRate / 1200.0;
		double monthlyPayment = amount * ((monthlyInterestRate * Math.pow((1 + monthlyInterestRate),12)) / (Math.pow((1 + monthlyInterestRate),12) - 1));
		double balance = amount;
		double interestTotal = 0;
		
		System.out.printf("\nMonthly payment: %6.2f\n\n", monthlyPayment);
		
		System.out.println("Payment#\tInterest\tPrincipal\tBalance");
		for(int i = 1; i <= numOfYears * 12; i++) {
			double interest = monthlyInterestRate * balance;
			interestTotal += interest;
			double principal = monthlyPayment - interest;
			balance = balance - principal;
			/*if(i == numOfYears * 12 && balance != 0) {
				principal = principal + balance;
				System.out.println("This is your last payment to fulfill. Because the balance would not be 0 we have added" +
				" the remainder to fulfill to your principal payment. Please take note that your monthly payment will be" + 
				" a bit higher than before. Your payment is now: " + (interest + principal));
			}*/
			System.out.printf("%1d\t\t%5.2f\t\t%6.2f\t\t%7.2f\n",i,interest,principal,balance);
		}
		System.out.printf("\nTotal payment: %8.2f\n", (10000 + interestTotal));
	}
}
