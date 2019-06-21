# Services Challenges

## Challenge #1

Given a date range input (from, to), validate that to date is greater than from date,
return an exception otherwise (Map the exception with Controller Advice).

##### Date format: dd-MM-yyyy

```bash
/challenge1/{from_date}/{to_date}
```

## Challenge #2

Create a service that validates that a header called “roles” contains the “admin”
role, otherwise return forbidden http status code.

```bash
/challenge2
```

## Challenge #3

Create a service that receives a file of numbers separated by commas and return
it’s average, count, max, min and sum.

```bash
/challenge3
```

## Challenge #4

Create a service to filter out a list of students by name, identification and age.

##### Return the complete List of students:
```bash
/challenge4/getStudents
```

##### Return the List of students filtered by name:
```bash
/challenge4/filterByName/{name}
```

##### Return the List of students filtered by identification:
```bash
/challenge4/filterByIdentification/{identification}
```

##### Return the List of students filtered by age:

```bash
/challenge4/filterByAge/{age}
```