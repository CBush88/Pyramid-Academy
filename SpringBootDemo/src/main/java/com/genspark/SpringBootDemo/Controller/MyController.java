package com.genspark.SpringBootDemo.Controller;


import com.genspark.SpringBootDemo.Entity.Course;
import com.genspark.SpringBootDemo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    @RequestMapping("/home")
    public String hello(@RequestParam(value="name", defaultValue="World") String name,
                       @RequestParam(value="msg", defaultValue="Good Morning!") String msg){
        return "Hello " + name + "! " + msg;
    }

    @GetMapping("/")
    public String home(){
        return "<HTML><H1>Welcome to the Course Application</H1></HTML>";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
    return this.courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourseById(Integer.parseInt(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse(@PathVariable String courseId){
        return this.courseService.deleteCourseById(Integer.parseInt(courseId));
    }
}
