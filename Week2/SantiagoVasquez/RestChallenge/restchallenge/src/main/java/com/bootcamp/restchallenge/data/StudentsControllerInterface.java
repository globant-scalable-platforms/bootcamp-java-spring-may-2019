package com.bootcamp.restchallenge.data;

import com.bootcamp.restchallenge.domain.Student;

import java.util.List;

public interface StudentsControllerInterface {

    List<Student> getStudents(String name, String identification, Integer age);
}
