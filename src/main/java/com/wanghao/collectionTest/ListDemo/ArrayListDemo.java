package com.wanghao.collectionTest.ListDemo;

import java.util.ArrayList;

public class ArrayListDemo {
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {		

		ArrayList arrayList1 = new ArrayList();
		arrayList1.add(new Object());
		arrayList1.add(new Integer(1));
		arrayList1.add(new String("a"));
		
		Object object1 = arrayList1.get(2);
		String string1 = (String) arrayList1.get(2);
		System.out.println(object1+"");
		System.out.println(string1+"");
		
		ArrayList<Object> arrayList2 = new ArrayList();
		arrayList2.add(new Object());
		arrayList2.add(new Integer(2));
		arrayList2.add(new String("a"));
		
		Object object2 = arrayList2.get(2);
		String string2 = (String) arrayList1.get(2);
		System.out.println(object2+"");
		System.out.println(string2+"");
		
		//ArrayList<Integer> arrayList3 = new ArrayList();
		//arrayList3 = arrayList1;
		//Integer index2 = arrayList3.get(2);
		//System.out.println(index2+"");
		
		//arrayList3.add(new Object());
		//arrayList3.add(new Integer(2));
		//arrayList3.add(new String("a"));
		
		ArrayList<?> arrayList4 = new ArrayList();
		//arrayList4.add(new Object());
		arrayList4 = arrayList1;
		
		arrayList4.remove(0);
		arrayList4.clear();
		
		//arrayList4.add(new Object());
		//arrayList4.add(new Integer(2));
		//arrayList4.add(new String("a"));
		
		Object object4 = arrayList4.get(2);
		String string4 = (String) arrayList4.get(2);
		System.out.println(object4+"");
		System.out.println(string4+"");
		
	}

}
