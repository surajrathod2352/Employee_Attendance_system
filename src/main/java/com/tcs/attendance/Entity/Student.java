package com.tcs.attendance.Entity;


import java.util.List;

import org.hibernate.annotations.GenericGenerator;

// import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
// import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
public class Student {
  
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private Long Id;
    @Getter
    @Setter
    private String student_name;
    @Getter
    @Setter
    private int std;
    @Getter
    @Setter
    private Long class_teacher_Id;
    @Getter
    @Setter
    private List<Long> subList;
    @Getter
    @Setter
    private List<Long> attendance;

    @Override
    public String toString() {
        return "Student [Id=" + Id + ", student_name=" + student_name + ", std=" + std + ", class_teacher_Id="
                + class_teacher_Id + ", subList=" + subList + ", attendance=" + attendance + "]";
    }

    public Student(String student_name, int std, Long classtId, List<Long> Sublist, List<Long> attendance, Long cti) {
        this.class_teacher_Id = classtId;
        this.student_name = student_name;
        this.subList = Sublist;
        this.std = std;
        this.attendance=attendance;
        this.class_teacher_Id=cti;
    }

    public Student()
    {

    }
}
