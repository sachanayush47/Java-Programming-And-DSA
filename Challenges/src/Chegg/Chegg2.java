package Chegg;

public class Chegg2 {

	public static void main(String[] args) {

		MyNumber m = new MyNumber(11);
		
		System.out.println("Is odd: " + m.isOdd());
		
		System.out.println("Is equal: " + m.isEqual(10));
		
		System.out.println("Get minimum: " + m.min(19));
		
	}
}

interface NumTools {
	public boolean isOdd();
	public boolean isEqual(Integer x);
	public Integer min(Integer x);
}

class MyNumber implements NumTools {
	
	private Integer k;
	
	public MyNumber(Integer x) {
		k = x;
	}
	
	// Method to find if "k" is a odd number.
	public boolean isOdd() {
		if(k%2 == 1) return true;
		else return false;
	}
	
	// Method to find if "k" and "x" are same.
	public boolean isEqual(Integer x) {
		if(k == x) return true;
		else return false;
	}

	// Method to find minimum of "x" and "k"
	public Integer min(Integer x) {
		if(k < x) return k;
		else return x;
	}
}
