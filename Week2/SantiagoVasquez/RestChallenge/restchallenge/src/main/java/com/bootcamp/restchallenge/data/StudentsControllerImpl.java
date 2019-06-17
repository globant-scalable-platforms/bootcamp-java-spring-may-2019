package com.bootcamp.restchallenge.data;

import com.bootcamp.restchallenge.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsControllerImpl implements StudentsControllerInterface {

    private List<Student> students;

    public StudentsControllerImpl() {
        students = new ArrayList<>();
        students.add(new Student("Andres", "123", 25));
        students.add(new Student("Camilo", "456", 28));
        students.add(new Student("Luis", "789", 22));
        students.add(new Student("Carlos", "159", 25));
        students.add(new Student("Daniel", "751", 25));
        students.add(new Student("Santiago", "183", 28));
    }

    @Override
    public List<Student> getStudents(String name, String identification, Integer age) {
        Stream<Student> stream = students.stream();
        if (Objects.nonNull(name))
            stream = stream.filter(student -> student.getName().contains(name));
        if (Objects.nonNull(identification))
            stream = stream.filter(student -> student.getIdentification().contains(identification));
        if (Objects.nonNull(age))
            stream = stream.filter(student -> student.getAge() == age);

        return stream.collect(Collectors.toList());
    }
}
