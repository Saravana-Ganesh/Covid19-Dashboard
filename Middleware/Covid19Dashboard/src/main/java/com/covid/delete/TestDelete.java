package com.covid.delete;

public class TestDelete {
	int i;
	static {
		System.out.println("Static block");
	}
	TestDelete(){
		System.out.println(i);
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		/*Student s1 = new Student(1,"saravana");
		Student s2 = (Student)s1.clone();
		System.out.println(s1==s2);	*/	
		new TestDelete();
	}

}
