package C15;

public class MyRunnable implements Runnable{
	
	public void run() {
		go();
	}
	
	public void go() {
		doMore();
	}
	
	public void doMore() {
		System.out.println("top of the stack");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		
		myThread.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("back in main");
	}
	

}
