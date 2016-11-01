package lab8;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {



	final private LinkedList<Double> list;

	/**
	 * Constructs a Polynomial with no terms yet.
	 */
	public Polynomial() {
		//
		// Set the instance variable (list) to be a new linked list of Double type
		//

		this.list = new LinkedList<Double>();

	}
	/**
	 * Generates a string of the polynomial
	 */
	public String toString() {
		String polyString = "";
		for (int i=0; i < list.size(); i++){
			polyString +=  list.get(i) + "x^" + i;
		}
		return polyString;
	}

	/**
	 * 
	 * @param coeff takes in a coeffiicient
	 * @return adds a coefficient term
	 */
	public Polynomial addTerm(double coeff) {
		this.list.add(coeff);
		return this;
	}

	
	/**
	 * 
	 *
	 * @param x takes in the x value
	 * @param list2 generates a new list
	 * @return the evaluation of the list
	 */
	private double helper(double x, Iterator<Double> list2){
		//		if (listPos == this.list.size()){
		//			return (this.list.get(listPos) * Math.pow(x, listPos));
		//					
		//		}
		//		listPos++;
		//			return (this.list.get(listPos) * Math.pow(x, listPos)) + helper(x,listPos);
		if (list2.hasNext() == false){
			return 0;
		}
		else{
			return  list2.next() + x*helper(x, list2) ;
		}
	}

	/**
	 * 
	 * @param x takes in a value
	 * @return returns the polynomial evaluated at the x value
	 */
	public double evaluate(double x) {
//		if (this.list.isEmpty()){
//			return 0;
//		}
//		int listPos = 1;
		return helper(x, list.iterator());
	}

/**
 * 
 * @return the derivative of the polynomial
 */
	public Polynomial derivative() {
		Polynomial deriv = new Polynomial();

		if(this.list.isEmpty()){
			return deriv;
		}
		else{
			for (int i=1; i < this.list.size(); i++){
				deriv.list.add(this.list.get(i)*i);
			}
			return deriv;

		}


	}

	
	/**
	 * 
	 * @param another creates a new polynomial
	 * @return the sum of the 2 polynomial
	 */
	public Polynomial sum(Polynomial another) {
		if (this.list.size() > another.list.size()){
			Polynomial sumList = new Polynomial();
			
				for (int j=0; j < another.list.size(); j++){
					sumList.list.add(this.list.get(j) + another.list.get(j));
				}
				for (int i=another.list.size(); i < this.list.size(); i++){
				sumList.list.add(this.list.get(i));
			}
			return sumList;
		}
		else if (another.list.size() > this.list.size()){
			Polynomial sumList = new Polynomial();
				for (int j=0; j < this.list.size(); j++){
					sumList.list.add(this.list.get(j) + another.list.get(j));
				}
				for (int i = list.size(); i < another.list.size(); i++){
				sumList.list.add(another.list.get(i));
			}
			return sumList;
		}
		else{
			Polynomial sumList = new Polynomial();
			for (int i=0; i < this.list.size(); i++){
				sumList.list.add(this.list.get(i) + another.list.get(i));
			}
			return sumList;
		}

	}


	//public static void main(String[] args) {
	//}


	/**
	 * This is the "equals" method that is called by
	 *    assertEquals(...) from your JUnit test code.
	 *    It must be prepared to compare this Polynomial
	 *    with any other kind of Object (obj).  Eclipse
	 *    automatically generated the code for this method,
	 *    after I told it to use the contained list as the basis
	 *    of equality testing.  I have annotated the code to show
	 *    what is going on.
	 */

	public boolean equals(Object obj) {
		// If the two objects are exactly the same object,
		//    we are required to return true.  The == operator
		//    tests whether they are exactly the same object.
		if (this == obj)
			return true;
		// "this" object cannot be null (or we would have
		//    experienced a null-pointer exception by now), but
		//    obj can be null.  We are required to say the two
		//    objects are not the same if obj is null.
		if (obj == null)
			return false;

		//  The two objects must be Polynomials (or better) to
		//     allow meaningful comparison.
		if (!(obj instanceof Polynomial))
			return false;

		// View the obj reference now as the Polynomial we know
		//   it to be.  This works even if obj is a BetterPolynomial.
		Polynomial other = (Polynomial) obj;

		//
		// If we get here, we have two Polynomial objects,
		//   this and other,
		//   and neither is null.  Eclipse generated code
		//   to make sure that the Polynomial's list references
		//   are non-null, but we can prove they are not null
		//   because the constructor sets them to some object.
		//   I cleaned up that code to make this read better.


		// A LinkedList object is programmed to compare itself
		//   against any other LinkedList object by checking
		//   that the elements in each list agree.

		return this.list.equals(other.list);
	}

}
