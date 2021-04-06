package com.example.EMS;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String Email;
    private boolean status;

    public Employee(int id, String firstName, String lastName, String email, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.status = status;
    }

    public Employee(String firstName, String lastName, String email, boolean status) {
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Email='" + Email + '\'' +
                ", status=" + status +
                '}';
    }
}
