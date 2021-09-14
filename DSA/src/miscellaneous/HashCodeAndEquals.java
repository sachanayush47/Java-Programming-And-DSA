package miscellaneous;

import java.util.HashSet;

public class HashCodeAndEquals {

	public static void main(String[] args) {
	
	/**	Hashcode and Equals
	 * 	hashCode() and equals() methods have been defined in Object class is parent class for
	 * 	java objects. For this reason, all the java objects inherit a default implementation of
	 * 	of these methods. 
	 * 	Java hashCode()														
	 * 	Object class defined hashCode() method like this:
	 * 		public int hashCode() {
	 * 	 		// Code
	 * 		}
	 * 	
	 * 	Java equals()
	 * 	Object class defined hashCode() method like this:
	 * 		public boolean equals(Object obj) {
	 * 	 		// Code
	 * 		}
	 * 
	 * 	The Contract
	 * 	The contract between hashCode() and equals():
	 * 		1. If two objects are equal,then they must have the same hash code.
	 * 		2. If two objects have the same hash code, they may or may not be equal.
	 * 	
	 * 	Best practices:
	 * 		1. Always use same attributes of an object to generate hashCode() and equals() both.
	 * 		2. equals() must be consistent (if the objects are not modified, then it must keep
	 * 		   returning the same value.
	 * 		3. Whenever a.equals(b) then a.hashCode() must be same as b.hashcode().
	 * 		4. If you override one, then you should override the other.
	 * 
	 */
		
		Pen p1 = new Pen(10, "blue");
		Pen p2 = new Pen(10, "blue");
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(p1.equals(p2));
		
		HashSet<Pen> pen = new HashSet<Pen>();
		pen.add(p1);
		pen.add(p2);
		System.out.println(pen);
	}

}

class Pen {
	int price;
	String color;
	
	public Pen(int price, String color) {
		this.price = price;
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pen that = (Pen)obj;
		boolean isEqual = this.price == that.price && this.color == that.color; 
		return isEqual;
	}
	
	@Override
	public int hashCode() {
		return price + color.hashCode();
	}

//	Source --> Generate hashCode() and equals()
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((color == null) ? 0 : color.hashCode());
//		result = prime * result + price;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Pen other = (Pen) obj;
//		if (color == null) {
//			if (other.color != null)
//				return false;
//		} else if (!color.equals(other.color))
//			return false;
//		if (price != other.price)
//			return false;
//		return true;
//	}	

}
