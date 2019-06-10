 package com.globant.bootcamp.spring.Rest.Students.Controller;

import com.globant.bootcamp.spring.Rest.NumbersOperations.Data.NumbersDataSource;
import com.globant.bootcamp.spring.Rest.Students.Data.StudentDataSource;
import com.globant.bootcamp.spring.Rest.Students.Exceptions.NotInputFileException;
import com.globant.bootcamp.spring.Rest.Students.Response.Response;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;


import static com.globant.bootcamp.spring.Rest.NumbersOperations.Controller.Utils.convertInputStream2String;
import static com.globant.bootcamp.spring.Rest.Students.Utils.utils.convertMultiPartFile2StudentArrList;

 @RestController
public class StudentController {

        private StudentDataSource studentDataSource;

        @Autowired
        public StudentController(final StudentDataSource studentDataSource){
            this.studentDataSource = studentDataSource;
        }

        @PostMapping("/students")
        public ResponseEntity filterStudentsList(@RequestParam("file") MultipartFile file)throws FileNotFoundException, IOException {
            studentDataSource = new StudentDataSource(convertMultiPartFile2StudentArrList(file));

        return ResponseEntity.ok().body(new Response(studentDataSource.getOrderedByName()));
        }

        @PostMapping("/students/orderedByName")
        public ResponseEntity filterStudentsByName(@RequestParam("file") MultipartFile file)throws FileNotFoundException, IOException {
         studentDataSource = new StudentDataSource(convertMultiPartFile2StudentArrList(file));
         return ResponseEntity.ok().body(new Response(studentDataSource.getOrderedByName()));
        }

        @PostMapping("/students/orderedByAge")
        public ResponseEntity filterStudentsByAge(@RequestParam("file") MultipartFile file)throws FileNotFoundException, IOException {
         studentDataSource = new StudentDataSource(convertMultiPartFile2StudentArrList(file));
         return ResponseEntity.ok().body(new Response(studentDataSource.getOrderedByAge()));
        }

        @PostMapping("/students/orderedByIdentification")
        public ResponseEntity filterStudentsByIdentification(@RequestParam("file") MultipartFile file)throws FileNotFoundException, IOException {
         studentDataSource = new StudentDataSource(convertMultiPartFile2StudentArrList(file));
         return ResponseEntity.ok().body(new Response(studentDataSource.getOrderedByIdentification()));
        }

        @GetMapping("/students/orderedByName")
            public ResponseEntity filterStudentByName(){
                try {
                    return ResponseEntity.ok().body(new Response(studentDataSource.getOrderedByName()));
                }catch(Exception ex){
                    throw new NotInputFileException("Not such file");
                }
        }

        @GetMapping("/students/orderedByAge")
        public ResponseEntity filterStudentByAge(){
         try {
             return ResponseEntity.ok().body(new Response(studentDataSource.getOrderedByAge()));
         }catch(Exception ex){
             throw new NotInputFileException("Not such file");
         }
        }

        @GetMapping("/students/orderedByIdentification")
        public ResponseEntity filterStudentByIdentification(){
         try {
             return ResponseEntity.ok().body(new Response(studentDataSource.getOrderedByIdentification()));
         }catch(Exception ex){
             throw new NotInputFileException("Not such file");
         }
        }

        @GetMapping("/")
        public String greeting(){
            return "Practice : Student Filter";
        }


}
