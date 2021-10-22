package com.testi.demo;
import java.util.ArrayList;
import java.util.List;

public abstract class Course{
    private int id;
    private static int idCounter = 0;
    public String courseName;
    public String teacher;
    public List<String> studentList = new ArrayList<String>();

    public Course(String courseName, String teacher){
        idCounter++;
        this.id = idCounter;
        this.teacher = teacher;
        this.courseName = courseName;
        CourseFileService.courses.add(this);
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return this.id;
    }

    public boolean addStudent(Object Student){
        if (this.studentList.contains(Student.toString()) == true)
            return false;
        else {
            studentList.add(Student.toString());
            return true;
        }
    }

    public void getStudents(){
        for (String string : studentList) {
            System.out.println(string);
        }
    }

}
