package com.globant.bootcamp.spring.Rest.Students.Response;

import com.globant.bootcamp.spring.Rest.Students.Base.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Response {

    List<Student> studentsList;

    public Response(ArrayList<Student> studentsList){
        this.studentsList = studentsList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }




}
