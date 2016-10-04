package expectedvalue;
import cse131.ArgsProcessor;

public class ExpectedValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArgsProcessor ap = new ArgsProcessor(args);
		double p = ap.nextDouble("What's the probability the startup succeeds? Enter a value between 0 & 1.");
		double valueGamer = (3*Math.sqrt((p * 190000) + ((1-p)*5000)));
		System.out.println("You'd make $" + (int)valueGamer + " as a gamer.");
		
		
		
		double valueProgrammer = (2*Math.sqrt(110000 + (50000)*Math.random()));
		System.out.println("You'd make $" + (int)valueProgrammer + " as a programmer.");
		
		if (valueProgrammer > valueGamer) {
			System.out.println("You should be a programmer.");
		}
		else {
			System.out.println("You should be a gamer.");
		}
	}

	
}
