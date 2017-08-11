package com.wang.java8.test;

public class Test1 {

    public static void main( String[] args ){
        Runnable r = () -> System.out.println("do something");
        r.run();
    }
}
