import io.restassured.response.Response;
import models.Employee;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;

public class EmployeeTest extends TestBase {

    /**
     * This is to test create a new employee with name and aga and sal and image.
     */
    @Test
    public void shouldReturnHttpCreated_withValidEmployee() {
        REQUEST.body(getEmployee()).post("/employee").then().statusCode(HttpStatus.SC_CREATED);
    }

    /**
     * Get the employee with name to check if the employee is present.
     */
    @Test
    public void getEmployee_WithValidEmployee() {
        Response response = REQUEST.get("/employee/" + getEmployee().getEmployee_name());
        response.then().body("Name", hasItem(getEmployee().getEmployee_name()));
        response.then().body("Salary", hasItem(getEmployee().getEmployee_sal()));
        response.then().body("Age", hasItem(getEmployee().getEmployee_age()));
        response.then().body("ProfileImage", hasItem(getEmployee().getProfile_image()));
    }

    /**
     * Update the employee sal and verify the record.
     */
    @Test
    public void updateEmployee_withSalaryShouldUpdateEmployee() {
        Employee e = getEmployee();
        e.setEmployee_sal(new BigDecimal("40000"));
        Response response = REQUEST.body(getEmployee()).put("/employee");
        response.then().body("Salary", everyItem(equalTo(40000)));
    }

    /**
     * Delete Employee get the response code as No content;
     */
    @Test
    public void deleteEmployee_WithValidEmployee_ShouldDeleteEmployee() {
        REQUEST.body(getEmployee()).delete("/employee").then().statusCode(HttpStatus.SC_NO_CONTENT);
        // Check that employee is deleted.
        REQUEST.get("/employee/" + getEmployee().getEmployee_name()).then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    private Employee getEmployee() {
        return Employee.builder().employee_age(30).employee_name("Srinivas").employee_sal(new BigDecimal("2000")).profile_image("http://testImage").build();
    }
}
