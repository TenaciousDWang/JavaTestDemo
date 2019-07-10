package com.wanghao.collectionTest.CompareDemo;

public class Student implements Comparable<Student>{
	
    private String name;
    private int age;
    
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    @Override
    public int compareTo(Student o) {
    	
    	if(this.age != o.getAge()) {
    		return this.age > o.getAge() ? 1 : -1;
    	}
    	
    	if(!this.name.equals(o.getName())) {
    		return this.name.compareTo(o.getName());
    	}	
    	
    	return 0;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
	
}


