package miscellaneous;

public class Pattern {

	public static void main(String[] args) {
		
		pat1(8, 8);

	}
	
	static void pat1(int x, int y) {
	// X = Y, for correct pattern
	    if(x == 0) return;
	    for(int i = y; i > x; --i) {
		    System.out.print(i +" ");
		}
		for(int i = 0; i < x*2-1; ++i) {
		    System.out.print(x +" ");
		}
		for(int i = x+1; i <= y; ++i) {
		    System.out.print(i +" ");
		}
	    System.out.println();
		pat1(x-1, y);
	    if(x != 1) {
	    	for(int i = y; i > x; --i) {
			    System.out.print(i +" ");
			}
			for(int i = 0; i < x*2-1; ++i) {
			    System.out.print(x +" ");
			}
			for(int i = x+1; i <= y; ++i) {
			    System.out.print(i +" ");
			}
			System.out.println();
	    }
	}

}
