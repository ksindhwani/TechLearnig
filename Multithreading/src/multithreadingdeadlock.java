import java.util.*;

public class multithreadingdeadlock implements Runnable {

	private static final Object LOCK_1 = new Object();
	private static final Object LOCK_2 = new Object();
	private final String name;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(LOCK_1) {
			System.out.println(name + "is holding LOCK1 and going for lock 2)");
			try {
				Thread.sleep(1000);
				synchronized(LOCK_2) {
					System.out.println(name + "acquired both locks");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Both Lock Released");
		
		synchronized(LOCK_2) {
			System.out.println(name + "is holding LOCK2 and going for lock 1)");
			try {
				Thread.sleep(1000);
				synchronized(LOCK_1) {
					System.out.println(name + "acquired both locks");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Both Lock Released");

	}
	
	multithreadingdeadlock(String name){
		this.name=name;
	}
	
	public static void main(String [] args) {
		System.out.println("Main thread");
		Thread t1 = new Thread(new multithreadingdeadlock("Orange"));
		System.out.println("Going to leave main thread");
		t1.start();
		System.out.println("Back to main thread");
		Thread t2 = new Thread(new multithreadingdeadlock("Apple"));
		t2.start();
	}
}
