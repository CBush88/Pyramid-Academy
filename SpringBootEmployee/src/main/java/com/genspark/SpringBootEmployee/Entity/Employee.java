package com.genspark.SpringBootEmployee.Entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_employees")
public class Employee {
    @Id
    @Column(name="e_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int employeeId;
    private String employeeName;
    private String employeeEmail;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
