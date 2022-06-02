package Random;

public class Tool {

	public static void main(String[] args) {
		
		leetcodeCharMatrixToCode("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]");
		
	}
	
	public static void leetcodeCharMatrixToCode(String s) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); ++i) {
			switch (s.charAt(i)) {
			case '[':
				sb.append('{');
				break;
			case ']':
				sb.append('}');
				break;
			case 34:
				sb.append((char)39);
				break;
			default:
				sb.append(s.charAt(i));
			}
		}
		
		System.out.println(sb.toString());
	}

}
