package com.bootcamp.restapp.RestExample.data;

import com.bootcamp.restapp.RestExample.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    DataSource dataSource;

    @Override
    public List<Student> getAll() {
        return dataSource.getStudents();
    }

    @Override
    public Student getStudent(String name) {
        return null;
    }
}
