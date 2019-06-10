package com.globant.bootcamp.spring.RestKata.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@RestController
public class dateController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping(value="/dateController/milliseconds/{fromDate}/{toDate}")
    public String toDateBiggerFromDate(@PathVariable long fromDate, @PathVariable long toDate) {
        Date fromDatee = new Date(fromDate);
        Date toDatee   = new Date(toDate);
        Date actualDate = new Date();

        return  compareDates(toDatee, fromDatee);
   }

    @GetMapping(value="/dateController/yy-mm-dd_hh:mm-:s/{fromDate}/{toDate}")
    public String isToDateBiggerFromDate_DateFormat(@Valid @PathVariable String fromDate, @PathVariable String toDate) {

        return askMe(fromDate, toDate)+sendMessage(
                converDate2Long(toDate)>converDate2Long(fromDate),
                fromDate,
                toDate
        );
    }

    @GetMapping(value="/dateController/yy-mm-dd/{fromDate}/{toDate}")
    @NotNull
    public String isToDateBiggerFromDate(@Valid @PathVariable String fromDate, @PathVariable String toDate) {
                String fillingTheFormat = "_00:00:00";
        return askMe(fromDate, toDate)+sendMessage(

                converDate2Long(toDate+fillingTheFormat)<converDate2Long(fromDate+fillingTheFormat),
                fromDate,
                toDate
        );
   }
    public  String sendMessage(boolean greater, String toDatee, String fromDatee){
        return  (greater)?"True : Date ("+fromDatee+ ") is lower than Date ("+ toDatee.toString()+")":
                "False : Date ("+fromDatee+ ") is greater than Date ("+ toDatee.toString()+")";
    }


   public  String compareDates(Date toDatee, Date fromDatee){
       return  (toDatee.getTime() - fromDatee.getTime()>0)?"From Date ("+fromDatee+ ") is lower than To Date "+ toDatee.toString():
               "From Date ("+fromDatee+ ") is greater than To Date "+ toDatee.toString();
   }



   public long converDate2Long(String Date){
       return   LocalDateTime.parse(Date
               .replace("_", "T"))
               .atZone(ZoneId.of("America/Bogota"))
               .toInstant()
               .toEpochMilli();
   }

   public String askMe(String fromDate, String toDate){

        return "Is FromDate ("+fromDate+") bigger than toDate ("+toDate+")? \r\n\r\n";
   }



   /*       //// Deprecated
   public static Date createDate(String [] arr){
        if(arr.length==3){

            return new Date(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
        }
    }
    */

    public static int[] converStr2Arr(String date){
        String [] tempDate = date.split("-");
        int [] res = new int[3];
        for(int i =0; i<tempDate.length;i++){res[i]=Integer.parseInt(tempDate[i]); }
        return res;
    }

   /* public static void main(String [] args){

        String fecha1 = "2018-08-6";
        String fecha2 = "2017-6-7 ";

        String val1[] = fecha1.split("-");
        String val2[] = fecha2.split("-");

        //System.out.println(compareDates(createDate(val1), createDate(val2)));
    }*/

}
