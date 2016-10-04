package arrays;
import cse131.ArgsProcessor;

public class Birthday {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("How many people enter the room?");
		int [][] cal = new int[12][31];
		int[] sumMonths = new int[12];
		int[] sumDays= new int[31];

		for (int i=0; i < N; i++) {
			int m = (int)(Math.random()*12);
			int d = (int)(Math.random()*31);
			cal[m][d] = cal[m][d] + 1;
		}


		for (int j=0; j < 12; j++) {
			for(int k=0; k < 31; k++) {
				sumMonths[j] += cal[j][k];
				sumDays[k] += cal[j][k];
				//				System.out.println(sumDays[k]);
			}
			//			System.out.print(sumMonths[j]);
			//			System.out.println(" ");

		}

		double totalX= 0;
		for (int a=0; a < 12; a++){
			totalX += 1000.0*((double)sumMonths[a]/N)/10.0;
			System.out.println("Fraction of people born in month " + (a+1) + ": " + 1000.0*((double)sumMonths[a]/N)/10.0 + "%");

		}
		System.out.println(((totalX/12.0) + "%"));
		System.out.println("");
		double totalY = 0;
		for (int b=0; b < 31; b++) {
			totalY += 1000.0*((double)sumDays[b]/N)/10.0;
			System.out.println("Fraction of people born in day " + (b+1) + ": " + 1000.0*((double)sumDays[b]/N)/10.0 + "%");
		}
		System.out.println(((1000*totalY/31.0)/1000 + "%"));
	}
}


