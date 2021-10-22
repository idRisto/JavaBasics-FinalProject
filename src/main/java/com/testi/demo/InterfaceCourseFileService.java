package com.testi.demo;
import java.io.FileNotFoundException;
import java.util.*;

public interface InterfaceCourseFileService {
    
    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;

    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;

}
