package com.globant.bootcamp.spring.Rest.Students.Data;

import com.globant.bootcamp.spring.Rest.Students.Base.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


@Component
@Qualifier("DataSource")
public class StudentDataSource {


    private ArrayList<Student> students;


    public StudentDataSource(ArrayList<Student> students) {
        this.students = students;
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getOrderedByName(){
        Collections.sort(this.students, new Comparator<Student>() {
                    @Override
                    public int compare(Student student, Student t1) {
                        return student.getName().compareTo(t1.getName());
                    }
                }

        );
        return this.students;
    }

    public ArrayList<Student> getOrderedByAge(){
        Collections.sort(this.students, new Comparator<Student>() {
                    @Override
                    public int compare(Student student, Student t1) {
                        return  (student.getAge()<t1.getAge())?-1:1;
                    }
                }

        );
        return this.students;
    }

    public ArrayList<Student> getOrderedByIdentification(){
        Collections.sort(this.students, new Comparator<Student>() {
                    @Override
                    public int compare(Student student, Student t1) {
                        return  (student.getIdentification()<t1.getIdentification())?-1:1;
                    }
                }

        );
        return this.students;
    }
}
