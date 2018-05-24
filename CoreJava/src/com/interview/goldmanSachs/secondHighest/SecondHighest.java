package com.interview.goldmanSachs.secondHighest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SecondHighest {

	//For an list with no repeated elements, find the second largest number
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(4);
		list.add(5);
		list.add(7);
		list.add(10);
		int secondHighestNum = secondHighest0(list);
		System.out.println(secondHighestNum);
	}
	public static Integer secondHighest0(List<Integer> list){
		int MAX = Integer.MIN_VALUE;
		int MAX_2 = Integer.MIN_VALUE;
		if(list.size() < 2) {
			return null;
		}
		int i1 = list.get(1);
		int i2 = list.get(0);
		MAX = i1>i2 ? i1 : i2;
		MAX_2 = i1<i2 ? i1 : i2;
		for(int i=1; i<list.size(); i++) {
			int temp = list.get(i);
			if(temp > MAX) {
				MAX_2 = MAX;
				MAX = temp;
			}else if(temp > MAX_2 && temp < MAX) {
				MAX_2 = temp;
			}
		}
		
		return MAX_2;
	}
	public static Integer secondHighest1(List<Integer> list){
		int MAX = Integer.MIN_VALUE;
		int MAX_2 = Integer.MIN_VALUE;
		if(list.size() < 2) {
			return null;
		}
		Iterator<Integer> i = list.iterator();
		
		while(i.hasNext()) {
			Integer value = i.next();
			if(value > MAX) {
				MAX = value;
			}
		}
		System.out.println(MAX);
		Iterator<Integer> j = list.iterator();
		while(j.hasNext()) {
			Integer value = j.next();
			if(value > MAX_2 && value != MAX) {
				MAX_2 = value;
			}
		}
		return MAX_2;
	}

}
