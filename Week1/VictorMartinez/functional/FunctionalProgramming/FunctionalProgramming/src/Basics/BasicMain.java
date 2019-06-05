package Basics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Basics.BasicFunctions.*;
public class BasicMain {
	
	
	public static void main(String [] args) {
		
		ArrayList<Employee> eList = BasicFunctions.generateEmployees(BasicFunctions.NUMEMPLOYEES);
		BasicFunctions.printEmployees(eList);
		System.out.println("");
		Collections.sort(eList, (e1,e2)->(e1.getName().compareTo(e2.getName())));
		
		///// Sorting Employees
		BasicFunctions.printEmployees(eList);
		System.out.println(" ");
		///////Filtering Employees by age
		
		BasicFunctions.filteByAge(eList, BasicFunctions.isYoungerThan50()).forEach(System.out::println);
		System.out.println(" ");
		////// Filtering making use of Stream Thing
		eList.stream().filter(employee ->{
			return employee.getAge()<50;
		}).collect(Collectors.toList()).forEach(System.out::println);

		
	}
	
}
