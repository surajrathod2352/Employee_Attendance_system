package com.tcs.attendance.Service;

import com.tcs.attendance.Entity.Attendance;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.attendance.Repository.AttendanceRepo;

@Service
public class Attendance_serve {

    @Autowired
    private AttendanceRepo attendanceRepo;

    // gett all the attendance
    public List<Attendance> getall() {
        return attendanceRepo.findAll();
    }

    // get specific attendance
    public Attendance findwithId(Long Id) {
        if (attendanceRepo.findById(Id).isPresent()) {
            return attendanceRepo.findById(Id).get();
        } else {
            System.err.println("there is no attendance with this id");
            return null;
        }
    }

    // save a whole list of attndace at once
    public String saveallattendnce(List<Attendance> AttList) {
        attendanceRepo.saveAll(AttList);
        return " the data has been updated";
    }

    // save one attendance at a time
    public String saveanAtt(Attendance att) {
        attendanceRepo.save(att);
        return " the data has been updated ";
    }

    // delete all tyhe data
    public String deleteallatt() {
        attendanceRepo.deleteAll();
        return " all the data has been deleted ";
    }

    // delete a specific data
    public String deletewithId(Long Id) {
        if (attendanceRepo.findById(Id).isPresent()) {
            attendanceRepo.deleteById(Id);
            return " the data with this id has been deleted ";
        } else {
            return " there is no data with this id";
        }
    }

    // update an existing attendance
    public String updateatt(Attendance att)
    {
Long Id= att.getId();
if( attendanceRepo.findById(Id).isPresent())
{
    Attendance z= attendanceRepo.findById(Id).get();
    z.setDate(att.getDate());
    z.setStatus1(att.getStatus1());
    z.setStudent_Id(att.getStudent_Id());
    attendanceRepo.save(z);
    return " the data has been updated";
}
else{
    attendanceRepo.save(att);
    return " the data was not there so we have added it for you";
}
    }

    // have to work on this soon
    public List<Attendance> findwithStudentId(Long Id) {
        return null;
    }

}
