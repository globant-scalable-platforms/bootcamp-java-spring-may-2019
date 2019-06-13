## services challenge

The application has the following endpoints to consume the four services challenge:

#### {{url}}/student
Service returns a students representation that meet the filters. If there are not filters defined, it returns a all students. representation.
#### {{url}}/role
Service validates that consumer has the 'admin' role.
#### {{url}}/file
Service shows stats about the numbers into one file. The numbers should be separated by comma.
#### {{url}}/date
Service validates that 'from' date is before 'to' date. The dates should be in ISO format.

