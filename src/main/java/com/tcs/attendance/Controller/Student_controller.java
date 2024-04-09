package com.tcs.attendance.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.tcs.attendance.Service.Studnet_serv;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.tcs.attendance.Entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/std")
public class Student_controller {

    @Autowired
    private Studnet_serv studnet_serv;

    @PostConstruct
    public void setstudent() {
        
         
    }

    @GetMapping("/getstdlist")
    public List<Student> getMethodName() {
        return studnet_serv.getallThestudent();
    }

    @GetMapping("/getstudent/{Id}")
    public Student getMethodName(@PathVariable Long Id) {
        return studnet_serv.getStudentbyId(Id);
    }

    @PostMapping("/saveallstudent")
    public String postMethodName(@RequestBody List<Student> studentlist) {
        // TODO: process POST request
        studnet_serv.saveAllStudent(studentlist);
        return "list is added";
    }

    @PostMapping("/savestudent")
    public String postMethodName(@RequestBody Student std) {
        studnet_serv.savestudent(std);

        return "the st8dent has been added ti the list ";
    }

    @DeleteMapping("/deleteAll")
    public String dleeteallStudents() {
        studnet_serv.deletALlstd();
        return " all the students ahve been deleeted ";
    }

    @DeleteMapping("/delete/{Id}")
    public String deletestdbyId(@PathVariable Long Id) {
        studnet_serv.deletstudent(Id);
        return "the student has been deleted ";
    }

    @PutMapping("/put")
    public String putMethodName( @RequestBody Student std) {
        // TODO: process PUT request
        studnet_serv.updateSTudent(std);
        return "this studendent data has been updated";
    }

}
