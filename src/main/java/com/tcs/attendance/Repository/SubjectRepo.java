package com.tcs.attendance.Repository;
import com.tcs.attendance.Entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Long> {
    
}
