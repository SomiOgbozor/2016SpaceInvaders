package lab3;

import java.util.Arrays;

import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int numDice = ap.nextInt("How many dice are you using?");
		int timesDice = ap.nextInt("How many times will you throw the dice?");
		int[][] valueDice = new int[timesDice][numDice];
		
		int numRolls = 0;
		boolean compare = true;
		double count = 0.0;


		for (int i=0; i < timesDice; i++) {
			int sumValueDice = 0;
			for (int j=0; j < numDice; j++) {
				valueDice[i][j]= (int)(Math.random()*6) + 1;
				sumValueDice = sumValueDice + valueDice[i][j];
				numRolls = numRolls + 1;


				System.out.print( + valueDice[i][j] + " showed up ");

			}System.out.println();
			System.out.println("Sum of the dice is " + sumValueDice);

		}
		for (int i =0; i < timesDice; i++) {
			compare = true;
			for (int j=0; j  < numDice; j++) {
				if (valueDice[i][0] != valueDice[i][j]) {
					compare = false;
				}
			}
			if (compare) {
				count = count + 1;

			}
		}
		System.out.println((count/(double)timesDice));
	}







}








