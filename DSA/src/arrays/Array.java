package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Array {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
	/** Arrays is DS i.e used to store mutiple values of same data type in a single variable.
	 * 	It is stored in continuous memory location.
	 * 	Initially, by default value stored in a array is 0
	 */			
		int arr[] = new int[10];
		int age[] = {22, 59, 4, 36, 12, 56};
		
	// Prints the length of array.
		System.out.println(age.length);				
				
		Arrays.sort(age);
		for(int i = 0; i<age.length; i++) {
			System.out.println(age[i]);
		}
		
	// Dynamic array: It is a part of Collections so all Collection method is applicable to it.
		List<Integer> lArray = new ArrayList<Integer>();
		
	/** Methods of ArrayList:
	 *		add(element)
	 *			add(Index, element)
	 *		addAll(Collection)
	 *		get(index)
	 *		set(index, value)
	 *		remove(index)						Removes the element present at given index and return it.
	 *		removeAll()
	 *		clear()
	 *		size()
	 *		contains()
	 *		isEmpty()
	 *		toArray()
	 *		Collections.reverse(collectionObj);								Reverse the collection.
	 *		Collections.sort(collectionObj);								Sorts the collection
	 *		Collections.sort(collectionObj, Collections.reverseOrder());	Reverse collection
	 *		Collections.max(collectionObj);
	 */
		
		
		lArray.add(10);
		lArray.add(20);
		lArray.add(30);
		lArray.add(40);
		lArray.add(50);
		lArray.add(60);
		
		lArray.set(5, 70);
		System.out.println(lArray);
		
	}

}
