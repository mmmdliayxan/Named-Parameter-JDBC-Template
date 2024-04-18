package org.example.controllerpractise.db;

public interface Query {

    String FIND_EMPLOYEE="SELECT * from hr.employee where employee_id=?";
    String FIND_EMPLOYEE1="SELECT * from hr.employee where employee_id=? and first_name=?";
    String ALL_EMPLOYEE="SELECT * from hr.employee";
    String ADD_EMPLOYEE="INSERT into hr.employee(first_name, last_name, job_title, department_id,birth_date, salary) values (?,?,?,?,?,?)";
    String UPDATE_EMPLOYEE = "Update hr.employee " +
            " set first_name=?,last_name=?,job_title=?,department_id=?,birth_date=?,salary=? " +
            " where employee_id=?";
    String DELETE_EMPLOYEE="Delete from hr.employee where employee_id=?";
}
