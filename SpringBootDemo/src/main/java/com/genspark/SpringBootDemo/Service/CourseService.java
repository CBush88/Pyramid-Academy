package com.genspark.SpringBootDemo.Service;

import com.genspark.SpringBootDemo.Entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int CourseId);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    String deleteCourseById(int CourseId);
}
