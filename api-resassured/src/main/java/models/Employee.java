package models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Employee {
    private String employee_name;
    private Integer employee_age;
    private BigDecimal employee_sal;
    private String profile_image;

}
