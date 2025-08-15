package com.rajesh.dao;


import java.util.List;
import com.rajesh.model.Employee;

public interface EmployeeDAO {
    void save(Employee employee);
    Employee getById(int id);
    void update(Employee employee);
    void deleteById(int id);
    List<Employee> getAll();
}

