package com.genspark.SpringBootEmployee.Service;

import com.genspark.SpringBootEmployee.Dao.EmployeeDao;
import com.genspark.SpringBootEmployee.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployees() {
        return this.employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        Optional<Employee> e = this.employeeDao.findById(employeeId);

        if(e.isPresent()){
            employee = e.get();
        }else {
            throw new RuntimeException("No employee with ID: " + employeeId);
        }

        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeDao.save(employee);
    }

    @Override
    public String deleteEmployee(int employeeId) {
        this.employeeDao.deleteById(employeeId);
        return "Deleted Successfully";
    }
}
