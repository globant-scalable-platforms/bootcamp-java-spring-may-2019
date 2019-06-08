package springbootcamp.springrest.controllers;

import org.springframework.web.bind.annotation.*;
import springbootcamp.springrest.controllers.model.Student;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.*;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@RestController()
@RequestMapping("/diego")
public class ProductController {

    private List<Student> students = new CopyOnWriteArrayList<>(asList(new Student("1", "Pepe",10), new Student("2", "Juan",100), new Student("3", "Luz", 10)));

    @GetMapping("/filterName")
    public List<Student> filterName(@RequestParam("name") @NotNull String name){
        return students.stream()
                .filter(i -> name.equals(i.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/filterID")
    public List<Student> filterID(@RequestParam("id") @NotNull String id){
        return students.stream()
                .filter(i -> id.equals(i.getId()))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/filterAge")
    public List<Student> filterAge(@RequestParam("age") @NotNull int age){
        return students.stream()
                .filter(i -> age == i.getAge())
                .collect(Collectors.toList());
    }

    @GetMapping("/dates/{from}/{to}")
    public boolean dates(@PathVariable("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from, 
        @PathVariable("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) throws Exception{
            if (to.compareTo(from) > 0) {
                return true;
            } else if(from.compareTo(to) > 0){
                throw new IOException("Incorrect data. Check your input");
            } else {
                throw new IOException("Incorrect data. Check your input");
            }
    }

    @GetMapping("/header")
    public ResponseEntity<Boolean> header(@RequestHeader("roles") String role){
        if (role.equalsIgnoreCase("admin")) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/numbers")
    public ResponseEntity<Map<String, Integer>> numbers(@RequestBody String nums){
        System.out.println(nums+"---------------------------------------------------------------------------");
        Map<String,Integer> hashMap = new HashMap<>();
        String[] listNums = nums.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < listNums.length; i++) {
            numbers.add(Integer.parseInt(listNums[i]));
        }

        System.out.println(numbers);

        int sum = numbers.stream().reduce(0, (a,b) -> a+b);
        int max = numbers.stream().reduce(numbers.get(0), Integer::max);
        int min = numbers.stream().reduce(numbers.get(0), Integer::min);
        int avg = sum/numbers.size();

        hashMap.put("Average", avg);
        hashMap.put("Count", numbers.size());
        hashMap.put("Max", max);
        hashMap.put("Min", min);
        hashMap.put("Sum", sum);

        return new ResponseEntity<Map<String, Integer>>(hashMap, HttpStatus.OK);
        
    }

}
