import java.util.Scanner;

public class Chegg3 {

	public static void main(String[] args) {
		
		// Driver code.
		Coordinates xy = new Coordinates();		
		Coordinates temp = xy.fillCoordinates();		
		xy.getMinMaxY(temp);		
	}
}

class Coordinates {
	
	double x[] = new double[100];
	double y[] = new double[100];
	
	// In this variable we will store, total coordinates stores in an array.
	int actualLength;
	
	public Coordinates fillCoordinates() {
		Scanner sc = new Scanner(System.in);
		Coordinates xy = new Coordinates();
		
		int i = 0;
		
		while(i < 100) {
			System.out.println("Enter space separated  value of X and Y");
			// Example:		20.4 54.9
			
			double x = sc.nextDouble();
 			double y = sc.nextDouble();
 			
 			// If any of the value exceeds the given range, we will exit out of the loop.
 			if(-20 > x || x > 20 || -20 > y || y > 20) break;
 			
 			xy.x[i] = x;
 			xy.y[i] = y;
 					
 			++i;
		}
		sc.close();
		
		// Program exited.
		System.out.println("-------");
		
		xy.actualLength = i;
		return xy;
	}
	
	public void getMinMaxY(Coordinates xy) {
		
		int i = 0;
		double min = xy.y[0];
		double max = xy.y[0];
		
		// Loop the calulate MIN and MAX value of Y.
		while(i < xy.actualLength) {
			
			if(xy.y[i] > max) {
				max = xy.y[i];
			} else if(xy.y[i] < min) {
				min = xy.y[i];
			}
			
			++i;
		}
		
		System.out.println("Max: " + max + " Min: " + min);
		
	}
	
}



