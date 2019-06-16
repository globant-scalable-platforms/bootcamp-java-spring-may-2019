package springbootcamp.springrest.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springbootcamp.springrest.controllers.domain.FileResult;
import springbootcamp.springrest.controllers.domain.Student;
import springbootcamp.springrest.controllers.domain.StudentResult;
import springbootcamp.springrest.controllers.exception.ChallengeForbiddenException;
import springbootcamp.springrest.controllers.exception.ChallengePreconditionFailedException;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingInt;

@RestController()
@RequestMapping("/controller")
public class ChallengeController {

    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student("Jonnathan Sanchez", "1234", 25));
        students.add(new Student("Jonnathan Delgado", "4567", 23));
        students.add(new Student("Andrea Medina", "1256", 20));
        students.add(new Student("Andrea Bedolla", "4597", 25));
        students.add(new Student("Alejandro Alarcon", "6897", 20));
        students.add(new Student("Alejandra Perez", "4683", 24));
        students.add(new Student("Diego Hernandez", "6594", 23));
        students.add(new Student("Pepe Caceres", "1235", 18));
    }

    @GetMapping
    public String getChallenge(){
        return "Kata_Rest";
    }

    @GetMapping("/validateDates")
    public ResponseEntity<Object> validateDates(@RequestParam("fromdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromdate,
                                      @RequestParam("todate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date todate){
        if(todate.before(fromdate))throw new ChallengePreconditionFailedException();
        return new ResponseEntity<>("toDate is greater than fromDate", HttpStatus.OK);
    }

    @GetMapping("/validateRoles")
    public ResponseEntity<Object> validateRole(@RequestHeader(value="roles") String roles){
        if(!roles.contains("admin"))throw new ChallengeForbiddenException();
        return new ResponseEntity<>("Access granted", HttpStatus.OK);
    }

    @GetMapping("/calculateFile")
    public ResponseEntity<Object> calculateFile(@RequestParam("file") MultipartFile file) throws Exception {

        String content = new String(file.getBytes());

        IntSummaryStatistics stats = Arrays.stream(content.split(","))
                                    .map(Integer::parseInt)
                                    .collect(summarizingInt(Integer::intValue));

        FileResult result = new FileResult(stats.getAverage(), stats.getCount(), stats.getMax(),
                stats.getMin(), stats.getSum());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/listStudents")
    public ResponseEntity<Object> calculateFile(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                                                @RequestParam(value = "identification", required = false, defaultValue = "") String identification,
                                                @RequestParam(value = "age", required = false) Integer age) {


        List<Student> filterStudents = students.stream()
                                    .filter(s -> s.getName().contains(name))
                                    .filter(s -> s.getIdentification().startsWith(identification))
                                    .collect(Collectors.toList());

        if(Objects.nonNull(age)){
            filterStudents = filterStudents.stream()
                            .filter(s -> s.getAge() == age)
                            .collect(Collectors.toList());
        }

        return new ResponseEntity<>(new StudentResult(filterStudents), HttpStatus.OK);
    }

}
