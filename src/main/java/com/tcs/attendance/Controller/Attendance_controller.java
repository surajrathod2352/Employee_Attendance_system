package com.tcs.attendance.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.attendance.Service.Attendance_serve;

import jakarta.annotation.PostConstruct;

import com.tcs.attendance.Entity.Attendance;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/attendance")
public class Attendance_controller {

    @Autowired
    private Attendance_serve attendance_serve;

    @PostConstruct
    public void setAttendance()
    {
        
    }

    @GetMapping("/allatt")
    public List<Attendance> getallatt() {
        return attendance_serve.getall();
    }

    @GetMapping("/getById/{Id}")
    public Attendance getMethodName(@PathVariable Long Id) {
        return attendance_serve.findwithId(Id);
    }

    @PostMapping("/pstall")
    public void postallatt(@RequestBody List<Attendance> AttList) {
        attendance_serve.saveallattendnce(AttList);

    }

    @PostMapping("/poastbyId")
    public void postwithId(@RequestBody Attendance att) {

        attendance_serve.saveanAtt(att);

    }

    @DeleteMapping("/deleteall")
    public void dleteallatt() {
        attendance_serve.deleteallatt();
    }

    @DeleteMapping("/deletewithId/{Id}")
    public void dletewithIdatt(@PathVariable Long Id) {
        attendance_serve.deletewithId(Id);
    }

    @PutMapping("putatt")
    public void updateadata(@PathVariable String id, @RequestBody Attendance att) {

        attendance_serve.updateatt(att);
    }

}
