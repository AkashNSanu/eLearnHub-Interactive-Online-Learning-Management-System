package com.AcademicHub.collegeInfo.controller;

import com.AcademicHub.collegeInfo.entity.Course;
import com.AcademicHub.collegeInfo.entity.Instructor;
import com.AcademicHub.collegeInfo.entity.Review;
import com.AcademicHub.collegeInfo.service.AcademicHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/college")
public class CourseController {

    private AcademicHubService academicHubService;

    @Autowired
    public CourseController(AcademicHubService academicHubService){
        this.academicHubService = academicHubService;
    }

    @GetMapping("/courses")
    public String findAllCourses(Model theModel){

        List<Course> courses = academicHubService.findAllCourses();
        theModel.addAttribute("courses",courses);
        return "college/courses-list";
    }

    @GetMapping("/showFormToUpdateCourse")
    public String showFormToUpdateCourse(@RequestParam("courseId") int courseId, Model theModel){
        Course course1 = academicHubService.findCourseByCourseId(courseId);
        Course course = new Course(course1);
        theModel.addAttribute("course",course);
        theModel.addAttribute("courseId",courseId);
        return "college/course-update-form";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@ModelAttribute("course") Course course,@RequestParam("courseId") int courseId){
        Course course1 = academicHubService.findCourseByCourseId(courseId);
        course1.setTitle(course.getTitle());
        academicHubService.updateCourse(course1);
        return "redirect:/college/instructors";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId") int courseId){
        System.out.println(courseId);
        academicHubService.deleteCourse(courseId);
        return "redirect:/college/instructors";
    }

    @GetMapping("/showReviews")
    public String showReviews(@RequestParam("courseId") int courseId,Model model){
        Course course = academicHubService.findCourseByCourseId(courseId);
        List<Review> reviews = course.getReviews();
        model.addAttribute("courseId",course.getId());
        model.addAttribute("reviews",reviews);
        return "college/review-list";
    }
}
