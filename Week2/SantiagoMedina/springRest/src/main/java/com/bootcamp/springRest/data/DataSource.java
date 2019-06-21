package com.bootcamp.springRest.data;

import java.util.List;
import java.time.LocalDate;

import com.bootcamp.springRest.controllerAdvice.InvalidDateRangeException;
import com.bootcamp.springRest.controllerAdvice.StudentNotFoundException;
import com.bootcamp.springRest.model.Student;

public interface DataSource {
	
	List<Student> listStudents();
	Student getStudentById(Integer id) throws StudentNotFoundException;
	List<Student> filterDate(LocalDate fromDate, LocalDate toDate) throws InvalidDateRangeException;
	List<Student> filterByName(String name);
	List<Student> filterByAge(Integer age);
	List<Student> filterByNameAndAge(String name, Integer age);

}
