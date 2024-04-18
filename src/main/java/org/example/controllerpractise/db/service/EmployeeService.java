package org.example.controllerpractise.db.service;

import org.example.controllerpractise.db.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(Integer id);
    List<Employee> getAll();
    Employee add(Employee employee);
    void update(Employee employee);
    void delete(Integer id);

}
