package miscellaneous.comparablesAndComparators;

import java.util.*;

public class ComparablesAndComparators {

	public static void main(String[] args) {

		/**
		 * Comparable Interface: This interface imposes a total ordering on he objects
		 * of each class that implements it. This ordering is referred to as the
		 * class's natural ordering and the class's compareTo method is referred to as
		 * its natural comparison method. List(and arrays) of objects that implement
		 * this interface can be sorted automatically by Collections.sort(and
		 * Arrays.sort). Objects that implement this interface can be used as keys in a
		 * sorted map or as elements in a sorted set, without the need to specify a
		 * comparator.
		 * 
		 * public interface Comparable<T> { public int compareTo(T o); }
		 */

		/**
		 * Compare Interface: A comparison function which imposes a total ordering on
		 * some collection of objects. Comparators can be passed to a sort method (such
		 * as Collections.sort or Arrays.sort) to allow precise control over the sort
		 * order. Comparators can also be used to control the order of certain data
		 * structures (such as sorted sets or sorted maps) or to provide an ordering for
		 * collections of objects that don't have a natural ordering.
		 * 
		 * public interface Comparator<T> { int compare(T o1, T o2); }
		 */

//		Templates

//		1. Sort an 2D array of nX2 in ascending order by index 0.
		int n = 10;
		int arr[][] = new int[n][2];
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

//		2. Min heap of ListNode
		PriorityQueue<ListNode> q = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
		
//		3. Priority Queue(Min) based on 2D array of index 2
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
