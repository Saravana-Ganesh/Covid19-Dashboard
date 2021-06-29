package com.covid.delete;

public class Student implements Cloneable{
	int id;
	String name;
	public Student(int id,String name){
		this.id = id;
		this.name = name;
	}
	public Student() {
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		Student s = (Student)obj;
		if(s.id==this.id)
			return true;
		return false;
	}
	@Override
	public String toString() {
		return this.id+"----"+this.name;
	}
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s);
	}
}
