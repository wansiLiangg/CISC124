/*The program is for a player and a computer to play a game called "The Game of Big". 
 * Once the player or the computer gets more than 100, and then the program ends. 
 * 
 * Author: Wansi Liang
 * Student Number: 20067725
 */

import java.util.Scanner; 

public class Assn1_17WL {
	
	//Main method
	public final static void main(String[] args) {
		System.out.println("Welcome!");
		double round = 0; 	//decide who takes the round
		int counterP = 0; 	
		int counterC = 0;	
		int counterR = 0;	
		//checking if the total score of the player and the computer is greater than 100
		while (counterP < 100 && counterC < 100) {
			//player's turn
			if (round == 0) {
				System.out.println("It is your turn!"); 
				int dice1 = numbers();  
				int dice2 = numbers();	
				round = compareP(round, dice1, dice2, counterR); 	//decide would the player take the next round
				counterP = counterP(dice1, dice2, counterP, counterR);	//count for the total score of the player
				
			}
			//computer's round 
			else {
				System.out.println("It is computer's turn!");
				int dice1 = numbers();
				int dice2 = numbers();
				round = compareC(round, dice1, dice2, counterR);	//decide would the computer take the next round
				counterC = counterC(dice1, dice2, counterC, counterR); 	//count for the total score of the computer
			}
		}
		//print the ending of the game
		ending(counterP);
		// TODO Auto-generated method stub0
	}
	
	//This method is printing the ending
	public static void ending(int counterP) {
		//if the player gets more than 100
		if (counterP > 100) {
			System.out.println("Congratulations! You won!");
		}
		//if the computer gets more than 100
		else {
			System.out.println("Unfortunately, you lost!");
		}
		System.out.println("Thanks for playing!");
	}
	
	//This method is getting random numbers
	public static int numbers() {
		int num = (int)(Math.random() * ((6 - 1) + 1)) + 1;
		if (num == 1) {
			System.out.println("The number you get is one");
		}
		else if (num == 2) {
			System.out.println("The number you get is two");
		}
		else if (num == 3) {
			System.out.println("The number you get is three");
		}
		else if (num == 4) {
			System.out.println("The number you get is four");
		}
		else if (num == 5) {
			System.out.println("The number you get is five");
		}
		else {
			System.out.println("The number you get is six");
		}
		return num; 
	}
	
	//This method is calculating the total score of the player
	public static int counterP(int dice1, int dice2, int counterP, int counterR) {
		//if both numbers are 6, the total score is reset to 0
		if (dice1 == 6 && dice2 == 6) {
			counterP = 0; 
			System.out.println("Your total score is " + counterP);
			return counterP;
		}
		//if one of the number is 6, the score of this round is reset to 0
		else if (dice1 == 6 || dice2 == 6) {
			counterR = 0; 
			System.out.println("Your total score is " + counterP);
			return counterP;
		}
		//if both numbers are equal and not 6, the player gets twice of the total of two numbers
		else if (dice1 == dice2) {
			counterR = 2*(dice1+dice2); 
			counterP = counterP + counterR; 
			System.out.println("Your total score is " + counterP);
			return counterP;
		}
		//other numbers, the player gets the total of two numbers
		else {
			counterR = dice1 + dice2; 
			counterP = counterP + counterR; 
			System.out.println("Your total score is " + counterP);
			return counterP;
		}
	}
	
	//This method is calculating the total score of the computer
	public static int counterC(int dice1, int dice2, int counterC, int counterR) {
		//if both numbers are 6, the total score is reset to 0
		if (dice1 == 6 && dice2 == 6) {
			counterC = 0; 
			System.out.println("Computer's total score is " + counterC);
			return counterC;
		}
		//if one of the number is 6, the score of this round is reset to 0
		else if (dice1 == 6 || dice2 == 6) {
			counterR = 0; 
			System.out.println("Computer's total score is " + counterC);
			return counterC;
		}
		//if both numbers are equal and not 6, the computer gets twice of the total of two numbers
		else if (dice1 == dice2) {
			counterR = 2*(dice1+dice2); 
			counterC = counterC + counterR; 
			System.out.println("Computer's total score is " + counterC);
			return counterC;
		}
		//other numbers, the computer gets the total of two numbers
		else {
			counterR = dice1 + dice2; 
			counterC = counterC + counterR; 
			System.out.println("Computer's total score is " + counterC);
			return counterC;
		}
	}
	
	//This method is deciding would the player take the next round or not
	public static double compareP(double round, int dice1, int dice2, int counterR) {
		//if both numbers are 6, the player loses the round
		if (dice1 == 6 && dice2 == 6) {
			round = 1;
			System.out.println("Ouch! Your score was reset to zero and your turn ends!");
			return round; 
		}
		//if one of the number is 6, the player loses the round
		else if (dice1 == 6 || dice2 == 6) {
			round = 1; 
			System.out.println("Ouch! Your score in this round was reset to zero and your turn ends!");
			return round; 
		}
		//if both numbers are equal and not 6, the player have to do another round
		else if (dice1 == dice2) {
			round = 0;
			System.out.println("You can roll another round!");
			return round; 
		}
		//other numbers, the player can decide take the next round or not
		else {
			round = userInput();
			return round;
		}
	}
	
	//This method is asking the player if the player wants to take the next round or not 
	public static double userInput() {
		Scanner input = new Scanner(System.in);
		double dbl = 0.0; 
		boolean flag = false;
		//checking if the user input is correct
	    while (!flag) {
	    	System.out.println("Do you want to do another round? Please enter '0' to continue, or other intergers to switch the turn ");
	    	//if the user input is correct
	    	if (input.hasNextDouble()) {
	    		dbl = input.nextDouble();
	            flag = true;
	        }
	    	//if the user input is not correct
	    	else {
	    		System.out.println("You entered an invalid number, please re-enter: ");
	    	}
	    input.nextLine(); 
	    }
	    return dbl;
	}
	
	//This method is deciding would the computer take the next round or not
	public static double compareC(double round, int dice1, int dice2, int counterR) {
		//if both numbers are 6, the player loses the round
		if (dice1 == 6 && dice2 == 6) {
			round = 0;
			System.out.println("Ouch! Your score was reset to zero and your turn ends!");
			return round; 
		}
		//if one of the number is 6, the player loses the round
		else if (dice1 == 6 || dice2 == 6) {
			round = 0; 
			System.out.println("Ouch! Your score in this round was reset to zero and your turn ends!");
			return round; 
		}
		//if both numbers are equal and not 6, the player have to do another round
		else if (dice1 == dice2) {
			round = 1;
			System.out.println("You can roll another round!");
			return round; 
		}
		//other numbers, the player can decide take the next round or not
		else {
			int num = (int)(Math.random() * ((1 - 1) + 1)) + 0; 
			return num; 
		}
	}

}
