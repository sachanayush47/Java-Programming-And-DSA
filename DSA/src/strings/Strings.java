package strings;

public class Strings {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	// Strings in java are objects that are backed by a char array.
	// Strings are immutable(non changable from the memory) and are non-primitive data type.
		
		// Stored in only "String pool area".
		String fName = "Ayush";
		
		// Stored in "String pool are" and "heap are".
		String lName = new String("Sachan");
		
						
	/** Functions in String:
	 * 		char		var.charAt(int index);
	 * 		int			var.length();
	 * 		String		var.substring(int beginIndex);
	 * 		String		var.substring(int beginIndex, int endIndex);	  	endIndex do not involve
	 * 		boolean		var.contains(CharSequence);
	 * 		boolean		var.equals(Another var);
	 * 		boolean 	var.isEmpty();
	 * 		String 		var.concat(String);
	 * 		String 		var.replace(char old, char new);
	 * 		String 		var.replaceAll(String regrex, String new);
	 * 		String 		var.replaceFirst(String regrex, String new);
	 * 		String[] 	var.split(String regex);
	 * 		int			var.indexOf(ch);
	 * 		String		var.toLowerCase();
	 * 		String		var.toUpperCase();
	 * 		String		var.trim();
	 * 		char[]		var.toCharArray();
	 * 		boolean  	Character.isLetter(Char c);
	 */
		
		
		
	// Method to convert char to string.
		String str1 = "Ayush Sachan";
		
		
		char ch = str1.charAt(7);					
		String str2 = String.valueOf(ch);
				
	// Converting a String into Integer.
		int number = Integer.parseInt("200");
		
		
		

	}
	
	public static void kadanesAlgorithms() {
		
	}

}


