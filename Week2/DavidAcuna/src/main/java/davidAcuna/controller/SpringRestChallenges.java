package davidAcuna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import davidAcuna.domain.ExcepcionResponse;
import davidAcuna.domain.NumberOperation;
import davidAcuna.domain.Student;
import davidAcuna.enums.RolEnum;
import davidAcuna.exceptions.BadRangeOfDatesException;
import davidAcuna.impl.SpringRestChallengesImpl;

@RestController
@RequestMapping(value = "/restChallenges")
public class SpringRestChallenges {
        
    @Autowired
	private SpringRestChallengesImpl springRestChallengesImpl;
    
    /**
	 * Validate if to date if greater than from date
	 * 
	 * @return  true if to date is greater than from date, exception otherwise
	 */
	@GetMapping(value = "/dateValidation/{fromDate}/{toDate}")
	public ResponseEntity<Boolean> validateDates(
			@PathVariable("fromDate") @DateTimeFormat(pattern = "dd-MM-yyyy") @Valid Date fromDate,
			@PathVariable("toDate") @DateTimeFormat(pattern = "dd-MM-yyyy") @Valid Date toDate)
			throws BadRangeOfDatesException {

		if (!springRestChallengesImpl.after(fromDate, toDate)) {
			throw new BadRangeOfDatesException("From Date id greater than To Date");
		}
		return ResponseEntity.status(HttpStatus.OK).body(springRestChallengesImpl.after(fromDate, toDate));

	}
    
    /**
   	 * Validate if a header called “roles” contains the “admin” role
   	 * The request header i.e is sending:
   	 * KEY: roles
   	 * VALUES: [admin,user]
   	 * 
   	 * @return  200 if contains header, 403 otherwise
   	 */
	@GetMapping(value = "/roleValidation")
	public ResponseEntity<HttpStatus> roleValidation(@RequestHeader("roles") String roles) {
		try {
			if (roles.contains(RolEnum.ADMIN.getRol())) {
				return ResponseEntity.status(HttpStatus.OK).body(null);
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
       
	/**
	 * Receives a file of numbers separated by commas and converts into a list
	 * 
	 * @return POJO NumberOperation with average, count, max, min and sum of the numbers received
	 */
	@PostMapping(value = "/numbersOps", produces = "application/json")
	public ResponseEntity<NumberOperation> numbersOps(@RequestParam("file") MultipartFile file) {
		try {
			String content = new String(file.getBytes());
			List<Integer> numbers = Arrays
					.stream(content.split(","))
			        .map(String::trim)
			        .map(Integer::valueOf)
			        .collect(Collectors.toList());			
			NumberOperation response = springRestChallengesImpl.operateNumbers(numbers);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	/**
	 * Filter out a list of students by name, identification and age
	 * 
	 * @return List of students
	 *         
	 */
	@GetMapping(value = "/students", produces = "application/json")
	public ResponseEntity<List<Student>> getStudents(@RequestParam(value="name", required=false) String name,
			@RequestParam(value="age", required=false) Integer age, @RequestParam(value="identification", required=false) Integer identification) {
		try {			
			List<Student> students = springRestChallengesImpl.getStudents(name,age,identification);
			return ResponseEntity.status(HttpStatus.OK).body(students);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
