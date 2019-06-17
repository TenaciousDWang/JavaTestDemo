package com.wanghao.collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
@SuppressWarnings("unused")

public class CreateStreamTest {
	
	public static void main(String[] args) {
		// 1. 直接创建
		Stream<String> stream = Stream.of("a", "b", "c");
		// 2. 数组创建Stream
		String [] strArray = new String[] {"a", "b", "c"};
		stream = Stream.of(strArray);
		stream = Arrays.stream(strArray);
		// 3. 集合类方法创建
		List<String> list = Arrays.asList(strArray);
		stream = list.stream();

		IntStream.of(new int[]{1, 2, 3, 4, 5}).forEach(System.out::print);
		System.out.println();
		IntStream.range(1, 3).forEach(System.out::print);
		System.out.println();
		IntStream.rangeClosed(1, 3).forEach(System.out::print);
		

		// 1. Array
		Stream<String> stream1 = Stream.of("a", "b", "c");
		String[] strArray1 = stream1.toArray(String[]::new);
		
		// 2. Collection
		Stream<String> stream2 = Stream.of("a", "b", "c");		
		List<String> list1 = stream2.collect(Collectors.toList());
		
		Stream<String> stream3 = Stream.of("a", "b", "c");		
		List<String> list2 = stream3.collect(Collectors.toCollection(ArrayList::new));
		
		Stream<String> stream4 = Stream.of("a", "b", "c");		
		Set<String> set1 = stream4.collect(Collectors.toSet());
		
		Stream<String> stream5 = Stream.of("a", "b", "c");
		Stack<String> stack1 = stream5.collect(Collectors.toCollection(Stack::new));
		
		// 3. String（joining表示合并字符串）
		Stream<String> stream6 = Stream.of("a", "b", "c");
		String str = stream6.collect(Collectors.joining()).toString();

	}

}
