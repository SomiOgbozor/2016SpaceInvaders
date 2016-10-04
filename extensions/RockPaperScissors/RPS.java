package RockPaperScissors;

import cse131.ArgsProcessor;

public class RPS {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);

		int rounds = ap.nextInt("How many rounds will you play?");
		String userThrows = "rock";
		String userRock = "rock";
		String paper = "paper";
		String scissors = "scissors";
		String compThrows = "rock";
		int humanWins = 0;
		int compWins = 0;
		int numDraw = 0;
				

		while (rounds > 0) {
			if (rounds%3 == 1) {
				userThrows = scissors;
			}
			else if (rounds%3 ==2) {
				userThrows = paper;
			}
			else {
				userThrows = userRock;
			}
			rounds = rounds - 1;
			System.out.println("Human threw " + userThrows);

			double compRandom = Math.random()*3;

			if (compRandom < 1) {
				compThrows = userRock;	
			}
			else if (compRandom < 2) {
				compThrows = paper;
			}
			else {
				compThrows = scissors;
			}

			System.out.println("Computer threw " + compThrows);

			if (userThrows == compThrows) {
				System.out.println("It's a draw");
				numDraw = numDraw + 1;
			}
			else if (userThrows == userRock && compThrows == scissors) {
				System.out.println("Human wins.");
				humanWins = humanWins + 1;
			}
			else if (userThrows == userRock && compThrows == paper) {
				System.out.println("Computer wins.");
				compWins = compWins + 1;
			}
			else if (userThrows == paper && compThrows == scissors) {
					System.out.println("Computer wins.");
					compWins = compWins + 1;
			}
			else if (userThrows == paper && compThrows == userRock) {
				System.out.println("Human wins.");
				humanWins = humanWins + 1;
			}
			else if (userThrows == scissors && compThrows == userRock) {
				System.out.println("Computer wins.");
				compWins = compWins + 1;
			}
			else if (userThrows == scissors && compThrows == paper) {
				System.out.println("Human wins.");
				humanWins = humanWins + 1;
			}
			System.out.println(" ");
			
			}



			System.out.println("Human won " + humanWins + " times, computer won " + compWins + " times, and there were " + numDraw + " draws.");


		}






	}
