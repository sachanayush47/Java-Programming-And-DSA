package miscellaneous.comparablesAndComparators;

public class ComparablesAndComparators {

	public static void main(String[] args) {
	
	/**	Comparable Interface:
	 * 	This interface imposes a total ordering on he objects of each class that implements it.
	 * 	This ordering is referrred to as the class's natural ordering and the class's
	 * 	compareTo method is referred to as its natural comparison method.
	 * 	List(and arrays) of objects that implement this iterface can be sorted automatically
	 * 	by Collections.sort(and Arrays.sort).
	 * 	Objects that implement this interface can be used as keys in a sorte map or as
	 * 	elements in a sorted set, without the need to specify a comparator.
	 * 	
	 * 		public interface Comparable<T> {
	 * 			public int compareTo(T o);
	 * 			}
	 */
		
	/**	Compare Interface:
	 * 	A comparison function which imposes a total ordering on some collection of objects.
	 * 	Comparators can be passed to a sort method (such as Collections.sort or Arrays.sort) to
	 * 	allow precise control over the sort order.
	 * 	Comparators can also be used to control the order of certain data structures
	 * 	(such as sorted sets or sorted maps) or to provide an ordering for collections of objects
	 * 	that dont have a natural ordering.
	 * 	
	 * 		public interface Comparator<T> {
	 * 			int compare(T o1, T o2);
	 *		}
	 */	
	
	}

}
