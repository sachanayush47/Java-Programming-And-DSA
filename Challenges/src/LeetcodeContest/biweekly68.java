package LeetcodeContest;

import java.util.*;

public class biweekly68 {

	public static void main(String[] args) {
		
//		String arr[] = {"a"};
//		System.out.println(mostWordsFound(arr));
		
		System.out.println(canBeValid("((", "10"));
	}
	
	public static boolean canBeValid(String s, String locked) {
		
		if(s.length() % 2 == 1) return false;

		Stack<Character> st = new Stack<>();
		
		int i = 0;
		while(i < s.length()) {
			
			if(st.isEmpty()) {
				st.push(s.charAt(i));
				continue;
			}
			

			
			++i;
		}
		
	//	char c = st.pop();
		System.out.println("hello");
		
		return st.isEmpty();
	}
	
	public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients,
																String[] supplies) {
		
		Set<String> result = new HashSet<>();
		
		HashMap<String, Integer> rec = new HashMap<>();
		HashSet<String> sup = new HashSet<>();
		
		for(int i = 0; i < recipes.length; ++i) {
			rec.put(recipes[i], i);
		}
		
		for(int i = 0; i < supplies.length; ++i) {
			sup.add(supplies[i]);
		}
		
		for(int i = 0; i < recipes.length; ++i) {
			String recipe = recipes[i];
			List<String> ingredient = ingredients.get(rec.get(recipe));
			
			for(int j = 0; j < ingredient.size(); ++i) {
				boolean isExist = sup.contains(ingredient.get(j));
				
				if(isExist == false) {
					rec.containsKey(ingredient.get(j));
				}
			}
			
			
		}
		
		List<String> toList = new ArrayList<>();
		for(String i : result) {
			toList.add(i);
		}
		
        return toList;
    }
	
	public static int mostWordsFound(String sentences[]) {
		
		int result = 0;
		for(int i = 0; i < sentences.length; ++i) {
			String temp[] = sentences[i].split(" ");
			result = Math.max(result, temp.length);
		}
		
		return result;
	}

}
