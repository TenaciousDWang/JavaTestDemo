package com.wanghao.collectionTest.CompareDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
        List<Human> list = new ArrayList<Human>();
        
        list.add(new Human("li4", 19));
        list.add(new Human("zhang3", 18));
        list.add(new Human("wang5", 20));
        list.add(new Human("xiao7", 21));
        list.add(new Human("xiao6", 21));
        
        Collections.sort(list, new MyComparator());

        for (int i = 0; i < list.size(); i++) {
        	Human human = list.get(i);
            System.out.println(human);
        }

	}
	
}

