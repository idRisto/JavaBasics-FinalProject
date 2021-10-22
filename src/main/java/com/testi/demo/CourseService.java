package com.testi.demo;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements InterfaceCourseService{

    String path1 = ".\\demo\\students.txt";
    String path2 = ".\\demo\\courses.txt";

    @Autowired
    CourseFileService courseFileService;

    @PostConstruct
    public void init(){
        try {
        courseFileService.readCoursesFromFile(path2);
        courseFileService.readStudentsFromFile(path1);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public List<Student> getStudents() {
        return CourseFileService.students;
    }

    public List<Course> getCourses(){
       return CourseFileService.courses;
    }

    public Student getStudentById(long studentId){
        for (Student s : CourseFileService.students) {
            if (s.getId() == studentId) return s;
        }
        System.out.println("Student not found!");
        return null;
    }

    public Course getCourseById(long courseId){
        for (Course c : CourseFileService.courses) {
            if (c.getId() == courseId) return c;
        }
        System.out.println("Course not found!");
        return null;
    }

    public boolean addStudentToCourse(long studentId, long courseId){
        for (Student s : CourseFileService.students) {
            if (s.getId() == studentId) {
                for (Course c : CourseFileService.courses) {
                    if (c.getId() == courseId) {
                        if (c.addStudent(s) == true)
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Course> getCoursesOfStudent(long studentId){
        List<Course> studentCourses = new ArrayList<>();
        Student stud = getStudentById(studentId);
        for (Course c : CourseFileService.courses) {
            if (c.studentList.contains(stud.toString())) {
                studentCourses.add(c);
            }
        }
        return studentCourses;
    }
}
