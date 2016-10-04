package onerepmax;

import cse131.ArgsProcessor;

public class OneRepMax {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int weight = ap.nextInt("What's the amount of weight?");
		int actualReps = ap.nextInt("How many completed reps?");
		int desiredReps = ap.nextInt("How many reps do you desire to complete?");
		
		double holdMaxWeight = (weight*(1 + (double)(actualReps/30.0) ));
		double holdDesiredWeight = (weight*(1 + ((double)desiredReps/30)));
		
		int maxWeight = (int) Math.round(holdMaxWeight-(holdMaxWeight%5));
		int desiredWeight = (int) Math.round(holdDesiredWeight-(holdDesiredWeight%5));
		
		System.out.println("One-rep max: " + maxWeight);
		System.out.println("Weight for " + desiredReps + " reps: " + desiredWeight);
		
		System.out.println("95% 1 RM: " + Math.round((maxWeight*.95-((maxWeight*.95)%5))));
		System.out.println("90% 1 RM: " + Math.round((maxWeight*.90-((maxWeight*.90)%5))));
		System.out.println("85% 1 RM: " + Math.round((maxWeight*.85-((maxWeight*.85)%5))));
		System.out.println("80% 1 RM: " + Math.round((maxWeight*.80-((maxWeight*.80)%5))));
		System.out.println("75% 1 RM: " + Math.round((maxWeight*.75-((maxWeight*.75)%5))));
		System.out.println("70% 1 RM: " + Math.round((maxWeight*.70-((maxWeight*.70)%5))));
		System.out.println("65% 1 RM: " + Math.round((maxWeight*.65-((maxWeight*.65)%5))));
		System.out.println("60% 1 RM: " + Math.round((maxWeight*.60-((maxWeight*.60)%5))));
		System.out.println("55% 1 RM: " + Math.round((maxWeight*.55-((maxWeight*.55)%5))));
		System.out.println("50% 1 RM: " + Math.round((maxWeight*.50-((maxWeight*.50)%5))));
		
		
		
		

	}

}
