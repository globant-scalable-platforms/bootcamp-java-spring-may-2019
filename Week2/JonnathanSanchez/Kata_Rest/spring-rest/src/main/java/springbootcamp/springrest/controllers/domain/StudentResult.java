package springbootcamp.springrest.controllers.domain;

import java.util.List;

public class StudentResult {

    private List<Student> students;

    public StudentResult(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
