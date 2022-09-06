package com.genspark.SpringBootEmployee.Service;

import com.genspark.SpringBootEmployee.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> list;

    public EmployeeServiceImpl() {
        list = new ArrayList<>();
        list.add(new Employee(1, "John Smith", "johnsmith@gmail.com"));
        list.add(new Employee(2, "John Doe", "johndoe@hotmail.com"));
        list.add(new Employee(3, "Robert Robertson", "robrobertson@yahoo.com"));
    }
    @Override
    public List<Employee> getEmployees() {

        return list;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee e = null;
        for(Employee m : list){
            if(m.getEmployeeId() == employeeId){
                e = m;
                break;
            }
        }
        return e;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        list.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee e = null;
        for(Employee m : list){
            if(m.getEmployeeId() == employee.getEmployeeId()){
                m.setEmployeeName(employee.getEmployeeName());
                m.setEmployeeEmail(employee.getEmployeeEmail());
                e = m;
                break;
            }
        }
        return e;
    }

    @Override
    public String deleteEmployee(int employeeId) {
        for(Employee e : list){
            if(e.getEmployeeId() == employeeId){
                list.remove(e);
                break;
            }
        }
        return "Deleted Successfully";
    }
}
