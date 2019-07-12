package com.wanghao.collectionTest.hashCodeAndEqualsDemo;

public class Student {
	
	private int id;
    private String name;
    
    public Student(int id,String name) {
    	this.id = id;
        this.name = name;
        
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    @Override
    public String toString() {
        return "Student [id="+ id +"name=" + name + "]";
    }
    
    @Override
    public int hashCode(){
    	return id + name.hashCode();
    }
    
      
    public boolean equals(Object obj) {  
        if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        Student other = (Student) obj;  
        if (id != other.id)  
            return false;  
        if (name == null) {  
            if (other.name != null)  
                return false;  
        } else if (!name.equals(other.name))  
            return false;  
        return true;  
    }  
    
}
