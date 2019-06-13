package com.globant.bootcamp.springrest.domain;

import java.util.List;

public class StudentDataSource {

    private static List<Student> student;

    public StudentDataSource(List<Student> student) {
        this.student = student;
    }

    public List<Student> retrieveAllStudentInfo() {
        return student;
    }
}
