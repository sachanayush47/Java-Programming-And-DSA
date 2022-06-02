package SheetSDE;

import java.util.*;

public class Day8 {

	public static void main(String[] args) {

	}
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
	/* ------------------------------------------------------------------ */
	
								// N meetings in one room
	
	public static int maxMeetings(int start[], int end[], int n) {
		
		Pair arr[] = new Pair[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = new Pair(start[i], end[i]);
		}
		
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2) {
                return p1.y - p2.y; 
            }
        });
        
        int endingTime = 0;
        int res = 0;
        for(int i = 0; i < n; ++i) {
        	if(arr[i].y > endingTime) {
        		endingTime = arr[i].y;
        		++res;
        	}
        }
        
		return res;
	}
}

class Pair {
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}