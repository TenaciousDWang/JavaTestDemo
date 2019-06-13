package com.wanghao.collectionTest;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SpliteratorTest {
	
	//迭代器需按原始顺序迭代元素
	public static final int ORDERED    = 0x00000010;

	//迭代器中的元素是没有重复
	public static final int DISTINCT   = 0x00000001;

	//迭代器是按照某种方式排序的顺序迭代元素
	public static final int SORTED     = 0x00000004;

	//迭代器迭代元素的个数是有界的
	public static final int SIZED      = 0x00000040;

	//迭代器迭代的元素值不为null
	public static final int NONNULL    = 0x00000100;

	//迭代器迭代的元素是不可改变的
	public static final int IMMUTABLE  = 0x00000400;

	//迭代器的数据源是线程安全的
	public static final int CONCURRENT = 0x00001000;

	//迭代器所有的子迭代器（直接的或者间接的），有序的
	public static final int SUBSIZED = 0x00004000;


	public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();

		list.add("apple");
		list.add("banana");
		list.add("strawberry");
		list.add("cherryBomb");
		list.add("watermelon");

        Spliterator<String> s = list.spliterator();

        Spliterator<String> s1 = s.trySplit();

        Spliterator<String> s2 = s.trySplit();

        System.out.println("s.consume :");
        //非lambda传统写法
        s.forEachRemaining(new Consumer<String>() {
            public void accept(String str) {
                System.out.println(str);
            }
        });

        System.out.println("s1.consume");
        s1.forEachRemaining(fruit->System.out.println(fruit+" "));

        System.out.println("s2.consume");
        s2.forEachRemaining(fruit->System.out.println(fruit+" "));

	}

}
