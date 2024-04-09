package com.tcs.attendance.Entity;



// import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    // @GeneratedValue(generator = "UUID")
    // @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")\
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long Id;
    @Getter
    @Setter
    private String subname;
    
    public Subject( String subhect_name)
    {
        this.subname=subhect_name;
    }

}