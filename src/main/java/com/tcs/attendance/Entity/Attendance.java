package com.tcs.attendance.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Temporal(TemporalType.DATE)
    private LocalDate date;
    
    private Boolean status1;
   
    private Long student_Id;

    public Attendance(LocalDate date, Boolean status1, Long Student_id) {
        this.date = date;
        this.status1 = status1;
        this.student_Id = Student_id;
    }

}
