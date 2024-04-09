package com.tcs.attendance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import com.tcs.attendance.Service.Subject_serve;

import jakarta.annotation.PostConstruct;

import com.tcs.attendance.Entity.Subject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/sub")
public class SUbject_controller {

    @Autowired
    private Subject_serve subject_serve;


   
   @PostConstruct
   public void starter()
   {
    // List<Subject> SubjectList= List.of(new Subject("Science"),new Subject("Maths"),new Subject("English"));
    // subject_serve.saveALlSub(SubjectList);
   }

    @GetMapping("/allsubject")
    public List<Subject> getMethodName() {
        return subject_serve.getallsubject();
    }

    @GetMapping("/subject/{Id}")
    public Subject GetsubById(@PathVariable Long Id) {
        return subject_serve.getSubjectById(Id);
    }

    @DeleteMapping("/deleteall")
    public void deleteallsub() {
        subject_serve.deleteallthesub();
    }

    @DeleteMapping("/delete/{Id}")
    public void deletewithId(@PathVariable Long Id) {
        subject_serve.deletebyId(Id);
    }

    @PostMapping("/subjectpost")
    public void savesubject(@RequestBody Subject sub) {

        subject_serve.saveSub(sub);
    }

    @PostMapping("/allsubpost")
    public void postallsub(@RequestBody List<Subject> subList) {

        subject_serve.saveALlSub(subList);
    }

    @PutMapping("put")
    public void upadtesub(@RequestBody Subject sub) {

        subject_serve.updaSubject(sub);
    }

}
