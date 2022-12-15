package miscellaneous;

public class ExceptionHandling {

	public static void main(String[] args) {

		try {
			int i = 18;
			if(i < 19) throw new Handler("kya kar raha hai chutiye");
		} catch(Handler e) {
			e.printStackTrace();
			System.out.println("try againg");
		}
		
		System.out.println("exit");
		
	}

}

@SuppressWarnings("serial")
class Handler extends Exception {
	
	public Handler(String msg) {
		super(msg);
	}
	
}
