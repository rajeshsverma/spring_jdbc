package com.rajesh.spring_jdbc;

import com.rajesh.dao.EmployeeDAO;
import com.rajesh.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final EmployeeDAO employeeDAO;

    public CommandLineAppStartupRunner(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("John Doe");
        emp.setRole("Developer");

        employeeDAO.save(emp);

        Employee fetchedEmp = employeeDAO.getById(1);
        System.out.println("Fetched Employee: " + fetchedEmp);

        fetchedEmp.setRole("Senior Developer");
        employeeDAO.update(fetchedEmp);

        List<Employee> employees = employeeDAO.getAll();
        employees.forEach(System.out::println);

        //employeeDAO.deleteById(1);
    }
}
