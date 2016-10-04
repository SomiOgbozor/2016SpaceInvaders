package bankinterest;

public class BankInterest {

	public static void main(String[] args) {

		double principal = 4000;
		double interest = 0.02;
		
		int day =0;
		
		System.out.println("Day  Type  Amount  Balance");
		
		for (int i=0; i<31; i++) {
			if (Math.random() < 0.5) {
				principal = principal - 100; 
				System.out.println(day + " Withdraw " + " 100.00 " + principal);
			}
			else {
				principal = principal + 200.5;
				System.out.println(day + " Deposit " + " 200.50 " + principal);
				
			}
			day = day + 1;
		}
		System.out.println("Interest earned: " + principal*interest);
		System.out.println("Money earned after one month " + (principal + (principal*interest)));
		
	}

}
