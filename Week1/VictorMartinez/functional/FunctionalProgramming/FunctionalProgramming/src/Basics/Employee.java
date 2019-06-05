package Basics;

public class Employee {
	private String name;
	private int age;
	
	public Employee() {
	this.name = "abcd";
	this.age = 99;
		
	}
	public Employee(String n, int a) {
		this.name = n;
		this.age = a;
	}
	public String getName() {return this.name;}
	public int getAge() {return this.age;}
	public String toString() {return "Name : " +name+" - Age :"+this.age;}
}
