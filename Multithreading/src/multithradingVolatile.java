import java.util.*;


class Worker implements Runnable{

	private boolean flag=false;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Worker Running");
		}
		
	}
	
}

public class multithradingVolatile {
	
	public static void main(String[] args) throws InterruptedException {
		Worker worker = new Worker();
		Thread t1 = new Thread(worker);
		
		t1.start();
		
		Thread.sleep(3000);
		worker.setFlag(true);
		t1.join();
		System.out.println("Finished");
		
	}
	
}
