package org.example.controllerpractise.db.controller;
import org.example.controllerpractise.db.model.Employee;
import org.example.controllerpractise.db.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable Integer id) {
        return employeeService.getById(id);
    }


    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee add(@RequestBody Employee employee){
        employee=employeeService.add(employee);
        return employee;
    }


    @PutMapping
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        employeeService.delete(id);
    }

}
