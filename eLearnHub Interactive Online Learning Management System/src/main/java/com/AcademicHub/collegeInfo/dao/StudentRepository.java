package com.AcademicHub.collegeInfo.dao;

import com.AcademicHub.collegeInfo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
