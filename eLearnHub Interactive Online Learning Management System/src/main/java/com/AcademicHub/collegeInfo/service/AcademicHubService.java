package com.AcademicHub.collegeInfo.service;

import com.AcademicHub.collegeInfo.entity.Course;
import com.AcademicHub.collegeInfo.entity.Instructor;
import com.AcademicHub.collegeInfo.entity.Review;

import java.util.List;

public interface AcademicHubService {

    List<Instructor> findAllInstructor();

    Instructor findInstructorById(int instructorId);

    void createInstructor(Instructor instructor);

    void deleteInstructor(int theId);

    Instructor findInstructorByIdUsingJoinFetch(int instructorId);

    List<Course> findAllCourses();

    List<Course> findCoursesByInstructorId(int instructorId);

    Course findCourseByCourseId(int CourseId);

    void updateCourse(Course course);

    void deleteCourse(int courseId);

    void deleteTheCourse(int courseId);

    Course findCourseByCourseName(String theTitle);

    Course findCourseByIdUsingJoinFetch(int courseId);

    void deleteReview(int reviewId);


}
