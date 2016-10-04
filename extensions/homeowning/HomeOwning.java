package homeowning;

import cse131.ArgsProcessor;

public class HomeOwning {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String apartment = ap.nextString("Name of the apartment?");
		String zipCode = ap.nextString("Zip code of the apartment?");
		
		int costRentMonth = ap.nextInt("How much does it cost to rent the property per month?");
		double costInterestDaily = ap.nextDouble("What's the daily interest on the property");
		
		int costRentYear = (costRentMonth)*12;
		double costRentWeek = costRentYear/52;
		double costInterestWeek = costInterestDaily*7; 
		double costInterestYear = costInterestDaily*52;
		
		System.out.println(apartment + " is located in the Zip Code " + zipCode );
		System.out.println("Rent per year: " + costRentYear);
		System.out.println("Rent per week: " + costRentWeek);
		System.out.println(" ");
		System.out.println("Interest paid per year: " + Math.round(costInterestYear*100.00)/100.00);
		System.out.println("Interest paid per week: " + Math.round(costInterestWeek*100.00)/100.00);
		
		if (costRentWeek>costRentYear) {
			System.out.println("You should rent.");
		}
		else {
			System.out.println("You should own.");
		}
		
		
		
		
		
	

	}

}
