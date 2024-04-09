package com.tcs.attendance.Controller;
import com.tcs.attendance.Entity.Teacher;
import com.tcs.attendance.Service.Teacher_serv;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/teach")
public class Teacher_controller {
     
    @Autowired
    private Teacher_serv teacher_serv;

    @PostConstruct
    public void setupteach()
    {
        
    }

    @GetMapping("/allteach")
    public List<Teacher> getallteacherList() {
        return teacher_serv.getallteachers();
    }

    @GetMapping("/getteach/{Id}")
    public Teacher getMethodName(@PathVariable Long Id) {
        return teacher_serv.getteacherByID(Id);
    }

    @PostMapping("/saveal")
    public String saveallteacher(@RequestBody List<Teacher> teach_list) {
        //TODO: process POST request
        teacher_serv.saveAllteacher(teach_list);
        return "all the teachers are been updated to database";
    }

    @PostMapping("/saveteach")
    public String postMethodName(@RequestBody Teacher teacher) {
        //TODO: process POST request
        teacher_serv.saveteacher(teacher);
        return "Tgis teacher has been upadted to the database";
    }

    @DeleteMapping("/deleteall")
    public String deleteAll()
    {
        teacher_serv.deleteAllteacher();
        return " all theteacher has been deleted ";
    }

    @DeleteMapping("/delete/{Id}")
    public String deleteById(@PathVariable Long Id)
    {
        teacher_serv.deleteteacher(Id);
        return "tecaher with the given id has been deleted";
    }

    @PutMapping("put")
    public String putMethodName(@PathVariable String id, @RequestBody Teacher entity) {
        //TODO: process PUT request
        teacher_serv.uodateTeach(entity);
        return "dta of the teacher has been updated";
    }

    
    
    
    
    
}