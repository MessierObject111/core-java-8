package com.core.multithread.questionSet;

public class ParallelThreadsOverForLoop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runner r = new Runner();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		System.out.println("************");
		t1.start();
		t2.start();
		//Possible outputs:
		//0 0 1 2 1 2 
		//0 0 1 1 2 2 
		//0 1 2 0 1 2 
		//0 1 0 2 1 2 
		t1.sleep(1000);
		t2.sleep(1000);
		System.out.println("************");
		t1.run();
		t2.run();
		//run
		//0 1 2 3 4 5
		

	}

}
