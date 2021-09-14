package set;

import java.util.HashSet;

public class SetDS {

	public static void main(String[] args) {
		
	/**	Set: 
	 * 	The set interface of the java collection framework provide the features of the
	 *  mathematical sets in java. It extends the collection interface.
	 *  Unlike the List interface, sets cannot contain duplicate elements.
	 * 		
	 * 	In order to use set inteface functionalities, we can use these classes.
	 * 		1. Hashset				Order doesn't matter. Constant time.
	 * 		2. LinkedHashSet		Uses LinkedList, Order matters. Not Constant time.
	 * 		3. Enumset
	 * 		4. TreeSet				Sorted output.
	 * 
	 * 	Methods:
	 * 		add(element)						Adds elements also returns boolean 
	 * 		addAll(collection)					Union
	 * 		remove(element)
	 * 		removeAll(collection)
	 * 		retainAll(collection)				Intersection
	 * 		clear()
	 * 		size()
	 * 		contains()																				boolean
	 * 		containsAll(collection)				Subset												boolean
	 * 		isEmpty()																				boolean
	 * 		toArray() 			
	 */
		
	// All the above operations happens in O(1) time complxity in HashSet by using HashMap.
		HashSet<String> hSet = new HashSet<>();
		hSet.add("Ayush");
		
	}

}
