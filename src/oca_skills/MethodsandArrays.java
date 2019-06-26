package oca_skills;

import java.util.Arrays;
import java.util.Scanner;


public class MethodsandArrays {	
	public static void main(String[] args) {
		//Setup of used variables and objects
		Scanner input = new Scanner(System.in);
		//Methods to validate credit card numbers
		String ccCheck = "";
		System.out.print("Enter a credit card number as a long integer: ");
		String ccNumber = input.next();
		if(isValid(ccNumber)) {
			ccCheck = "valid";
		}
		else {
			ccCheck = "invalid";
		}
		System.out.println(ccNumber + " is " + ccCheck);
	
		System.out.println("Testing other methods: " + getPrefix(ccNumber, 1));	
		
		//Simulation of a bean machine a.k.a. Galton box
		System.out.print("Enter the number of balls to drop: ");
		int balls = input.nextInt();
		System.out.print("Enter the number of slots in the bean machine: ");
		int[] slots = new int[input.nextInt()];
		int slotCount = 0;
		
		for(int i = 0; i < balls; i++) {
			for(int j = 0; j < slots.length; j++) {
				int randomPick = (int)(Math.random() * 10);
				char direction = 'A';
				if(randomPick <= 5) {
					direction = 'L';
				}
				else {
					direction = 'R';
					slotCount++;
				}
				System.out.print(direction);
			}
			System.out.println();
			slots[slotCount - 1] += 1;
			slotCount = 0;
		}
		System.out.print("\n");
		
		System.out.println(java.util.Arrays.toString(slots));
		
		for(int i = 5; i >= 1; i--) {
			for(int j = 0; j < slots.length; j++) {
				if(slots[j] == i) {
					System.out.print("O");
					slots[j] = slots[j] - 1;
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}	
		
		//Eight Queens puzzle: placing 8 queens on a chessboard such that no two queens can attack eachother
		String gridOutput = "";
		char[][] gameGrid = new char[8][8];
		//initialize the array
				for(int i = 0; i < gameGrid.length; i++) {
					for(int j = 0; j < gameGrid[i].length; j++) {
						gameGrid[i][j] = ' ';
					}
				}

		gameGrid[0][0] = 'Q';
		gameGrid[1][4] = 'Q';
		gameGrid[2][7] = 'Q';
		gameGrid[3][5] = 'Q';
		gameGrid[4][2] = 'Q';
		gameGrid[5][6] = 'Q';
		gameGrid[6][1] = 'Q';
		gameGrid[7][3] = 'Q';
		
		gridOutput = Arrays.deepToString(gameGrid).replace("], ", "]\n");
		gridOutput = gridOutput.substring(1,gridOutput.length() - 1).replace("[", "|").replace("]", "|").replace(", ","|");
		System.out.println(gridOutput);
	}

	public static int sumOfDoubleEvenPlace(String number) {
		int sumOfDigits = 0;
		int temp = 0;
		for(int i = 0; i < number.length(); i++) {
			if(i % 2 == 0) {
				temp = (number.charAt(i) - 48) * 2;
				temp = getDigit(temp);
				sumOfDigits = sumOfDigits + temp;
			}			
		}
		System.out.println("Sum of digits is: " + sumOfDigits);
		return sumOfDigits; 
	}

	public static int getDigit(int number) {
		if(number >= 10) {
			String converter = new String(number + "");
			number = (converter.charAt(0) - 48) + (converter.charAt(1) - 48);
		}
	
		return number;
	}

	public static int sumOfOddPlace(String number) {
		int total = 0;
		for(int i = 0; i < number.length(); i++) {
			if(i % 2 != 0) {
				total += number.charAt(i) - 48;
			}
		}
		System.out.println("summing up odd places: " + total);
		return total;
	}

	public static boolean prefixMatched(String number, int d) {
		boolean isAMatch = true;
		isAMatch = number.startsWith("" + d);
		return isAMatch;
	}

	public static int getSize (String d) {
		return d.length();
	}

	public static long getPrefix(String number, int k) {
		String prefix = number.substring(0, k);
		long ccPrefix = 0;
		if(number.length() < k) {
			ccPrefix = Long.parseLong(number);
		}
		else if(prefix.length() == 1) {
			ccPrefix = prefix.charAt(0) - 48;
		}
		else {
			ccPrefix = (prefix.charAt(0) - 48) * 10 + (prefix.charAt(1) - 48); 
		}
		return ccPrefix;
	}

	public static boolean isValid(String number) {
		boolean validOrNo = false;
		int result = 0;
		result = sumOfDoubleEvenPlace(number);
		result += sumOfOddPlace(number);
		System.out.println(result + "");
		validOrNo = (result % 10) == 0 ? true : false;
		return validOrNo;
	}
}
