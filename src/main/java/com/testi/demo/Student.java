package com.testi.demo;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private static long idCounter = 0;

    public Student(String etu, String suku){
        idCounter++;
        this.firstName = etu;
        this.lastName = suku;
        this.id = idCounter;
        CourseFileService.students.add(this);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return lastName + " " + firstName;
    }

}
