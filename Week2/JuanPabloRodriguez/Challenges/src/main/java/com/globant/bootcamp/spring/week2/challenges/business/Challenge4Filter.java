package com.globant.bootcamp.spring.week2.challenges.business;


import java.util.List;


import com.globant.bootcamp.spring.week2.challenges.domain.Student;

public interface Challenge4Filter {
	
	public List<Student> getStudents();
	public List<Student> filterName(final String name);
    public List<Student> filterIdentification(final int identification);
    public List<Student> filterAge(final int age);

}
