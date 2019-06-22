package com.bootcamp.restapp.RestExample.data;

import com.bootcamp.restapp.RestExample.domain.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DataSource {
    private List<Student> students;
    private final AtomicLong atomicId = new AtomicLong(1);;

    @PostConstruct
    private void populateList(){

        students = new ArrayList<>();

        students.add( new Student( getNextId(), "Sean Bean",34));
        students.add( new Student( getNextId(), "Mark Addy",22));
        students.add( new Student( getNextId(), "Nikolaj Coster-Waldau",37));
        students.add( new Student( getNextId(), "Michelle Fairley",20));
        students.add( new Student( getNextId(), "Lena Headey",32));
        students.add( new Student( getNextId(), "Emilia Clarke",44));
        students.add( new Student( getNextId(), "Iain Glen",45));
        students.add( new Student( getNextId(), "Harry Lloyd",22));
        students.add( new Student( getNextId(), "Kit Harington",28));
        students.add( new Student( getNextId(), "Sophie Turner",35));
        students.add( new Student( getNextId(), "Maisie Williams",24));
        students.add( new Student( getNextId(), "Richard Madden",40));
        students.add( new Student( getNextId(), "Alfie Allen",20));
        students.add( new Student( getNextId(), "Juan",41));

        System.out.println("Data source filled with " + students.size() + " elements.");
    }

    private int getNextId(){
        return (int)atomicId.getAndIncrement();
    }

    public List<Student> getStudents() {
        return students;
    }
}
