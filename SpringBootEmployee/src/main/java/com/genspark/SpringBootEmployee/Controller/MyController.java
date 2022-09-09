package com.genspark.SpringBootEmployee.Controller;

import com.genspark.SpringBootEmployee.Entity.Employee;
import com.genspark.SpringBootEmployee.Service.EmailService;
import com.genspark.SpringBootEmployee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmailService emailService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.employeeService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId){
        return this.employeeService.getEmployeeById(Integer.parseInt(employeeId));
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        Employee result = this.employeeService.addEmployee(employee);
        //commented out for push
//        this.emailService.sendEmail(result.getEmployeeEmail(),
//                "Welcome",
//                String.format("Welcome %s, thank you for joining us!", result.getEmployeeName()));
        return result;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId){
        return this.employeeService.deleteEmployee(Integer.parseInt(employeeId));
    }
}
