package org.example.controllerpractise.db.dao.impl;

import lombok.RequiredArgsConstructor;
import org.example.controllerpractise.db.dao.EmployeeDao;
import org.example.controllerpractise.db.model.Employee;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Employee getById(Integer id) {
        try {
            String query = "Select * from hr.employee where employee_id=:employeeId";
            return jdbcTemplate.queryForObject(query, new MapSqlParameterSource("employeeId", id), new BeanPropertyRowMapper<>(Employee.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Employee> getAll() {
        String query="Select * from hr.employee";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee add(Employee employee) {
        String query="insert into hr.employee(first_name,last_name,job_title,department_id,birth_date,salary)values(:firstName , :lastName , :jobTitle , :departmentId , :birthDate , :salary)";
        jdbcTemplate.update(query,new BeanPropertySqlParameterSource(employee));
        return employee;
    }

    @Override
    public void update(Employee employee) {
        String query="update hr.employee set first_name=:firstName,last_name=:lastName,job_title=:jobTitle,department_id=:departmentId,birth_date=:birthDate,salary=:salary where employee_id=:employeeId";
        jdbcTemplate.update(query,new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public void delete(Integer id) {
        String query="update hr.employee set status=0 where employee_id=:id";
        jdbcTemplate.update(query,new MapSqlParameterSource("id",id));
    }
}
