package experiment;

import java.util.*;

public class weekly280 {

	public static void main(String[] args) {

		System.out.println(countLatticePoints(new int[][] {{2, 2, 2}, {3, 4, 1}}));
	
//		System.out.println(getDistance(4, 2, 2, 2, 2));
	
	}
	
	
	public static List<Integer> intersection(int[][] nums) {
        
		int n = nums[0].length;
		Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums[0].length; ++i) {
        	s.add(nums[0][i]);
        }
        
        for(int i = 1; i < nums.length; ++i) {
        	Set<Integer> temp = new HashSet<>();
        	for(int j = 0; j < n; ++j) {
        		temp.add(nums[i][j]);
        	}
        	
        	s.retainAll(temp);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i : s) {
        	res.add(i);
        }
        
        Collections.sort(res);
        return res;
    }
	
	public static int countLatticePoints(int[][] circles) {
        
		int res = 0;
		
		Set<List<Integer>> s = new HashSet<>();
		
		for(int i = 0; i < circles.length; ++i) {
			int x = circles[i][0];
			int y = circles[i][1];
			int r = circles[i][2];
			
			for(int j = y + r; j >= y - r; --j) {
				for(int k = x - r; k <= x + r; ++k) {
					boolean isPossible = getDistance(k, j, x, y, r);
					if(isPossible == true) {
						if(!s.contains(List.of(k, j))) {
							++res;
							s.add(List.of(k, j));
						}
					}
				}
			}
		}
		
		
		return res;
    }
	
	public static boolean getDistance(double xp, double yp, double xc, double yc, double r) {
		double d = Math.pow(xp - xc, 2) + Math.pow(yp - yc, 2);
	
		if(d <= r*r) {
			return true;
		}
		
		return false;
	}

}
