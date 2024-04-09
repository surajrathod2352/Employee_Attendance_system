package com.tcs.attendance.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.attendance.Service.*;
// import java.util.List;

import com.tcs.attendance.Entity.Attendance;
import com.tcs.attendance.Entity.Student;
import com.tcs.attendance.Entity.Teacher;
import com.tcs.attendance.Entity.Subject;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Public_controller {
    

    @Autowired
    private Attendance_serve attendance_serve;
    @Autowired
    private Studnet_serv studnet_serv;
    @Autowired
    private Teacher_serv teacher_serv;
    @Autowired
    private Subject_serve subject_serve;
    @Autowired
    private Public_serve public_serve;
    /**
     * 
     */
    @PostConstruct
    // @RequestMapping("public")
    public void buildIniy()
    {
        LocalDate ld= LocalDate.of(2022, 1, 1);
        List<Attendance> att_List= new ArrayList<>();
        att_List.add(new Attendance(ld,true, 1L));
        att_List.add(new Attendance(ld.plusDays(1),true, 2L));
        att_List.add(new Attendance(ld.plusDays(2),true, 1L));
          att_List.add(new Attendance(null,true,4L));
          att_List.add(new Attendance(null,false,7L));

        attendance_serve.saveallattendnce(att_List);


         List< Student> std_list= new ArrayList<>();
         std_list.add(new Student("Suraj Rathod", 10, null,null,new ArrayList<>(),1L ));//Arrays.asList(1L,2L)
         std_list.add(new Student("Tony Strak", 11, null, null,new ArrayList<>(),1L));
         std_list.add(new Student("Elon Musk", 12, null, null, new ArrayList<>(),1L));
         std_list.add(new Student("Nicola Tesla", 8, null, null, new ArrayList<>(),2L));

         studnet_serv.saveAllStudent(std_list);

         List <Teacher> teach_List= new ArrayList<>();
        teach_List.add(new Teacher("Ram Yadav", new ArrayList<>(), 1L));
        teach_List.add(new Teacher("Valmiki das", new ArrayList<>(), 2L));
        teach_List.add(new Teacher("Kalpana Singh", new ArrayList<>(), 3L));
        teach_List.add(new Teacher("Rushi Rathi", new ArrayList<>(), 4L));
        teach_List.add(new Teacher("Aniket Lal", new ArrayList<>(), null));
        
        teacher_serv.saveAllteacher(teach_List);

        List<Subject> subList= new ArrayList<>();
        subList.add(new Subject("Science"));
        subList.add(new Subject("Maths"));
        subList.add(new Subject("English"));
        subList.add(new Subject("Hindi"));
        subList.add(new Subject("Sanskrit"));
        subList.add(new Subject("History"));
        


        subject_serve.saveALlSub(subList);
        
        //exicutables
        public_serve.distributeAttendance(); 
        public_serve.addstdtoTeacher();
        
    }

    // @GetMapping("/attup")
    // public void getMethodName() {
    //   public_serve.distributeAttendance();
       
    // }
    
}
