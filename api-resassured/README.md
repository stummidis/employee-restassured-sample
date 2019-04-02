# Rest-Assured Automation Example
 1. Create and return a new Employee with
  a. Employee_name
  b. Employee_age
  c. Employee_salary
  d.profile_img
  
 2. verify the employee was created with the correct data
 3. Update this employee's salary , verify update and return record.
 4. Delete the employee and demonstrate employee now deleted.


### Endpoints
- `/employee` - all employees


### Tests
`src/main/java/TestBase.class` is the tests superclass for configuration and common code
`src/test/java/` holds test classes (JUnit4) 

## How to run Tests
`cmd`
mvn -Dtest=EmployeeTest
`OR`
Right click on pom -run as mvn test
`OR`
Right click on EmployeeTest -Run as TestNg Test
`OR`
Right click on testng.xml file and Run as TestNG Suite

