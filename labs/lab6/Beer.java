package lab6;

public class Beer {

	// TODO Auto-generated method stub

	public static String bottlesOfBeer(int n){
		if (n==0){
			return "Hooray, you're drunk!";
		}
		else{
			return (n + " bottles of beer on the wall,  " + n + " bottles of beer, you take one down, pass it around, " + (n-1) + " bottles of beer on the wall.") + bottlesOfBeer(n-1);

		}
	}
	public static int function1 (int x){
		if ( x > 100){
			return x-10;
		}
		else{
			return x+11 + (function1(x+11));
		}

	}
	public static int function2(int x, int y){
		if (x == 0){
			return y +1;
		}
		else if (x > 0 && y == 0){
			return function2(x-1, 1);
		}
		else {
			return function2(x-1, function2(x, y-1));
		}
	}


	public static void main(String[] args) {
		System.out.println(bottlesOfBeer(5));
		System.out.println(function1(10));
		System.out.println(function2(1,0));
	}
}
