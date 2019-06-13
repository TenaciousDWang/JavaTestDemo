package com.wanghao.collectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.wanghao.collectionTest.entity.Fruit;

public class FruitTest {

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
		
		ArrayList<Fruit> fruitTransactions = new ArrayList<Fruit>();
		for(Fruit fruit : fruitList) {
			if("big".equals(fruit.getType())) {
				fruitTransactions.add(fruit);
			}
		}
		Collections.sort(fruitTransactions, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit A, Fruit B) {
				if(A.getPrice() != B.getPrice()) {
					return A.getPrice()<B.getPrice()?1:-1;
				}
				return 0;
			}		
		});
		ArrayList<String> transactionIds = new ArrayList<String>();
		for(Fruit fruit: fruitTransactions){
			 transactionIds.add(fruit.getId());
		}
		
		System.out.println(transactionIds);
	
	}

}
