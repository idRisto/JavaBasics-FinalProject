package com.testi.demo;

public class LocalCourse extends Course{
    private String classSpace;

    public LocalCourse(String courseName, String teacher, String classPlace){
        super(courseName, teacher);
        this.classSpace = classPlace;
    }

    public String getClassSpace() {
        return this.classSpace;
    }

    public void setClassSpace(String classSpace) {
        this.classSpace = classSpace;
    }

    @Override
    public boolean addStudent(Object Student){
        if (studentList.size()<25) {
            studentList.add(Student.toString());
            return true;
        }
        else{
            System.out.println("Course is full!");
            return false;
        }
    }

    @Override
    public String toString(){
        return courseName + "--" + teacher + "--" + classSpace;
    }
}
