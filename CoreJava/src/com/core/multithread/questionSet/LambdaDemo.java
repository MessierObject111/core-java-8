package com.core.multithread.questionSet;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public class LambdaDemo{
	AtomicReference<Double> af = new AtomicReference<>(0d);
	
	class inner{}
	public static void change(String[] arr) {
		Set<Integer> set = new TreeSet<Integer>();
		
	}
	
	
    public static void main(String[]args){
        String s = "A";
        String[] arr = {"a", "b"};
        change(arr);
        for(int i = 0; i < arr.length; i++) {
        	System.out.println(arr[i]);
        }
        
        
        
        
    }
    public static void printMyName(String name){
        name = name + "Nelson";
        Runnable r = () -> {
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            //System.out.println("Welcome:" + name);
        };
        new Thread(r).start();
        System.out.println("Your name is : " + name);
        
    }   
}

