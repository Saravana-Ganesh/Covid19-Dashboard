package com.covid.delete;

public class TestDelete {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Student s1 = new Student(1,"saravana");
		Student s2 = (Student)s1.clone();
		System.out.println(s1==s2);
	}

}
