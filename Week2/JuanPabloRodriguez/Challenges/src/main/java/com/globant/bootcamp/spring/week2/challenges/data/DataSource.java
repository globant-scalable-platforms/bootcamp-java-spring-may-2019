package com.globant.bootcamp.spring.week2.challenges.data;

import java.util.ArrayList;
import java.util.List;

import com.globant.bootcamp.spring.week2.challenges.domain.Student;


public class DataSource {
	
	private static List<Student> students;

	public DataSource() {

		students = new ArrayList<>();
		
		students.add(new Student("Juan", 1, 20));
		students.add(new Student("Pablo", 2, 20));
		students.add(new Student("Ana", 3, 30));
		students.add(new Student("Gabriel", 4, 30));
		students.add(new Student("Maria", 5, 40));


	}

	public static List<Student> getStudents() {
		return students;
	}
	
}
