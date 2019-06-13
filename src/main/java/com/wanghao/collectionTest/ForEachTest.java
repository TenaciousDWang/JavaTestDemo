package com.wanghao.collectionTest;

import java.util.ArrayList;
import java.util.Iterator;

public class ForEachTest {

	public static void main(String[] args) {
		ArrayList<String>list=new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("strawberry");
		list.add("cherryBomb");
		list.add("watermelon");
		System.out.println("当前的list"+list);
		
		Iterator<String>it=list.iterator();
		//使用Iterator迭代器做法
/*		System.out.println("传统Iterator迭代器：");
		while(it.hasNext()) {
			String str = it.next();
			System.out.print(str+" ");
			if(str.equals("apple")) {
				it.remove();
			}		
		}*/
		System.out.println();
		
		System.out.println("使用Iterator的forEachRemaining方法第一次：");
		it.forEachRemaining(String->System.out.print(String+" "));
		System.out.println();
		
		System.out.println("使用Iterator的forEachRemaining方法第二次：");
		it.forEachRemaining(String->System.out.print(String+" "));
		System.out.println();
		
		System.out.println("直接使用顶级接口forEach方法：");
		list.forEach(System.out::println);

	}

}
