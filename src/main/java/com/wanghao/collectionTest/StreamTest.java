package com.wanghao.collectionTest;

import java.util.stream.IntStream;

public class StreamTest {

	public static void main(String[] args) {

		IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
		IntStream.range(1, 5).forEach(System.out::println);
		IntStream.rangeClosed(1, 5).forEach(System.out::println);
	}

}
