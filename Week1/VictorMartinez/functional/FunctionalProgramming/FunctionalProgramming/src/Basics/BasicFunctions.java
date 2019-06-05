package Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BasicFunctions {
	public static final int NAMELENGTH = 4;
	public static final int NUMEMPLOYEES=10;
	public static final int AGELIMIT=120;
	

	public static ArrayList<Employee> generateEmployees(int quantity) {
		ArrayList<Employee> eList = new ArrayList<Employee>();
		for (int i = 0; i < quantity; i++) {
			eList.add(new Employee(generateRandomString(NAMELENGTH), generateRandomNumber(AGELIMIT)));
		}
		return eList;
	}

	public static String generateRandomString(int length) {
		String name = "";
		char alphabet[] = {'a','b','c','d','e','f','g','h','i',
				    'j','k','l','m','n','o','p','q','r',
				    's','t','u','v','w','x','y','z'
					}; 
		for(int i =0; i<length;i++) {
			name+= alphabet[(int)Math.floor((Math.random()*alphabet.length))];
		}
		return name;
	}
	public static int generateRandomNumber(int limit) { return (int)(Math.floor(Math.random()*limit-1));}
	
	public static void printEmployee(Employee e) {
		System.out.println(e.toString());
	}
	public static void printEmployees(ArrayList<Employee> eList) {
		eList.forEach(e->{
			printEmployee(e);
		});
	}
	
	public static void sortingEmployeByAge(ArrayList<Employee> eList) {
		Collections.sort(eList, new Comparator<Employee>() {
			@Override
			public int compare(Employee arg0, Employee arg1) {
			
				if(arg0.getAge()<arg1.getAge()) {return -1;}else {return 1;}
				
			}
		});
	}
	
	public static void sortingEmployeByName(ArrayList<Employee> eList) {
		Collections.sort(eList, new Comparator<Employee>() {
			@Override
			public int compare(Employee arg0, Employee arg1) {
			
				return arg0.getName().compareTo(arg1.getName());				
			}
		});
	}
	
	public static void sortingEmployeByAgeAscendant(ArrayList<Employee> eList) {
		Collections.sort(eList,(e1,e2)->{ if(e1.getAge()<e2.getAge()) {return -1;}else { return 1;}});
	}
	
	public static void sortingEmployeByAgeDescendant(ArrayList<Employee> eList) {
		Collections.sort(eList,(e1,e2)->{ if(e1.getAge()<e2.getAge()) {return 1;}else { return -1;}});
	}
	
	public static Predicate<Employee> isYoungerThan50(){
		return employee-> employee.getAge()<50;
	}
	public static ArrayList<Employee> filteByAge(ArrayList<Employee> eList, Predicate<Employee> predicate) {
		return (ArrayList<Employee>)eList.stream().filter(predicate).collect(Collectors.toList());
		
	}
		
		
		
	}
		
	
	

