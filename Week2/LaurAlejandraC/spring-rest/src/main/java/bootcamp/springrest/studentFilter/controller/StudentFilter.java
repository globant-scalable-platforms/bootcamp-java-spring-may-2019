package bootcamp.springrest.studentFilter.controller;

import bootcamp.springrest.studentFilter.data.StudentRepository;
import bootcamp.springrest.studentFilter.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/students")
public class StudentFilter {
    private StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentFilter.class);

    public StudentFilter(){
        this.studentRepository = new StudentRepository();
    }

    @GetMapping
    public ResponseEntity<List<Student>> getFilteredStudents(@RequestParam Map<String, String> filters){
        Stream<Student> stream = studentRepository.getStudents().stream();

        if(filters.containsKey("name")){
            stream = stream.filter(s -> s.getName().equals(filters.get("name")));
        }
        if(filters.containsKey("age")){
            try{
                Integer age = Integer.parseInt(filters.get("age"));
                stream = stream.filter(s -> s.getAge().equals(age));
            }catch (Exception ex){
                logger.error("Age filter not applied due to: " + ex.toString());
            }
        }
        if(filters.containsKey("identification")){
            stream = stream.filter(s -> s.getIdentification().equals(filters.get("identification")));
        }

        return new ResponseEntity<>(stream.collect(Collectors.toList()), HttpStatus.OK);
    }
}
