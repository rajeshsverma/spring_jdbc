package com.rajesh.model;

public class Employee {
    private int id;
    private String name;
    private String role;

    // Getters and setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', role='" + role + "'}";
    }
}
