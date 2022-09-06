package com.genspark.SpringBootEmployee.Controller;

import com.genspark.SpringBootEmployee.Entity.Employee;
import com.genspark.SpringBootEmployee.Service.EmployeeService;
import com.genspark.SpringBootEmployee.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getEmployees();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId){
        return this.employeeService.getEmployeeById(Integer.parseInt(employeeId));
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId){
        return this.employeeService.deleteEmployee(Integer.parseInt(employeeId));
    }
}
