# Date Challenge

Given a date range input (from, to), validate that to date is greater than from date,
return an exception otherwise (Map the exception with Controller Advice)

## Solution:
A Service was implemented with the following Uri distribution according to the date format:
      
      - /dateController/milliseconds/{fromDate}/{toDate}      : date based of Integer values.
      
      - /dateController/yy-mm-dd_hh:mm-:s/{fromDate}/{toDate} : date format "yy-mm-dd_hh:mm:ss"
      
      - /dateController/yy-mm-dd/{fromDate}/{toDate}          : date format "yy-mm-dd"
