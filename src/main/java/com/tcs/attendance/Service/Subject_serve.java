package com.tcs.attendance.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tcs.attendance.Repository.SubjectRepo;
import com.tcs.attendance.Entity.Subject;
import java.util.List;
import java.util.Optional;

@Service
public class Subject_serve {

    @Autowired
    private SubjectRepo subjectRepo;

    //Get list of all the subject that the school provide
    public List<Subject> getallsubject() {
        return subjectRepo.findAll();
    }


    //get the specific subject by id
    public Subject getSubjectById(Long Id) {
        Optional<Subject> sample_sub = subjectRepo.findById(Id);
        if (sample_sub.isPresent()) {
            return sample_sub.get();
        } else {
            return new Subject(null, "No subject of this id ");
        }

    }

    //deelete the specific suhect by id 
    public void deletebyId(Long Id) {
        Optional<Subject> sample_sub = subjectRepo.findById(Id);
        if (sample_sub.isPresent()) {
            subjectRepo.deleteById(Id);
        } else {
            System.err.println("no such subject detected ");
        }
    }

     // delet all the subjects 
     public void deleteallthesub()
     {
        subjectRepo.deleteAll();
     }

    //save a subject 
    public void saveSub(Subject sub) {
        subjectRepo.save(sub);
    }
     
    //save all subs 
    public void saveALlSub(List<Subject> sub_list)
    {
        subjectRepo.saveAll(sub_list);
    }

    // update a alredy exixting subject 
    public String  updaSubject(Subject test) {
        Long Idtest = test.getId();
        Optional<Subject> testsub = subjectRepo.findById(Idtest);
        if (testsub.isPresent()) {
            Subject temSubject = testsub.get();
            temSubject.setSubname(test.getSubname());
            subjectRepo.save(temSubject);
            return "Subject is updated";

        } else {
            saveSub(test);
            return "subject is added ";
        }
    }
}
