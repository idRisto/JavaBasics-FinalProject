package com.testi.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class CourseFileService implements InterfaceCourseFileService{

    static List<Student> students = new ArrayList<Student>();
    static List<Course> courses = new ArrayList<Course>();

    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException {
        File studentsi = new File(filePath);
        Scanner sc = new Scanner(studentsi);
        try {
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String name[] = line.split(" ");
                Student student = new Student(name[0], name[1]);
                if (students.contains(student)){}
                else students.add(student);
            }
            sc.close();
            return students;
        }
        catch (Exception e) {
            System.out.println("readstudentsfromfile");
            System.out.println(e);
            sc.close();
            return null;
        }
    }

    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException {
        File courssit = new File(filePath);
        Scanner sc = new Scanner(courssit);
        try {
            while (sc.hasNext()) {
                String course = sc.nextLine();
                String[] cn = course.split("--");
                if (Arrays.stream(cn).anyMatch("online"::equals)) {
                    OnlineCourse oCourse = new OnlineCourse(cn[0], cn[1], cn[2]);
                    if (courses.contains(oCourse)){}
                    else courses.add(oCourse);
                } else {
                    LocalCourse lCourse = new LocalCourse(cn[0], cn[1], cn[2]);
                    if (courses.contains(lCourse)){}
                    else courses.add(lCourse);
                }   
            }
            sc.close();
            return courses;
        } catch (Exception e){
            System.out.println("readcoursesfromfile");
            System.out.println(e);
            sc.close();
            return null;
        }
    }
}