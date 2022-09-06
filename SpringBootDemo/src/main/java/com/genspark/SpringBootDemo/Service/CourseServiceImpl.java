package com.genspark.SpringBootDemo.Service;

import com.genspark.SpringBootDemo.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(101, "Spring Framework", "Pradeep"));
        list.add(new Course(102, "Spring Boot", "Sukhvinder"));
        list.add(new Course(103, "Web Application", "Adam"));
    }

    @Override
    public List<Course> getAllCourses() {
        return list;
    }

    @Override
    public Course getCourseById(int courseId) {
        Course c = null;
        for(Course course : list){
            if(course.getCourseId() == courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        String title = course.getTitle();
        String instructor = course.getInstructor();
        Course c = null;

        for(Course e : list){
            if(e.getCourseId() == course.getCourseId()){
                e.setTitle(title);
                e.setInstructor(instructor);
                c = e;
                break;
            }
        }
        return c;
    }

    @Override
    public String deleteCourseById(int courseId) {
        for(Course c : list){
            if(c.getCourseId() == courseId){
                list.remove(c);
                break;
            }
        }
        return "Deleted Successfully";
    }
}
