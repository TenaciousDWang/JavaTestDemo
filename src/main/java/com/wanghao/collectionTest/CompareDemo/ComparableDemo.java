package com.wanghao.collectionTest.CompareDemo;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableDemo {

	public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<Student>();
        
        set.add(new Student("li4", 19));
        set.add(new Student("zhang3", 18));
        set.add(new Student("wang5", 20));
        set.add(new Student("xiao7", 21));
        set.add(new Student("xiao6", 21));
        
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
        	Student student = iterator.next();
            System.out.println(student);
        }

	}

}
