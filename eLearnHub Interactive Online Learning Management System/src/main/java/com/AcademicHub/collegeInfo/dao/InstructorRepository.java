package com.AcademicHub.collegeInfo.dao;

import com.AcademicHub.collegeInfo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

    @Query("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = :theId")
    Instructor findInstructorByIdUsingJoinFetch(int theId);
}
