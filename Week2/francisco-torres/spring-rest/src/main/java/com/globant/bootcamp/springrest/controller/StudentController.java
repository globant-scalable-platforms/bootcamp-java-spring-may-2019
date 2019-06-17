package com.globant.bootcamp.springrest.controller;

import com.globant.bootcamp.springrest.domain.Student;
import com.globant.bootcamp.springrest.domain.StudentDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    @Qualifier(value="dataSourceSingleton")
    StudentDataSource studentDataSource;

    @GetMapping
    public ResponseEntity<List<Student>> studentListBy(@RequestParam(value = "firstname", required=false) String firstName,
                                                       @RequestParam(value = "lastname", required=false) String lastName,
                                                       @RequestParam(value = "id", required=false) String id,
                                                       @RequestParam(value = "age", required=false) Integer age) {
        Predicate<Student> query = a -> true;

        query = (firstName != null? query.and(a -> a.getFirstName().equals(firstName)): query);
        query = (lastName != null ? query.and(a -> a.getLastName().equals(lastName))  : query);
        query = (id != null       ? query.and(a -> a.getId().equals(id))              : query);
        query = (age != null      ? query.and(a -> a.getAge().equals(age))            : query);

        List<Student> queryResult = studentDataSource.retrieveAllStudentInfo()
                                                     .stream()
                                                     .filter(query)
                                                     .collect(Collectors.toList());

        return new ResponseEntity<>(queryResult, HttpStatus.OK);
    }
}
