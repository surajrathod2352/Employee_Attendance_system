package com.tcs.attendance.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.attendance.Repository.*;
// import com.tcs.attendance.Service.*;
import com.tcs.attendance.Entity.*;

@Service
public class Public_serve {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private TeacherRepo teacherRepo;
    // @Autowired
    // private SubjectRepo subjectRepo;
    // @Autowired
    // private AttendanceRepo attendanceRepo;
    @Autowired
    private Attendance_serve attendance_serve;
    @Autowired
    private Studnet_serv studnet_serv;
    @Autowired
    private Subject_serve subject_serve;
    @Autowired
    private Teacher_serv teacher_serv;

    // Add adttendance id to student
    // get att agrigate for eah student
    // map each student o teacher
    // map subject to student
    //

    public void distributeAttendance() {
        List<Attendance> attList = attendance_serve.getall();

        for (Attendance att : attList)//
        {
            // System.out.println(att.getStudent_Id());
            Student tempstd = studnet_serv.getStudentbyId(att.getStudent_Id());
            if (tempstd != null) {
                Long z = att.getId();
                List<Long> tempatt = tempstd.getAttendance();
                tempatt.add(z);
                tempstd.setAttendance(tempatt);
                // studnet_serv.updateSTudent(tempstd);
                studentRepo.save(tempstd);
                // System.out.println(tempstd);
            }

        }

    }

    public void addstdtoTeacher()
    {
       List<Student> stdList= studnet_serv.getallThestudent();
       for(Student std:stdList)
       {
        Teacher tempteacher= teacher_serv.getteacherByID(std.getClass_teacher_Id()) ;
        if(tempteacher!=null)
        {
            Long z= std.getId();
            List <Long> stdListofteach= tempteacher.getStd_list();
            stdListofteach.add(z);
            teacherRepo.save(tempteacher);
            // List<Long>stdref= tempteacher.getStd_list();
            // stdref.add(std.getClass_teacher_Id());
            // tempteacher.setStd_list(stdref);
            // teacherRepo.save(tempteacher);
        }
       }
    }
}
