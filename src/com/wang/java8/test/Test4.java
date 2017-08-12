package com.wang.java8.test;

import java.util.function.Function;

/**
 * 函数型接口示例
 * @author wang
 *
 */
public class Test4 {

	public static Integer convert(String str, Function<String, Integer> function) {
	    return function.apply(str);
	}
	
	public static void main(String[] args) {
	    Integer value = convert("28", x -> Integer.parseInt(x));
	    System.out.println(value);
	}
}
