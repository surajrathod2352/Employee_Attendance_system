package com.tcs.attendance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.attendance.Entity.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance,Long>{
    
}
