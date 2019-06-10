package com.globant.bootcamp.spring.Rest.Students.Utils;

import com.globant.bootcamp.spring.Rest.Students.Base.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class utils {

    public static ArrayList<Student> convertMultiPartFile2StudentArrList(MultipartFile file) throws IOException {
        ArrayList<Student> newStudentList = new ArrayList<Student>();


        Workbook receiveFileInputStream = new XSSFWorkbook(file.getInputStream());
        Sheet readSheet = receiveFileInputStream.getSheetAt(0);
        Iterator<Row> iterator = readSheet.iterator();

        DataFormatter formatter = new DataFormatter(Locale.US);

        while (iterator.hasNext())
            {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();


            newStudentList.add(new Student(
                         currentRow.getCell(0).getStringCellValue(),
                    (int)currentRow.getCell(1).getNumericCellValue(),
                    (int)currentRow.getCell(2).getNumericCellValue()));
           }

        return newStudentList;
    }



}
