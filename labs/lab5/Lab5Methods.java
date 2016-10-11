package lab5;

public class Lab5Methods {

	/**
	 * 
	 * @param n any integer
	 * @return the sum of the positive integers n + (n-2) + (n-4) + etc...
	 */
	public static int sumDownBy2(int n)
	{
		int sum = 0;
		while (n > 0) {
			sum+= n;
			n = n-2;
		}
		return sum;
	}

	/**
	 * 
	 * @param n any number
	 * @return the sum 1 + 1/2 + 1/3 + ... + 1/(n-1) + 1/n
	 */
	public static double harmonicSum(double n)
	{
		double sum = 0;
		while (n > 0) {
			sum += (1.0/n);
			n = n-1;
		}
		return sum;
	}

	/**
	 * 
	 * @param k any non-negative integer
	 * @return the sum 1 + 1/2 + 1/4 + 1/8 + ... + 1/Math.pow(2,k)
	 */
	public static double geometricSum(double k)
	{
		double sum = 0;
		while (k >= 0) {
			sum += 1/(Math.pow(2, k));
			k = k-1;
		}
		return sum;	
	}

	/**
	 * 
	 * @param x positive integer
	 * @param y positive integer
	 * @return the product of x and y
	 */
	public static int multPos(int x, int y)
	{
		int product = 0;
		while (x > 0){
			product+= y;
			x--;	
		}
		return product;
	}

	/**
	 * 
	 * @param x any integer
	 * @param y any integer
	 * @return the product of x and y
	 */
	public static int mult(int x, int y)
	{
		if (x < 0) {
			return multPos(-x,-y);
		}
		else {
			return multPos(x,y);
		}
	}

	/**
	 * 
	 * @param n any integer
	 * @param k any integer greater than or equal to zero
	 * @return the value of n to the power k
	 */
	public static int expt(int n, int k)
	{
		int value = n;
		if (k == 0) {
			return 1;
		}
		else {
			for (int i=0; i < k - 1; i++){
				value = value * n;
			}
			return value;
		}

	}
}




