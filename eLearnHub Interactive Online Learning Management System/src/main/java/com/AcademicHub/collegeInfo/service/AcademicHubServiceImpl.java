package com.AcademicHub.collegeInfo.service;

import com.AcademicHub.collegeInfo.dao.*;
import com.AcademicHub.collegeInfo.entity.Course;
import com.AcademicHub.collegeInfo.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicHubServiceImpl implements AcademicHubService{

    private CourseRepository courseRepository;

    private InstructorRepository instructorRepository;

    private StudentRepository studentRepository;

    private ReviewRepository reviewRepository;

    private AcademicHubDAO academicHubDAO;

    @Autowired
    public AcademicHubServiceImpl(CourseRepository courseRepository,InstructorRepository instructorRepository,StudentRepository studentRepository,ReviewRepository reviewRepository,AcademicHubDAO academicHubDAO){
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
        this.reviewRepository = reviewRepository;
        this.academicHubDAO = academicHubDAO;
    }


    @Override
    public List<Instructor> findAllInstructor() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findInstructorById(int instructorId) {
        Optional<Instructor> result = instructorRepository.findById(instructorId);
        Instructor instructor = null;
        if(result.isPresent()) instructor=result.get();
        return instructor;
    }

    @Override
    public void createInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(int theId) {
        instructorRepository.deleteById(theId);
    }

    @Override
    public Instructor findInstructorByIdUsingJoinFetch(int instructorId) {
        return instructorRepository.findInstructorByIdUsingJoinFetch(instructorId);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findCoursesByInstructorId(int instructorId) {
        return courseRepository.findCoursesByInstructorId(instructorId);
    }

    @Override
    public Course findCourseByCourseId(int CourseId) {
        Optional<Course> result = courseRepository.findById(CourseId);
        Course course = null;
        if(result.isPresent()) course=result.get();
        return course;
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    @Transactional
    public void deleteTheCourse(int courseId) {
        academicHubDAO.deleteTheCourse(courseId);
    }

    @Override
    public Course findCourseByCourseName(String theTitle) {
        Optional<Course> result = Optional.ofNullable(courseRepository.findCourseByCourseName(theTitle));
        Course course = null;
        if(result.isPresent()) course=result.get();
        return course;
    }

    @Override
    public Course findCourseByIdUsingJoinFetch(int courseId) {
        return courseRepository.findCourseByIdUsingJoinFetch(courseId);
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
