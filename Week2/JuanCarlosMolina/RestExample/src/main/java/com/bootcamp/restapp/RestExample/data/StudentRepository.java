package com.bootcamp.restapp.RestExample.data;

import com.bootcamp.restapp.RestExample.domain.Student;

import java.util.List;

public interface StudentRepository {

    public List<Student> getAll();

    public Student getStudent(String name);
}
