package concurrency;

public class ThreadTester {

	public static void main(String[] args) {

		// Thread: Independently executing code off from main execution sequence.
		// Threads within program share same memory space and are light weight on CPU.
		// Hence, context switching is easier.
		
		// A thread may or may not get executed immediately.
		// It depends on the main threads, if it feels to execute it,
		// it will ask JVM to execute it.
		// Execution order of thread is never defined. It all depends on JVM.
		
		// User Thread: A user thread is a regular thread created by the application.
		// Java’s main thread (the one that runs the main() method) is a user thread.
		//
		// Child Thread: A child thread is simply a thread spawned by another thread.
		// For example, if a user thread or a daemon thread creates another thread,
		// that newly created thread is called a child thread.
		// A child thread can be either a user or a daemon thread, depending on how it’s configured.
		//
		// Daemon Thread
		// A daemon thread is a background thread that provides services to user threads,
		// such as garbage collection.
		// JVM does not wait for daemon threads to complete when all user threads have finished;
		// exits immediately, killing all running daemon threads.
		//
		// There are 2 ways to create a thread:
		// 1. Implementing Runnable interface
		// 2. Extending Thread class
		//
		// Prefer using 1st method i.e Runnable interface because
		// We can implement multiple interface so if class wants to extend other
		// interface, we can do that. But on the other side, we can't extend multiple
		// classes in java. So we can't extend multiple class if a class wants to.
		
		
		System.out.println("Main start");
		
		// "thread1" is thread name and it is optional.
		// Thread t1 = new Thread1("thread1");
		// t1.setDaemon(false);	// Used to make a thread daemon, by default its false.
		// t1.start();
		
		
		// Thread t2 = new Thread(new Thread2(), "thread2"); // "thread2" is thread name and it is optional.
				// OR using lambda
		// Thread t2 = new Thread(() -> {
		//	for (int i = 0; i < 5; ++i) {
		//		System.out.println("Thread1::" + Thread.currentThread().getName() + "::" + i);
		//	}
		// }, "thread2");
		
		// t2.start();
		
		Stack stack = new Stack(5);
		
		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Pushed: " + stack.push(100));
			}
		}, "Pusher").start();
		
		new Thread(() -> {
			int counter = 0;
			while (++counter < 10) {
				System.out.println("Pushed: " + stack.pop());
			}
		}, "Popper").start();
		
		System.out.println("Main exit");
		
		
	}

}
