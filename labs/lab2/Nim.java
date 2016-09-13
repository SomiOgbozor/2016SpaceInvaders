package lab2;

import cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		ArgsProcessor ap = new ArgsProcessor(args);
		int startSticks = ap.nextInt("How many sticks to start with?");
		int rounds = 0; 
		int roundsTwo = 1;
		String humanFirst = "Human";
		String compFirst = "Computer";
		
		String compHuman = compFirst;
		int first = ap.nextInt("Who goes first?  1 for human, 2 for computer");
		while (first > 2) {
			System.out.println("Error: Must Select 1 or 2");
			first = ap.nextInt("Who goes first?  1 for human, 2 for computer");
		}
			 if (first == 1) {
				compHuman = humanFirst;
				roundsTwo = 0;
			}
			
			System.out.println(compHuman + " starts");
			
			while (startSticks > 0) {
				int roundStartSticks = startSticks;
				int sticks = 2;
				
				if (roundsTwo%2 == 0) {
					boolean oneOrTwo = false;
					while (!oneOrTwo) {
						int humanSticks = ap.nextInt("How many sticks will you draw?");
						if (humanSticks == 1) {
							startSticks = startSticks - 1;
							sticks = 1;
							oneOrTwo = true;
						}
						else if ((humanSticks == 2) && (startSticks > 1)) {
							startSticks = startSticks - 2;
							oneOrTwo = true;
						}
						else  {
							System.out.println("Error: Pick a different number");
						}
					}
					compHuman = humanFirst;
				}
					else if ((roundsTwo+1)%2 == 0) {
						boolean doubleSticks = Math.random() > 0.5;
						if ((doubleSticks) && (startSticks > 1)) {
							startSticks = startSticks - 2;
						}
						else {
							startSticks = startSticks - 1;
							sticks = 1;
						}
						compHuman = compFirst;
					}
					
					System.out.println("Round " + rounds + ", " + roundStartSticks + " sticks at start, " + compHuman + " took " + sticks + ", so " + startSticks + " remain.");
					rounds = rounds + 1;
					roundsTwo = roundsTwo + 1;
				}
				
				System.out.println(compHuman + " wins");
				
				} 
				
				
			}
		
		
	
	
			