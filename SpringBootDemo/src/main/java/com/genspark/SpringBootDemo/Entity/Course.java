package com.genspark.SpringBootDemo.Entity;


import javax.persistence.*;

@Entity
@Table(name="tbl_courses") //custom name for the table
public class Course {
    @Id
    @Column(name = "c_id") // custom name for column
    @GeneratedValue(strategy = GenerationType.AUTO) //auto generate the ID
    private int courseId;
    private String title;
    private String instructor;

    public Course() {
    }

    public Course(int courseId, String title, String instructor) {
        this.courseId = courseId;
        this.title = title;
        this.instructor = instructor;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
