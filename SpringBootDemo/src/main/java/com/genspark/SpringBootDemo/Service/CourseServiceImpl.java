package com.genspark.SpringBootDemo.Service;

import com.genspark.SpringBootDemo.Dao.CourseDao;
import com.genspark.SpringBootDemo.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

//    Before DAO and persistence example
//    List<Course> list;
//
//    public CourseServiceImpl(){
//        list = new ArrayList<>();
//        list.add(new Course(101, "Spring Framework", "Pradeep"));
//        list.add(new Course(102, "Spring Boot", "Sukhvinder"));
//        list.add(new Course(103, "Web Application", "Adam"));
//    }

    @Override
    public List<Course> getAllCourses() {
        //before persistence
        //return list;
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourseById(int courseId) {
//        Before persistence example
//        Course c = null;
//        for(Course course : list){
//            if(course.getCourseId() == courseId){
//                c = course;
//                break;
//            }
//        }
//        return c;
        Optional <Course> c = this.courseDao.findById(courseId);
        Course course = null;
        if(c.isPresent()){
            course = c.get();
        }else {
            throw new RuntimeException(" Course not found for id :: " + courseId);
        }
        return course;
    }

    @Override
    public Course addCourse(Course course) {
//        Before presistence
//        list.add(course);
//        return course;
        return this.courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
//        Before Persistence
//        String title = course.getTitle();
//        String instructor = course.getInstructor();
//        Course c = null;
//
//        for(Course e : list){
//            if(e.getCourseId() == course.getCourseId()){
//                e.setTitle(title);
//                e.setInstructor(instructor);
//                c = e;
//                break;
//            }
//        }
//        return c;
        return this.courseDao.save(course);
    }

    @Override
    public String deleteCourseById(int courseId) {
//        for(Course c : list){
//            if(c.getCourseId() == courseId){
//                list.remove(c);
//                break;
//            }
//        }
//        return "Deleted Successfully";
        this.courseDao.deleteById(courseId);
        return "Deleted Successfully";
    }
}
