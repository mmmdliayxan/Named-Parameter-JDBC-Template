package org.example.controllerpractise.db.service.impl;

import org.example.controllerpractise.db.dao.EmployeeDao;
import org.example.controllerpractise.db.model.Employee;
import org.example.controllerpractise.db.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }
    @Override
    public Employee getById(Integer id) {
        return employeeDao.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee add(Employee employee) {
       employee=employeeDao.add(employee);
       return employee;
    }

    @Override
    public void update(Employee employee) {
       employeeDao.update(employee);
    }

    @Override
    public void delete(Integer id) {
     employeeDao.delete(id);
    }

}
