# Date Challenge

Given a date range input (from, to), validate that to date is greater than from date,
return an exception otherwise (Map the exception with Controller Advice)

## Solution:
A Service was implemented with the following Uri distribution according to the date format:
      
      - /dateController/milliseconds/{fromDate}/{toDate}      : date based of Integer values.
      
      - /dateController/yy-mm-dd_hh:mm-:s/{fromDate}/{toDate} : date format "yy-mm-dd_hh:mm:ss"
      
      - /dateController/yy-mm-dd/{fromDate}/{toDate}          : date format "yy-mm-dd"

Heres an example of the Service Conceived.

![alt text](https://github.com/globant-scalable-platforms/bootcamp-java-spring-may-2019/blob/VictorMartinez_Week2_Bootcam/Week2/VictorMartinez/AuxFiles/dateExercise.png?raw=true)
