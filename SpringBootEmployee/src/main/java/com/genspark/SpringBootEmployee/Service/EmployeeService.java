package com.genspark.SpringBootEmployee.Service;

import com.genspark.SpringBootEmployee.Entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployeeById(int employeeId);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    String deleteEmployee(int employeeId);

}
