import java.util.*;

class Runner11 implements Runnable
{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner 1" + i);;
		}
	}
	
}

class Runner21 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runner 2" + i);;
		}
		
	}
	
}


public class multithreadingJoin {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner11());
		Thread t2 = new Thread(new Runner21());
		
		t1.start();
		t2.start();
		
		try {
			t1.join(1000);
			t2.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished all the tasks");
	}
	
}
