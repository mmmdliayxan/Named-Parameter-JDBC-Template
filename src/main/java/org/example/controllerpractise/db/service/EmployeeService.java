package org.example.controllerpractise.db.service;

import org.example.controllerpractise.db.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<Employee> getById(Integer id);
    List<Employee> getAll();
    Employee add(Employee employee);
    void update(Employee employee);
    void delete(Integer id);

}
