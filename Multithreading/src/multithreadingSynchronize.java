import java.util.*;

public class multithreadingSynchronize implements Runnable {
	
	private static int counter=0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=100;i++) {
			incrementCounter();
		}
	}
	
	private synchronized void incrementCounter() {
		// TODO Auto-generated method stub
		++counter;
		
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new multithreadingSynchronize());
		Thread t2 = new Thread(new multithreadingSynchronize());
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter);
	}
}
