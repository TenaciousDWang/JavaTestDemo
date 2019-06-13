package com.wanghao.collectionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.wanghao.collectionTest.entity.Fruit;

public class FruitNewTest {

	public static void main(String[] args) {
		ArrayList<Fruit> fruitList = new ArrayList<Fruit>();		
		Fruit fruitA = new Fruit("2","pear","small",11);
		Fruit fruitB = new Fruit("1","apple","big",15);
		Fruit fruitC = new Fruit("3","banana","small",4);
		Fruit fruitD = new Fruit("4","cherryBomb","big",10);
		Fruit fruitE = new Fruit("5","watermolen","big",22);	
		fruitList.add(fruitA);
		fruitList.add(fruitB);
		fruitList.add(fruitC);
		fruitList.add(fruitD);
		fruitList.add(fruitE);
		
		List<String> fruitIds = fruitList.parallelStream().
		filter(t -> t.getType().equals("big")).sorted((A, B) -> {
			if (A.getPrice() != B.getPrice()) {
				return A.getPrice() < B.getPrice() ? 1 : -1;
			} else {
				return 0;
			}
		}).map(Fruit::getId).collect(Collectors.toList());
		System.out.println(fruitIds);
	}

}
