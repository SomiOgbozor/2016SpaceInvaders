package speeding;
import cse131.ArgsProcessor;

public class SpeedLimit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArgsProcessor ap = new ArgsProcessor(args);
		int carSpeed = ap.nextInt("What was the speed of the driver?");
		int speedLimit = ap.nextInt("What is the speed limit?");
		int speedOver = carSpeed-speedLimit; 
		
		int smallFine = speedOver >= 10 ? 50 : 0;
		
		
		int bigFine = Math.abs(smallFine + ((speedOver-10)*10));
				
		
		
		
		System.out.println("You reported a speed of " + carSpeed + " MPH for a speed limit of " + speedLimit + " MPH. Your fine is $" + bigFine + ".");
		
	}

}
