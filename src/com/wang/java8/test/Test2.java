package com.wang.java8.test;

import java.util.function.Consumer;

/**
 * 消费型接口示例
 */
public class Test2 {

    public static void donation(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }
    public static void main(String[] args) {
    	//donation(1000, money -> System.out.println("好心的麦乐迪为Blade捐赠了"+money+"元")) ;

    	Consumer<Integer> c = (money) -> System.out.println("好心的麦乐迪为Blade捐赠了"+money+"元");
    	donation(1000, c);
    }
}
