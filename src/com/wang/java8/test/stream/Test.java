package com.wang.java8.test.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws Exception {
		Property p1 = new Property("叫了个鸡", 1000, 500, 2);
		Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
		Property p3 = new Property("永和大王", 580, 3000, 1);
		Property p4 = new Property("肯德基", 6000, 200, 4);
		List<Property> properties = Arrays.asList(p1, p2, p3, p4);
		
		Collections.sort(properties, (x, y) -> x.distance.compareTo(y.distance));
		String name = properties.get(0).name;
		System.out.println("距离我最近的店铺是:" + name);
		
		// Stream操作
		String name2 = properties.stream()
		                .sorted(Comparator.comparingInt(x -> x.distance))
		                .findFirst()
		                .get().name;
		System.out.println("距离我最近的店铺是:" + name2);
		
		long count2 = properties.stream()
                .filter(p -> p.sales > 1000)
                .count();
		System.out.println(count2);
		
		/*String content = Files.readAllLines(Paths.get("test.txt")).stream()
	            .collect(Collectors.joining("\n"));
		System.out.println(content);*/
		
		//筛选出距离我在1000米内的店铺
		properties.stream().filter(p -> p.distance < 1000).forEach(x -> {
			System.out.println( "距离我在1000米内的店铺: " + x.name);
		});;
		
		//筛选出名称大于5个字的店铺
		properties.stream().filter(p -> p.name.length() > 5).forEach( x -> {
			System.out.println( "名称大于5个字的店铺: " + x.name);
		});;

		//所有店铺的名称
		properties.stream().map(p -> p.name).forEach( x -> {
			System.out.println( "所有店铺的名称: " + x);
		});;
		
		List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));

        //获取这些数据中长度大于2的单词个数
        long count3 = lists.stream()
	        .flatMap(Collection::stream)
	        .filter(str -> str.length() > 2)
	        .count();
        System.out.println("数据中长度大于2的单词个数: " + count3);
        
        //筛选出价格最低的店铺
        Property property = properties.stream()
            .max(Comparator.comparingInt(p -> p.priceLevel))
            .get();
        System.out.println("价格最低的店铺: " + property.getName());
        
        //获取距离我最近的2个店铺
        List<Property> properties2 = properties.stream()
        	.sorted(Comparator.comparingInt(x -> x.distance))
            .limit(2)
            .collect(Collectors.toList());

        //获取所有店铺的名称
        List<String> names = properties.stream()
                .map(p -> p.name)
                .collect(Collectors.toList());
        
        //获取每个店铺的价格等级
        Map<String, Integer> map = properties.stream()
                .collect(Collectors.toMap(Property::getName, Property::getPriceLevel));
        
        //所有价格等级的店铺列表
        Map<Integer, List<Property>> priceMap = properties.stream()
                .collect(Collectors.groupingBy(Property::getPriceLevel));

        //串行化计算:筛选出价格等级小于4，按照距离排序的2个店铺名
        List<String> names2 = properties.stream()
	        .filter(p -> p.priceLevel < 4)
	        .sorted(Comparator.comparingInt(Property::getDistance))
	        .map(Property::getName)
	        .limit(2)
	        .collect(Collectors.toList());
        
        //并行处理
        List<String> names3 = properties.parallelStream()
	        .filter(p -> p.priceLevel < 4)
	        .sorted(Comparator.comparingInt(Property::getDistance))
	        .map(Property::getName)
	        .limit(2)
	        .collect(Collectors.toList());

	}
}
