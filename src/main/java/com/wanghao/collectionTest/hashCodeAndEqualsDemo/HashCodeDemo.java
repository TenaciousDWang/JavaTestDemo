package com.wanghao.collectionTest.hashCodeAndEqualsDemo;

import java.util.HashSet;
import java.util.Set;

public class HashCodeDemo {

	public static void main(String[] args) {
		
		Set<Student> hashSet = new HashSet<>();
		
		Student A = new Student(1,"zhang3");
		Student B = new Student(1,"zhang3");
		Student C = new Student(1,"zhang3");
		
		hashSet.add(A);
		hashSet.add(B);
		hashSet.add(C);

		System.out.println(hashSet.size());
		
	}

}
