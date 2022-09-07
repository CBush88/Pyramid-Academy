package com.genspark.SpringBootDemo.Dao;

import com.genspark.SpringBootDemo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
}
