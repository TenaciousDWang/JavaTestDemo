package com.wanghao.collectionTest.CompareDemo;

import java.util.Comparator;

public class MyComparator implements Comparator<Human>{

	@Override
	public int compare(Human o1, Human o2) {
		
		if(o1.getAge() != o2.getAge()) {
			return o1.getAge() > o2.getAge() ? 1 : -1;
		}
		
		if(!o1.getName().equals(o2.getName())) {
			return o1.getName().compareTo(o2.getName());
		}
		
		return 0;
	}
	

}

