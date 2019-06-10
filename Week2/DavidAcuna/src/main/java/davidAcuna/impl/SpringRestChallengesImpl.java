package davidAcuna.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import davidAcuna.data.CustomAccountRepository;
import davidAcuna.domain.Account;
import davidAcuna.domain.NumberOperation;
import davidAcuna.domain.Student;

@Component
public class SpringRestChallengesImpl {
	
	@Autowired
	private CustomAccountRepository customAccountRepository;
	
	/**
	 * Compare two dates
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return true is toDate is greater than fromDate
	 */
	public Boolean after(Date fromDate, Date toDate) {
		return toDate.compareTo(fromDate) > 0;
	}
	
	/**
	 * Operate over the list of numbers
	 * 
	 * @param numbers
	 * @return POJO NumberOperation with average, count, max, min and sum of the numbers received
	 */
	public NumberOperation operateNumbers(List<Integer> numbers) {
		
		Integer sum = numbers.stream().mapToInt(Integer::intValue).sum();
		Long count = numbers.stream().mapToInt(Integer::intValue).count();
		Integer max = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
		Integer min = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
		Double avg = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
		
		return new NumberOperation(sum,count,max, min,avg);
	}
	
	public List<Student> getStudents(String name, Integer age, Integer identification) {
		List<Student> students = customAccountRepository.getStudents();
		if(name != null) {
			students= students.stream()
				.filter(s -> s.getName().equals(name))
				.collect(Collectors.toList());	
		}
		if(age != null) {
			students= students.stream()
				.filter(s -> s.getAge().equals(age))
				.collect(Collectors.toList());	
		}
		if(identification != null) {
			students= students.stream()
				.filter(s -> s.getIdentification().equals(identification))
				.collect(Collectors.toList());	
		}
		return students;
	}
	
}
