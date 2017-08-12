package com.wang.java8.test.interfaceI;

public interface Test1 {

	default void test(){
		System.out.println("test");
	}
	
	void test2();
}
