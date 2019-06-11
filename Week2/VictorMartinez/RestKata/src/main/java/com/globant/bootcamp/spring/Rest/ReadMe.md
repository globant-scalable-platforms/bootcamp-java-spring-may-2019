# Practice Numbers Operation

Create a service that receives a file of numbers separated by commas and return it’s average, count, max, min and sum.

#### Solution:
![alt text](https://github.com/globant-scalable-platforms/bootcamp-java-spring-may-2019/blob/VictorMartinez_Week2_Bootcam/Week2/VictorMartinez/AuxFiles/NumbersKata/PostResponseNumbersKata.jpg?raw=true "Logo Numbers Exercise 1")

A simple .txt file was filled with an Integer Vector of values and Mapped into String making use of a Multipart command. 
The returned object comes inside a JSON which contains the input Vector and the properties as Average, Max, Count, min, sum.



# Practice Role/Admin Header Validation

Create a service that validates that a header called “roles” contains the “admin” role, otherwise return forbidden http status code.

#### Solution

A GetRequest service was set up for receiving the request. Then a Map took the Single Values from the Header and compared them gainst the "role" and "admin" tags. Two Exceptions - NotAdminPropertyFoundException, WrongHeaderNameException" were thrown in each case. 

# Practice Students
Create a service to filter out a list of students by name, identification and age

#### Solution
An Excel file was created for storing the information from the Students. Name, ID and Age were stablished as the standard parameters for the Table.
![alt text](https://github.com/globant-scalable-platforms/bootcamp-java-spring-may-2019/blob/VictorMartinez_Week2_Bootcam/Week2/VictorMartinez/AuxFiles/Students/InfoStudents.png?raw=true "Logo Numbers Exercise 1")

The Service had to Extract the information from the Excel File and return the filtered list By Name, AGe or Identification.
#### Ordered By Name : @GetMapping("/students/orderedByName") - @PostMapping("/students/orderedByName")
![alt text](https://github.com/globant-scalable-platforms/bootcamp-java-spring-may-2019/blob/VictorMartinez_Week2_Bootcam/Week2/VictorMartinez/AuxFiles/Students/GetRequestOrderedByName.png?raw=true "Logo Numbers Exercise 1")

#### Ordered By Age : @GetMapping("/students/orderedByAge") -  @PostMapping("/students/orderedByAge")
![alt text](https://github.com/globant-scalable-platforms/bootcamp-java-spring-may-2019/blob/VictorMartinez_Week2_Bootcam/Week2/VictorMartinez/AuxFiles/Students/GetRequestOrderedByAge.jpg?raw=true "Logo 
Numbers Exercise 1")


#### Ordered By Identification : @GetMapping("/students/orderedByIdentification") - @PostMapping("/students/orderedByIdentification")
![alt text](https://github.com/globant-scalable-platforms/bootcamp-java-spring-may-2019/blob/VictorMartinez_Week2_Bootcam/Week2/VictorMartinez/AuxFiles/Students/GetRequestOrderedByIdentification.jpg?raw=true "Logo Numbers Exercise 1")
