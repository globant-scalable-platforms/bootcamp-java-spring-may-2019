package bootcamp.springrest.studentFilter.data;

import bootcamp.springrest.studentFilter.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students;

    public StudentRepository(){
        students = new ArrayList<>();

        students.add(new Student("Alejandra", "2345608", 23));
        students.add(new Student("Camila", "53454353", 25));
        students.add(new Student("Paula", "335525325", 23));
        students.add(new Student("Miguel", "5465445", 27));
        students.add(new Student("Andrés", "1032563435", 26));
        students.add(new Student("Laura", "10324634635", 22));
        students.add(new Student("Camila", "1394838423", 22));
    }

    public List<Student> getStudents() {
        return students;
    }
}
