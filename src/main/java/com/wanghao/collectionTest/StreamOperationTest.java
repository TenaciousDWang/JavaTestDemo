package com.wanghao.collectionTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wanghao.collectionTest.entity.Fruit;

public class StreamOperationTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		String[] strArray = new String[] { "a", "b", "c" };
		List<String> wordList = Arrays.asList(strArray);
		//转换大小写
		List<String> output = wordList.stream().
				map(String::toUpperCase).
				collect(Collectors.toList());
		//System.out.println(output);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数，distinct为去重操作
		List<Integer> squaresList = numbers.stream().
				map( i -> i*i).distinct().
				collect(Collectors.toList());
		//System.out.println(squaresList);
		
		Stream<List<Integer>> inputStream = Stream.of(
				 Arrays.asList(1),
				 Arrays.asList(2, 3),
				 Arrays.asList(4, 5, 6)
				 );
				List<Integer> outputStream = inputStream.
				flatMap((childList) -> childList.stream()).
				collect(Collectors.toList());
		//System.out.println(outputStream);
		
		Integer[] sixNums = {1, 2, 3, 4, 5, 6};
		List<Integer> evens =
		Stream.of(sixNums).filter(n -> n%2 == 0).collect(Collectors.toList());
		//System.out.println(evens);
		
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		// 过滤空字符串
		List<String> notNullStrings = strings.stream().
				filter(string -> !string.isEmpty()).
				collect(Collectors.toList());
		//System.out.println(notNullStrings);
		
		
		
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
		//获取type类型为big的水果名称并打印
		fruitList.stream()
		 .filter(f -> f.getType().equals("big"))
		 //.forEach(f -> System.out.println(f.getName()));
		 .peek(f -> System.out.println(f.getName()))
		 .peek(f -> {
			 String UpperString = f.getName().toUpperCase();
			 f.setName(UpperString);
			 })
		 .peek(f -> System.out.println(f.getName()));
		 //.collect(Collectors.toList());
		
		
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min); 
		// 求和，sumValue = 10, 有起始值
		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		// 求和，sumValue = 10, 无起始值
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a", "B", "c", "D", "e", "F").
		 filter(x -> x.compareTo("Z") > 0).
		 reduce("", String::concat);
		
/*		ArrayList<Fruit> fruitList1 = new ArrayList<Fruit>();		
		Fruit fruitA1 = new Fruit("2","pear","small",11);
		Fruit fruitB1 = new Fruit("1","apple","big",15);
		Fruit fruitC1= new Fruit("3","banana","small",4);
		Fruit fruitD1 = new Fruit("4","cherryBomb","big",10);
		Fruit fruitE1 = new Fruit("5","watermolen","big",22);	
		fruitList1.add(fruitA1);
		fruitList1.add(fruitB1);
		fruitList1.add(fruitC1);
		fruitList1.add(fruitD1);
		fruitList1.add(fruitE1);
		List<String> fruits = fruitList1.stream()
				.map(Fruit::getName)
				.limit(3)
				.skip(1)
				.collect(Collectors.toList());
		System.out.println(fruits);*/
		
/*		ArrayList<Fruit> fruitList1 = new ArrayList<Fruit>();		
		Fruit fruitA1 = new Fruit("2","pear","small",11);
		Fruit fruitB1 = new Fruit("1","apple","big",15);
		Fruit fruitC1= new Fruit("3","banana","small",4);
		Fruit fruitD1 = new Fruit("4","cherryBomb","big",10);
		Fruit fruitE1 = new Fruit("5","watermolen","big",22);	
		fruitList1.add(fruitA1);
		fruitList1.add(fruitB1);
		fruitList1.add(fruitC1);
		fruitList1.add(fruitD1);
		fruitList1.add(fruitE1);
		List<String> fruits = fruitList1.stream()				
				.sorted((A,B)->
					Integer.parseInt(A.getId()) > Integer.parseInt(B.getId()) ? 1 : -1
				)
				.map(f->f.getId()+":"+f.getName())
				.collect(Collectors.toList());*/
		//System.out.println(fruits);
		
		
		int longest = 0;
		BufferedReader br = null;
		try {
		br = new BufferedReader(new FileReader("c:\\code\\test.txt"));
		longest = br.lines().
		mapToInt(String::length).
		max().
		getAsInt();		
		br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
		//System.out.println(longest);
		
		
		ArrayList<Fruit> fruitList1 = new ArrayList<Fruit>();		
		Fruit fruitA1 = new Fruit("2","pear","small",11);
		Fruit fruitB1 = new Fruit("1","apple","big",15);
		Fruit fruitC1= new Fruit("3","banana","small",4);
		Fruit fruitD1 = new Fruit("4","cherryBomb","big",10);
		Fruit fruitE1 = new Fruit("5","watermolen","big",22);	
		fruitList1.add(fruitA1);
		fruitList1.add(fruitB1);
		fruitList1.add(fruitC1);
		fruitList1.add(fruitD1);
		fruitList1.add(fruitE1);
		boolean isBigFruit = fruitList1.stream().
				 allMatch(p -> p.getType().equals("big"));
		//System.out.println("全是大水果吗? " + isBigFruit);
				boolean isThereAnyInexpentiveFruit = fruitList1.stream().
				 anyMatch(p -> p.getPrice() < 10);
		//System.out.println("有便宜水果吗? " + isThereAnyInexpentiveFruit);
		
		//生成三个两位随机数
/*		Random seed = new Random();
		//Supplier<Integer> random = seed::nextInt;
		Supplier<Integer> random = ()->seed.nextInt() % 100;
		Stream.generate(random).limit(3).forEach(System.out::println);
		System.out.println();*/
		//另外一种方法直接使用IntStream
/*		IntStream.generate(() -> (seed.nextInt() % 100)).
		limit(3).forEach(System.out::println);*/
		
/*		Stream.generate(new FruitSupplier()).
		limit(5).
		forEach(f -> System.out.println(f.getName() + ":" + f.getPrice()));*/


		ArrayList<Fruit> fruitList2 = new ArrayList<Fruit>();		
		Fruit fruitA2 = new Fruit("2","pear","small",11);
		Fruit fruitB2 = new Fruit("1","apple","big",15);
		Fruit fruitC2= new Fruit("3","banana","small",4);
		Fruit fruitD2 = new Fruit("4","cherryBomb","big",10);
		Fruit fruitE2 = new Fruit("5","watermolen","big",22);	
		fruitList2.add(fruitA2);
		fruitList2.add(fruitB2);
		fruitList2.add(fruitC2);
		fruitList2.add(fruitD2);
		fruitList2.add(fruitE2);
		
/*		Map<String,List<Fruit>> fruitListGroupingBy = fruitList2
				.stream()
				.collect(Collectors.groupingBy(Fruit::getType));
		Iterator<Map.Entry<String, List<Fruit>>> it = fruitListGroupingBy.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, List<Fruit>> fruit = it.next();
			System.out.println("Type:"+fruit.getKey()+"="+fruit.getValue().size());
		}*/
		
		Map<Boolean, List<Fruit>> fruitListPartitioningBy = fruitList2
				.stream()
				.collect(Collectors.partitioningBy(f -> f.getPrice() < 10));
		System.out.println("便宜水果种类: " + fruitListPartitioningBy.get(true).size());
		System.out.println("昂贵水果种类: " + fruitListPartitioningBy.get(false).size());
	}
	
}

class FruitSupplier implements Supplier<Fruit> {
	private int index = 0;
	private Random random = new Random();
	@Override
	public Fruit get() {
		return new Fruit("" + index++, "Fruit" + index, "big", random.nextInt(100));
	}
}




