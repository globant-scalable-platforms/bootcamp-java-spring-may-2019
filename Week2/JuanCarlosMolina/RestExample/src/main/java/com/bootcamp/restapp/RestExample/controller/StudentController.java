package com.bootcamp.restapp.RestExample.controller;

import com.bootcamp.restapp.RestExample.data.StudentRepository;
import com.bootcamp.restapp.RestExample.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    StudentRepository students;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll(){

        if(Objects.nonNull(students.getAll())){
            return new ResponseEntity<>(students.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @GetMapping("/students/filter/name/{name}")
    public ResponseEntity<List<Student>> filterByName(@PathVariable("name") String name){

        if(Objects.nonNull(students.getAll())){

            List<Student> foundStudents = students.getAll().stream()
                                        .filter(s -> s.getName().contains(name))
                                        .collect(Collectors.toList());

            if(Objects.nonNull(foundStudents)){
                return new ResponseEntity<>(foundStudents,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }//End of filterStudentsByName

    @GetMapping("/students/name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable("name") String name){

        if(Objects.nonNull(students.getAll())){

            Student foundStudent = students.getAll().stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null);

            if(Objects.nonNull(foundStudent)){
                return new ResponseEntity<>(foundStudent,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }//End of getStudentByName

    @GetMapping("/students/id/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){

        if(Objects.nonNull(students.getAll())){

            Student foundStudent = students.getAll().stream()
                    .filter(s -> s.getId() == id)
                    .findFirst()
                    .orElse(null);

            if(Objects.nonNull(foundStudent)){
                return new ResponseEntity<>(foundStudent,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }//End of getStudentById

    @GetMapping("/students/filter/age/{age}")
    public ResponseEntity<List<Student>> filterByAge(@PathVariable("age") int age){

        List<Student> foundStudents = students.getAll().stream()
                                        .filter(s -> s.getAge() >= age)
                                        .collect(Collectors.toList());

        if(Objects.nonNull(foundStudents)){
            return new ResponseEntity<>(foundStudents, HttpStatus.OK);
        }

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/student/test/{name}")
    public ResponseEntity<String> test(@PathVariable("name") String name){

        String message = "Juan";

        System.out.println("Name: " + name);

        if(message.equals(name)){
            return new ResponseEntity<>(message + " was found",HttpStatus.OK);
        }

        return new ResponseEntity<>(message + " was not found",HttpStatus.NOT_FOUND);
    }

}
