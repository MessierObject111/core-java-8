package com.core.multithread.questionSet;

public class Runner implements Runnable {

	int x = 0;
	@Override
	public void run() {
		int current = 0;
		for(int i=0; i<3;i++) {
			current = x;
			System.out.print(current + " ");
			x = current + 1;
		}

	}

}
