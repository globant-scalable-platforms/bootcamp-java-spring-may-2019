package com.bootcamp.springRest.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.bootcamp.springRest.controllerAdvice.InvalidDateRangeException;
import com.bootcamp.springRest.controllerAdvice.StudentNotFoundException;
import com.bootcamp.springRest.model.Student;

@Service
public class DataSourceImpl implements DataSource {
	
	private List<Student> list = new ArrayList<>();
	
	public DataSourceImpl () {
		list.add(new Student(1, 20, "Santiago", "Medina",0));
		list.add(new Student(2, 20, "Felipe", "Medina",1));
		list.add(new Student(3, 22, "Fernando", "Medina",1));
		list.add(new Student(4, 22, "Francia", "Tafurt",2));
		list.add(new Student(5, 30, "Camila", "Tafurt",-1));
		list.add(new Student(6, 31, "Leyda", "Murcia",-1));
		list.add(new Student(7, 35, "Marco", "Ortiz",-2));
		
	}

	@Override
	public List<Student> listStudents() {
		return list;
	}

	@Override
	public Student getStudentById(Integer id) throws StudentNotFoundException{
		Student student = list.stream()
				.filter(st -> st.getId().equals(id))
				.findFirst()
				.orElse(null);
		if(student == null) {
			String message = "Student not found with id " + id;
			throw new StudentNotFoundException(message);
		}
		return student;
		
	}

	@Override
	public List<Student> filterDate(LocalDate fromDate, LocalDate toDate) throws InvalidDateRangeException {
		if(fromDate.isBefore(toDate)) {
			return list.stream().filter(st -> 
			((st.getDate().isEqual(fromDate)) || (st.getDate().isAfter(fromDate)))
			&& ((st.getDate().isEqual(toDate)) || (st.getDate().isBefore(toDate)))
			).collect(Collectors.toList());
		}else {
			String message = "parameter 'to' must be greater than parameter 'from' ";
			throw new InvalidDateRangeException(message);
		}
		
	}

	@Override
	public List<Student> filterByName(String name) {
		return list.stream()
				.filter(st -> st.getName().equals(name))
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> filterByAge(Integer age) {
		return list.stream()
				.filter(st -> st.getAge().equals(age))
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> filterByNameAndAge(String name, Integer age) {
		return list.stream()
				.filter(st -> (st.getAge().equals(age)) && (st.getName().equals(name)))
				.collect(Collectors.toList());
	}



}
