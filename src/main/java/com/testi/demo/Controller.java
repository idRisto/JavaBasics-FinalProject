package com.testi.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private CourseService courseservice;
    
    @GetMapping
    public String getInfo(){
        String text = "<html>Possible paths: <br/> /students <br/> /courses <br/> /students/id <br/> /courses/id</html>";
        return text;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return courseservice.getStudents();                         //Muotoilu = JSON
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseservice.getCourses();                          //Muotoilu = JSON
    }

    @GetMapping("/onlinecourses")
    public String getOnlineCourses(){
        List<String> names = new ArrayList<>();
        for ( int i=1;i<courseservice.getCourses().size() +1;i++)
            names.add(courseservice.getCourseById(i).courseName);
        return names.toString();                                                        //Muotoilu = [kurssi,kurssi,...]
    }

    @GetMapping("/students/{id}")
    public String studentByIdCourses(@PathVariable int id){
        String stud = courseservice.getStudentById(id).toString();
        List<Course> lista = new ArrayList<>();
        lista = courseservice.getCoursesOfStudent(id);
        return stud +"<html><br/></html>"+ lista;                                       //Muotoilu = nimi
    }                                                                                   //           [kurssi,kurssi,...]

    @GetMapping("/courses/{id}")
    public String courseByIdStudents(@PathVariable int id){
        String course = courseservice.getCourseById(id).toString();
        List<String> studit = new ArrayList<>();
        studit = courseservice.getCourseById(id).studentList;
        return course +"<html><br/></html>"+ studit;                                    //Muotoilu = kurssi
    }                                                                                   //           [nimi,nimi,...]

    @PostMapping("/add")
    public String studentToCourse(@RequestBody Map<String, Object> jsonMapping){
        long sid = Long.parseLong(jsonMapping.get("sid").toString());
        long cid = Long.parseLong(jsonMapping.get("cid").toString());
        if (courseservice.addStudentToCourse(sid, cid) == true) return "Done!";
        else return "Not done!";                                                        //body syötettävä muodossa: {"sid":x, "cid":y}
    }
}
