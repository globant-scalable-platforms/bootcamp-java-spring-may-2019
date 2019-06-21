package com.bootcamp.springRest.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.springRest.controllerAdvice.InvalidDateRangeException;
import com.bootcamp.springRest.data.DataSource;
import com.bootcamp.springRest.model.Average;
import com.bootcamp.springRest.model.Student;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private DataSource datasource;
	
	@GetMapping
	public List<Student> all(){
		return datasource.listStudents();
	}
	
	@GetMapping("/{id}")
    public Student get(@PathVariable("id") @NotNull  Integer id) throws Exception{
		return datasource.getStudentById(id);
    }
	
	@GetMapping("/filter")
	public List<Student> filterDate(	@RequestParam(value = "from", required=false) String fromD ,
							@RequestParam(value = "to", required=false) String toD,
							@RequestParam(value = "name", required=false) String name,
							@RequestParam(value = "age", required=false) Integer age) throws InvalidDateRangeException
	{
		if(fromD != null && toD != null) {
			LocalDate fromDate = LocalDate.parse(fromD);
			LocalDate toDate = LocalDate.parse(toD);
			return datasource.filterDate(fromDate, toDate);
		}else if (name != null && age == null) {
			return datasource.filterByName(name);
		}else if (name == null && age != null) {
			return datasource.filterByAge(age);
		}else if (name != null && age != null) {
			return datasource.filterByNameAndAge(name, age);
		}else {
			return datasource.listStudents();
		}
				
	}
	
	@GetMapping("/admin")
	public ResponseEntity<Student> headerValidation(@RequestHeader(name = "roles") String value){
		System.out.println(value);
		if(value.equals("admin")) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);	
		}
	}
	
	@GetMapping("/average/{numbers}")
	public ResponseEntity<?> average(@PathVariable("numbers") String stringNumbers){
		String[] numbers = stringNumbers.split(",");
		List<Integer> listNumbers = new ArrayList<>();
		for(String number : numbers) {
			listNumbers.add(Integer.parseInt(number));
		}
		
		Average average = new Average(listNumbers);
		
		return new ResponseEntity<>(average,HttpStatus.OK);
	}
	


}
