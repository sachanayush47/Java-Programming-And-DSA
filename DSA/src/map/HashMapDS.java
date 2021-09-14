package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapDS {

	public static void main(String[] args) {
		
	/**	In java, elements of map are stored in key/value pairs.
	 * 	Keys are unique values associated with individual values.
	 * 	A map cannot duplicate keys, and each keu is asscociated with a singal value.
	 * 	We can access and modify values using the keys associated with them. 
	 * 
	 * 	Map Implementation 
	 *	Since Map is an interface, we cannot create objects from it.
	 *	In order to use functionalities of the Map interface, we can use these classes:
	 *	• HashMap Map
	 *	• EnumMap Implements
	 *	• LinkedHashMap
	 *	• WeakHashMap kashMap
	 *	• TreeMap: The map is sorted according to the natural ordering of its keys.
	 *
	 *	METHODS:
	 * 	• put(K, V)  							Inserts the association of a key K and a value V into the map.
					  							If the key is already present, the new value replaces the old value.
	 * 	• putAll()  							Inserts all the entries from the specified map to this map.
	 *  • putlfAbsent(K, V)  					Inserts the association if the key K is not already associated with the value V.
	 *  • get(K) 								Returns the value associated with the specified key K.
	   											If the key is not found, it returns null.
	 *  • getOrDefault(K, default Value)  		Returns the value associated with the specified key K.
	   								   			If the key is not found, it returns the defaultValue.
	 *  • containsKey(K)  						Checks if the specified key K is present in the map or not.
	 *  • containsValue(V)  					Checks if the specified value V is present in the map or not.
	 *  • replace(K, V)  						Replace the value of the key K with the new specified value V.
	 *  • replace(K, oldValue, newValue) 		Replaces the value of the key K with the new value only.
	   											if the key K is associated with the value oldValue.
	 *	• remove(K) 							Removes the entry from the map represented by the key K.
	 *	• remove(K, V) 							Removes the entry from the map that has key K associated with value V.
	 *	• keySet() 								Returns a set of all the keys present in a map.
	 *	• values() 								Returns a set of all the values present in a map.
	 *	• entrySet() 							Returns a set of all the key/value mapping present in a map.
	 */
	
	// All the above operations happens in O(1) time complxity in HashMap.	
		
		
		Map<String, Integer> numbers = new HashMap<>();
		
		numbers.put("One", 1);
		numbers.put("Two", 2);
			
		numbers.put("One", 10);
		System.out.println(numbers.entrySet());
		
	/**	INTERNAL WORKING OF HASHMAP:
	 * 	HashMap uses an array table to store its key value pair.
	 * 	Each element of the array holds the head of a LinkedList to avoid collision.
	 * 	The hash of every key is calculated and the elements are placed in the array
	 * 	using this hash function
	 * 	The dafault capacity is kept at 16 and load factor is 0.75.
	 */
			
		Set<Entry<String, Integer>> entries = numbers.entrySet();			
		for(Entry<String, Integer> entry: entries) {
			entry.setValue(entry.getValue() * 100);
		}			
		System.out.println(numbers);
		
		System.out.println(getHash("DOG"));
	}
			
	public static int getHash(String s) {
		int hash = 0;
		for(int i = 0; i<s.length(); i++) {
			hash += s.charAt(i);
		}
		return hash;

	}

}
