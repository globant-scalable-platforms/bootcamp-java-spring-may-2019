package bootcamp.springrest.dateRange.controller;

import bootcamp.springrest.dateRange.domain.DateRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/date")
public class DateRangeController {

    @PostMapping("/check-range")
    public ResponseEntity<String> checkDateRange(@RequestBody DateRange dateRange){
        Date fromDate, toDate;
        try {
            fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateRange.getFromDate());
            toDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateRange.getToDate());
        }catch (Exception ex){
            return new ResponseEntity<>("The date format was not recognized. Please use yyyy-MM-dd \n" + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        String result = fromDate.compareTo(toDate) < 0 ? "Valid date range " : "Invalid date range";

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
