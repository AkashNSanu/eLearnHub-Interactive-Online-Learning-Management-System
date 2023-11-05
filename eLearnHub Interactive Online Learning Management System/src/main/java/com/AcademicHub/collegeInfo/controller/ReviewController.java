package com.AcademicHub.collegeInfo.controller;

import com.AcademicHub.collegeInfo.entity.Course;
import com.AcademicHub.collegeInfo.entity.Review;
import com.AcademicHub.collegeInfo.service.AcademicHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/college")
public class ReviewController {

    private AcademicHubService academicHubService;

    @Autowired
    public ReviewController(AcademicHubService academicHubService){
        this.academicHubService = academicHubService;
    }

    @GetMapping("/showFormToAddReview")
    public String showFormToAddReview(@RequestParam("courseId") int courseId, Model model){
        Review review = new Review();
        model.addAttribute("courseId",courseId);
        model.addAttribute("review",review);
        return "college/review-form";
    }

    @PostMapping("/saveReview")
    public String saveReview(@RequestParam("courseId") int courseId, @ModelAttribute("review") Review review){
        Course course = academicHubService.findCourseByCourseId(courseId);
        course.addReview(review);
        academicHubService.updateCourse(course);
        return "redirect:/college/instructors";
    }

    @GetMapping("/deleteReview")
    public String deleteReview(@RequestParam("reviewId") int reviewId){
        academicHubService.deleteReview(reviewId);
        return "redirect:/college/instructors";
    }
}
