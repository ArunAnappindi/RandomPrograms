package main.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest implements Runnable {

	static CountDownLatch latch = new CountDownLatch(1);
	
	public static void testSleep() throws InterruptedException {
		
		CountDownLatchTest test = new CountDownLatchTest();
		Thread newThread = new Thread(test);
		newThread.start();
		System.out.println("new Thread Started"+ Thread.currentThread().getName());
		
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		testSleep();
		if(latch.await(20, TimeUnit.SECONDS)) {
			latch = new CountDownLatch(1);
			System.out.println("countDown Done");
		}
		
		System.out.println("after await");
		System.out.println(latch.getCount());
		latch.countDown();
	}


	@Override
	public void run() {
		
		try {
			System.out.println("just before sleep" + Thread.currentThread().getName());
			latch.countDown();
			Thread.sleep(3000);
			System.out.println("just after sleep");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
