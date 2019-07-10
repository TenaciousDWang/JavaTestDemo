package com.wanghao.collectionTest.ListDemo;

import java.util.ArrayList;

import com.wanghao.collectionTest.entity.Animal;
import com.wanghao.collectionTest.entity.Dog;
import com.wanghao.collectionTest.entity.Huskie;

public class AnimalDogHuskie {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		ArrayList<Animal> animal = new ArrayList<Animal>();
		ArrayList<Dog> dog = new ArrayList<Dog>();
		ArrayList<Huskie> huskie = new ArrayList<Huskie>();
		
		animal.add(new Animal());
		dog.add(new Dog());
		huskie.add(new Huskie());		
		
		//ArrayList<? extends Dog> dogExtends = animal;
		ArrayList<? extends Dog> dogExtends = dog;
		//dogExtends = dog;
		dogExtends = huskie;
		
		ArrayList<? super Dog> dogSuper = animal;
		dogSuper = dog;
		//dogSuper = huskie;
		
		//dogExtends.add(new Animal());
		//dogExtends.add(new Dog());
		//dogExtends.add(new Huskie());
		
		//dogSuper.add(new Animal());
		dogSuper.add(new Dog());
		dogSuper.add(new Huskie());
		
		Object dog1 = dogExtends.get(0);
		Dog dog2= dogExtends.get(0);
		//Huskie dog3= dogExtends.get(2);
		
		Object dog4 = dogSuper.get(0);
		//Dog dog5= dogSuper.get(0);
		//Huskie dog6= dogSuper.get(2);
	}

}
