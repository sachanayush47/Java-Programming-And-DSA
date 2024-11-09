package concurrency;

public class Thread1 extends Thread {

	public Thread1(String threadname) {
		super(threadname);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; ++i) {
			System.out.println("Thread1::" + Thread.currentThread().getName() + "::" + i);
		}
	}
	
}
