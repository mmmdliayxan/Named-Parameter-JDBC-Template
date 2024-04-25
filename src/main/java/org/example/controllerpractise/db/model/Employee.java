package org.example.controllerpractise.db.model;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;


@Data
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private int departmentId;
    private Date birthDate;
    private int salary;
    private int status;
}
