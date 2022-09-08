package com.genspark.SpringBootEmployee.Dao;

import com.genspark.SpringBootEmployee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
