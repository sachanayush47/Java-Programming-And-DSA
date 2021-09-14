package stack;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		MyStackDS<Integer> myS = new MyStackDS<Integer>();
		
		myS.push(10);
		myS.push(10);
		myS.push(20);
		myS.push(30);
		myS.push(40);
		myS.push(60);
		myS.push(70);
		
		myS.print();

		System.out.println(myS.pop());
		System.out.println(myS.peek());

	}

}
