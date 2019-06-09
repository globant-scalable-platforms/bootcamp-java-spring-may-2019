/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.spring.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.globant.bootcamp.spring.challenge.domain.Student;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Santiago Collazos Barrera
 */
@RestController()
@RequestMapping("/filter/student")
public class ControllerFilterStudent {

    private final List<Student> students = new CopyOnWriteArrayList<>(
            asList(
                    new Student(1018, "Santiago", "23"),
                    new Student(1019, "Julian", "25"),
                    new Student(1020, "Sebastian", "28"),
                    new Student(1021, "Sara", "31"),
                    new Student(1022, "Sandra", "18"))
    );

    @GetMapping()
    public ResponseEntity getStudentByName(@RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String id, @RequestParam(defaultValue = "") String age) {
        Student student = null;
        if (!id.equals("") && !name.equals("") && !age.equals("")) {
            student = (Student) students.stream()
                    .filter(s -> id.equals(String.valueOf(s.getId())) && name.equals(s.getName()) && age.equals(s.getAge()))
                    .findFirst()
                    .orElse(null);
        } else if (!id.equals("")) {
            student = (Student) students.stream()
                    .filter(s -> id.equals(String.valueOf(s.getId())))
                    .findFirst()
                    .orElse(null);
        } else if (!name.equals("")) {
            student = (Student) students.stream()
                    .filter(s -> name.equals(s.getName()))
                    .findFirst()
                    .orElse(null);
        } else if (!age.equals("")) {
            student = (Student) students.stream()
                    .filter(s -> age.equals(s.getAge()))
                    .findFirst()
                    .orElse(null);
        }
        if (student == null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Student not found");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
    }

}
