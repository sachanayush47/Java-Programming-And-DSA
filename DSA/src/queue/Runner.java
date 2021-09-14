package queue;

public class Runner {

	public static void main(String[] args) throws Exception{
		
		MyQueueDS<Integer> myQ = new MyQueueDS<Integer>();
		
		myQ.add(10);
		myQ.add(20);
		myQ.add(30);
		myQ.add(40);
		
		System.out.println(myQ.element());
		System.out.println(myQ.pop());
		
	}

}
