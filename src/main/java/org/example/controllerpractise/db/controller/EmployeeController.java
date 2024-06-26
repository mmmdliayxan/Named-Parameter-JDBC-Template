package org.example.controllerpractise.db.controller;
import lombok.RequiredArgsConstructor;
import org.example.controllerpractise.db.model.Employee;
import org.example.controllerpractise.db.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id) {
        return employeeService.getById(id);
    }


    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        employee=employeeService.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }


    @PutMapping
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
