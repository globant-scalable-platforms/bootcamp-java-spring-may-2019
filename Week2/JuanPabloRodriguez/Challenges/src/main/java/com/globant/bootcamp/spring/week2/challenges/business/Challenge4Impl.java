package com.globant.bootcamp.spring.week2.challenges.business;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globant.bootcamp.spring.week2.challenges.data.DataSource;
import com.globant.bootcamp.spring.week2.challenges.domain.Student;


@Service
public class Challenge4Impl implements Challenge4Filter {
	
	DataSource dataSource = new DataSource();	

	public List<Student> getStudents(){
		
		return DataSource.getStudents();
	
	}

	public List<Student> filterName(final String name){		
		List<Student> studentsByName = DataSource.getStudents().stream()
				.filter(s -> s.getName().equals(name))
				.collect(Collectors.toList());
		
		
		return studentsByName;
		
	}
	
    public List<Student> filterIdentification(final int identification){
		List<Student> studentsByIdentification = DataSource.getStudents().stream()
				.filter(s -> s.getIdentification() == identification)
				.collect(Collectors.toList());
		
		return studentsByIdentification;
    	
    }
    
    public List<Student> filterAge(final int age){
		List<Student> studentsByAge = DataSource.getStudents().stream()
				.filter(s -> s.getAge() == age)
				.collect(Collectors.toList());
		
		return studentsByAge;
    	
    }

}
