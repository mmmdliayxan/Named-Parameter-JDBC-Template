package org.example.controllerpractise.db.service.impl;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controllerpractise.db.dao.EmployeeDao;
import org.example.controllerpractise.db.exception.NotFoundException;
import org.example.controllerpractise.db.model.Employee;
import org.example.controllerpractise.db.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final HttpServletResponse response;

    @Override
    public  ResponseEntity<Employee> getById(Integer id) {
        log.info("getById method is started");
        Employee employee = employeeDao.getById(id);
        if (employee == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            try {
                throw new NotFoundException("there isn't any employee like this");
            } catch (NotFoundException e) {
                log.error(e.getMessage());
                return ResponseEntity.status(HttpStatus.FOUND).header("Location","/add").build();
            }
        } else {
            log.info("getById method is successfully done");
        }
        return ResponseEntity.ok(employee);
    }

    @Override
    public List<Employee> getAll() {
        log.info("getAll method is started");
        List<Employee> allEmployee = employeeDao.getAll();
        log.info("getAll method is done");
        return allEmployee;
    }

    @Override
    public Employee add(Employee employee) {
        log.info("employee add method is started");
        employee = employeeDao.add(employee);
        log.info("employee is successfully added");
        return employee;
    }

    @Override
    public void update(Employee employee) {
        log.info("employee update method is started");
        employeeDao.update(employee);
        log.info("employee in "+ employee.getEmployeeId()+" is successfully updated");
    }

    @Override
    public void delete(Integer id) {
        log.info("delete method is started");
        employeeDao.delete(id);
        log.info("employee in " + id + " is successfully deleted");
    }

}
