package com.globant.bootcamp.spring.week2.challenges.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.globant.bootcamp.spring.week2.challenges.business.Challenge4Filter;
import com.globant.bootcamp.spring.week2.challenges.domain.Student;

@RestController
public class Challenge4FilterController {
	
	@Autowired
	Challenge4Filter challenge4Filter;

	
	@GetMapping(value = "/challenge4/getStudents")
    public List<Student> getStudents() { 

		return challenge4Filter.getStudents();
		
    }
	
	@GetMapping(value = "/challenge4/filterByName/{name}")
    public List<Student> filterByName(@PathVariable String name) { 

        return challenge4Filter.filterName(name);
        
    }
	
	@GetMapping(value = "/challenge4/filterByIdentification/{identification}")
    public List<Student> filterByIdentification(@PathVariable int identification) { 

        return challenge4Filter.filterIdentification(identification);
        
    }
	
	@GetMapping(value = "/challenge4/filterByAge/{age}")
    public List<Student> filterByAge(@PathVariable int age) { 

        return challenge4Filter.filterAge(age);
        
    }

}
