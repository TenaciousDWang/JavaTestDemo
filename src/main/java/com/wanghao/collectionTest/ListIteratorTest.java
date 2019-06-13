package com.wanghao.collectionTest;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("strawberry");
		list.add("cherryBomb");
		list.add("watermelon");
		System.out.println("原始：" + list);
		ListIterator<String> listIt = list.listIterator();
		while (listIt.hasNext()) {
			if ("watermelon".equals(listIt.next())) {
				listIt.set("pear");
				listIt.add("peach");				
			}
		}
		System.out.println("处理后：" + list);

	}

}
