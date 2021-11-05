public class Chegg1 {

	public static void main(String[] args) {

		
		
		System.out.println(getAnagram("123456"));		// Output 3
		System.out.println(getAnagram("123122"));		// Output 1
		System.out.println(getAnagram("786678"));		// Output 0
		System.out.println(getAnagram("000100"));		// Output 1
		
		
	}
	
	
	public static int getAnagram(String s) {
		
		// This variable hold the total number of the operations.
		int totalOperations = 0;
		
		// First half of the string.
		String firstHalf = s.substring(0, s.length()/2);
		
		// Second half of the string.
		String secondHalf = s.substring(s.length()/2);
		
		
		// Iterating over the firstHalf and checking if the character at i index is present in secondHalf.
		for(int i = 0; i < firstHalf.length(); ++i) {
			
			// Converting character at i index to string.
			String charAtI = Character.toString(firstHalf.charAt(i));
			
			// If character is not prsent in secondHalf, then increment totalOperatios by 1
			if(!secondHalf.contains(charAtI)) {
				++totalOperations;
			} else {
				// If character is pesent in secondHalf, then delete that character from the secondHalf.
				secondHalf = secondHalf.replaceFirst(charAtI, "");				
			}
		}
		
		return totalOperations;
	}
	

	
	

}













// System.out.println("Length " + secondHalf.length() + " String " + secondHalf + " totalOperations " + totalOperations);