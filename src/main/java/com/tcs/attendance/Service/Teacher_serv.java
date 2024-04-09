package com.tcs.attendance.Service;

import com.tcs.attendance.Repository.TeacherRepo;
import com.tcs.attendance.Entity.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
public class Teacher_serv {

    @Autowired
    private TeacherRepo teacherRepo;

    //get all the teacher
    public List<Teacher> getallteachers()
    {
        return teacherRepo.findAll();
    }

    //get a specific techer by Id
    public Teacher getteacherByID(Long Id)
    {
        Optional <Teacher> tempteach= teacherRepo.findById(Id);
        if(tempteach.isPresent())
        {
            return tempteach.get();
        }
        else{
            return new Teacher(null , "no teacher with this id here", null, null);
        }
    }

    // save  one teachere data
    public void saveteacher(Teacher teacher)
    {
        teacherRepo.save(teacher);
    }

    //save list of teacher 
    public void saveAllteacher(List<Teacher> teach_list)
    {
        teacherRepo.saveAll(teach_list);
    }

    // delete teacher by Id 
    public void deleteteacher(Long Id)
    {
        Optional <Teacher> tempteach= teacherRepo.findById(Id);
        if(tempteach.isPresent())
        {
            teacherRepo.deleteById(Id);
        }
        else 
        {
            System.err.println("No teacher with this id");
        }
    }

    //delete all teacher 
    public void deleteAllteacher()
    {
        teacherRepo.deleteAll();
    }

    //update a teacher that is already there 
    public void uodateTeach(Teacher teacher)
    {
        Optional <Teacher> temp_teach= teacherRepo.findById(teacher.getId());
        if(temp_teach.isPresent())
        {
            Teacher z= temp_teach.get();
            z.setStd_list(teacher.getStd_list());
            z.setTeach_sub_Id(teacher.getTeach_sub_Id());
            z.setTeacher_name(teacher.getTeacher_name());
            teacherRepo.save(z);
        }
        else
        {
            teacherRepo.save(teacher);
        }
    }
}
