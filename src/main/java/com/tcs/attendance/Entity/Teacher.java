package com.tcs.attendance.Entity;

import java.util.List;

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
public class Teacher {
   
    @Id
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long Id;
    @Getter
    @Setter
    private String teacher_name;
    @Getter
    @Setter
    private List<Long> std_list;
    @Getter
    @Setter
    private Long teach_sub_Id;

    public Teacher(String teach_name, List<Long> std_list, Long teach_sub_id)
    {
        this.teach_sub_Id=teach_sub_id;
        this.teacher_name=teach_name;
        this.std_list=std_list;
    }

public Teacher (){}
}
