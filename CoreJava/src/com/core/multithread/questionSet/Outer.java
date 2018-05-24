package com.core.multithread.questionSet;

 class Outer<String> {
	class Inner{
		
	}

}
 
 class SubClass extends Outer.Inner{

	SubClass(Outer outer) {
		outer.super();
		// TODO Auto-generated constructor stub
	}
	 
 }
