package com.rajesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.rajesh.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Employee> rowMapper = new RowMapper<>() {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setRole(rs.getString("role"));
            return emp;
        }
    };

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO Employee (id, name, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getRole());
    }

    @Override
    public Employee getById(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE Employee SET name = ?, role = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM Employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

}
