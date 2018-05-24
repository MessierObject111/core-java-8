package com.core.multithread.questionSet;

public class YieldExample {
	
	public class Producer extends Thread
	{
		@Override
		public void run() {
			for (int i = 0; i < 3; i++)
		      {
		         System.out.println("Producer : Produced Item " + i);
		         //Thread.yield();
		      }
		}
	}
	
	class Consumer extends Thread
	{
	   public void run()
	   {
	      for (int i = 0; i < 3; i++)
	      {
	         System.out.println("Consumer : Consumed Item " + i);
	         //Thread.yield();
	      }
	   }
	}
	
   public static void main(String[] args)
   {
	   YieldExample y = new YieldExample();
      Thread producer = y.new Producer();
      Thread consumer = y.new Consumer();
       
      producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
      consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority
       
      producer.start();
      consumer.start();
   }
   /*
    * Output of above program without yield:

Consumer : Consumed Item 0

Consumer : Consumed Item 1

Consumer : Consumed Item 2

Producer : Produced Item 0

Producer : Produced Item 1

Producer : Produced Item 2


Output of above program with yield:

Producer : Produced Item 0

Consumer : Consumed Item 0

Producer : Produced Item 1

Consumer : Consumed Item 1

Producer : Produced Item 2

Consumer : Consumed Item 2


*/
}
