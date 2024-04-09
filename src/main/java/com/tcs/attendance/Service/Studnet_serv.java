package com.tcs.attendance.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.attendance.Entity.Student;
import com.tcs.attendance.Repository.StudentRepo;

@Service
public class Studnet_serv {

    @Autowired
    private StudentRepo studentRepo;

    // get the student by id
    public Student getStudentbyId(Long Id) {
        Optional<Student> std = studentRepo.findById(Id);
        if (std.isPresent()) {
            return std.get();
        } else {
           return null;
        }
    }

    // get all the students
    public List<Student> getallThestudent() {
        return studentRepo.findAll();
    }

    // save one student
    public void savestudent(Student std) {
        studentRepo.save(std);
    }

    // save alist of student
    public void saveAllStudent(List<Student> std_List) {
        studentRepo.saveAll(std_List);
    }

    // delet one student by ID
    public void deletstudent(Long Id) {
        Optional<Student> z = studentRepo.findById(Id);
        if (z.isPresent()) {
            studentRepo.deleteById(Id);
        } else {
            System.out.println("No such student to delet ");
        }
    }

    // deleet all tyeh sudent
    public void deletALlstd() {
        studentRepo.deleteAll();
    }

    // update student
    public void updateSTudent(Student std) {
        Optional<Student> temp_std = studentRepo.findById(std.getId());
        if (temp_std.isPresent()) {
            Student z = temp_std.get();
            z.setAttendance(std.getAttendance());
            z.setClass_teacher_Id(std.getClass_teacher_Id());
            z.setStd(std.getStd());
            z.setStudent_name(std.getStudent_name());
            // z.setAttendance(std.getAttendance());
            studentRepo.save(z);
        }

        else {
            studentRepo.save(std);
        }
    }
//TODO
//tomake a metod to find student by name
//list of student with commin subhects 
//Attendace with defulter name 
//
}
