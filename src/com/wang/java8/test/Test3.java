package com.wang.java8.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 供给型接口示例
 * @author wang
 *
 */
public class Test3 {

	public static List<Integer> supply(Integer num, Supplier<Integer> supplier){
		List<Integer> resultList = new ArrayList<Integer>()   ;
		for(int x=0;x<num;x++)  
			resultList.add(supplier.get());
		return resultList ;
	}
	public static void main(String[] args) {
	    List<Integer> list = supply(10,() -> (int)(Math.random()*100));
	    list.forEach(System.out::println);
	}
}
