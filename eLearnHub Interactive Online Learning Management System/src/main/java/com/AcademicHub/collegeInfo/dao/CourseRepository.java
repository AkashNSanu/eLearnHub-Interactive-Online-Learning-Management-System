package com.AcademicHub.collegeInfo.dao;

import com.AcademicHub.collegeInfo.entity.Course;
import com.AcademicHub.collegeInfo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("FROM Course WHERE instructor.id = :theId")
    List<Course> findCoursesByInstructorId(int theId);

    @Query("FROM Course WHERE title = :theTitle")
    Course findCourseByCourseName(String theTitle);

    @Query("SELECT c FROM Course c JOIN FETCH c.reviews WHERE c.id = :theId")
    Course findCourseByIdUsingJoinFetch(int theId);
}
