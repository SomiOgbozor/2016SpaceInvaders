package studio1;

import cse131.ArgsProcessor;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int n0 = ap.nextInt("Enter Integer");
		int n1 = ap.nextInt("Enter Integer");
		
		double d1 = 2;
		
		System.out.println("The average of the two values is " + ((n0+n1)/d1));

		
	}

}
