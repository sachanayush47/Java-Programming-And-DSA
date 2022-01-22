package greedy;

import java.util.*;

public class Greedy {

	public static void main(String[] args) {
		
//		Activity arr[] = new Activity[4];
//		
//		arr[0] = new Activity(3, 8);
//		arr[1] = new Activity(2, 4);
//		arr[2] = new Activity(1, 3);
//		arr[3] = new Activity(10, 11);

		Tri arr[] = new Tri[3];
		arr[0] = new Tri(50, 600);
		arr[1] = new Tri(20, 500);
		arr[2] = new Tri(30, 400);
		
		
		for(int i = 0; i < arr.length; ++i) {
			arr[i].print();
		}
		
		
	}
	
	public static int jobSequencingProblem(Job arr[]) {
		
		int profit = 0;
		Set<Integer> slot = new HashSet<>();
		
		// TODO: Method to sort the array by profit.
		
		for(int i = 0; i < arr.length; ++i) {
			boolean isAvail = slot.add(arr[i].deadline);
			if(isAvail) profit += arr[i].profit;
		}
		
		return profit;
	}
	
	public static int fractionalKnapsack(Tri arr[], int weight) {
		
		Arrays.sort(arr);
		int currWeight = weight;
		int result = 0;
		
		int i = 0;
		while(currWeight != 0) {
			
			if(arr[i].weight <= currWeight) {
				result += arr[i].value;
				currWeight -= arr[i].weight;
			} else {
				result += (arr[i].value/weight)/currWeight;
				break;
			}
		}
		
		return result;
	}
	
	/* ------------------------------------------------------------------ */
	
	public static int activitySelectionProblem1(Activity arr[]) {
		
		int res = 1;
		if(arr.length == 1) return res;
		
		sortActivity(arr);
		
		Activity prev = arr[0];
		for(int i = 1; i < arr.length; ++i) {
			if(prev.end <= arr[i].start) {
				++res;
				prev = arr[i];
			}
		}
		
		return res;
	}
	
	public static void sortActivity(Activity arr[]) {
	// Uses insertion sort.
		
		for(int i = 1; i < arr.length; ++i) {
			Activity key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j].end > key.end) {
				arr[j+1] = arr[j];
				--j;
			}
			arr[j+1] = key;
		}
	}
	
	/* ------------------------------------------------------------------ */
	
	class Job {
		int deadline;
		int profit;
		
		Job(int deadline, int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	
	static class Activity {
		int start;
		int end;
		
		Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		void print() {
			System.out.println(start + " " + end);
		}
	}
	
	static class Tri implements Comparable<Tri> {
		int weight;
		int value;
		double ratio;
		
		public Tri(int weight, int value) {
			this.weight = weight;
			this.value = value;
			ratio = value/weight;
		}
		
		public int compareTo(Tri i) {
			return weight*i.value - value*i.weight;
		}
		
		void print() {
			System.out.println(ratio);
		}
		
	}
}
