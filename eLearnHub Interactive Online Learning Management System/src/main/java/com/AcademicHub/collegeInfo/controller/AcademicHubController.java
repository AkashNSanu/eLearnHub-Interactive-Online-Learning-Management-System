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
public class AcademicHubController {

    private AcademicHubService academicHubService;

    @Autowired
    public AcademicHubController(AcademicHubService academicHubService){
        this.academicHubService = academicHubService;
    }

    @GetMapping("/instructors")
    public String findAllInstructor(Model theModel){

        List<Instructor> instructors = academicHubService.findAllInstructor();
        theModel.addAttribute("instructors",instructors);
        return "college/instructors-list";
    }

    @GetMapping("/showInstructorDetails")
    public String showInstructorDetails(@RequestParam("instructorId") int theId, Model theModel){

        Instructor instructor = academicHubService.findInstructorById(theId);
        theModel.addAttribute("instructor",instructor);
        return "college/instructor-details";
    }

    @GetMapping("/showFormToAddInstructor")
    public String shoeFormForAdd(Model theModel){

        Instructor instructor = new Instructor();
        theModel.addAttribute("instructor",instructor);
        return "college/instructor-form";
    }

    @PostMapping("/saveInstructor")
    public String addInstructor(@ModelAttribute("instructor") Instructor instructor){
        try {
            Instructor instructor1 = academicHubService.findInstructorByIdUsingJoinFetch(instructor.getId());
            System.out.println(instructor1.getCourses());
        }
        catch (Exception e){
            Course course = new Course("null");
            Review review = new Review("null");
            course.addReview(review);
            instructor.addCourses(course);
        }
        academicHubService.createInstructor(instructor);
        return "redirect:/college/instructors";
    }

    @GetMapping("/showFormToUpdateInstructor")
    public String showFormToUpdateInstructor(@RequestParam("instructorId") int theId, Model theModel){

        Instructor instructor = academicHubService.findInstructorById(theId);
        theModel.addAttribute("instructor",instructor);
        return "college/instructor-form";
    }

    @GetMapping("/deleteInstructor")
    public String deleteInstructor(@RequestParam("instructorId") int theId){

        academicHubService.deleteInstructor(theId);
        return "redirect:/college/instructors";
    }

    @GetMapping("/showFormToAddCourse")
    public String showFormToAddCourse(@RequestParam("instructorId") int instructorId,Model theModel){

        Course course = new Course();
        theModel.addAttribute("instructorId",instructorId);
        theModel.addAttribute("course",course);
        return "college/course-form";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course,@RequestParam("instructorId") int instructorId){

        Instructor instructor = academicHubService.findInstructorByIdUsingJoinFetch(instructorId);
        Review review = new Review("Good Course");
        course.addReview(review);
        instructor.addCourses(course);
        academicHubService.createInstructor(instructor);
        return "redirect:/college/instructors";
    }

    @GetMapping("/showInstructorAllCourses")
    public String showInstructorAllCourses(@RequestParam("instructorId") int instructorId,Model model){

        Instructor instructor = academicHubService.findInstructorById(instructorId);
        List<Course> courses = instructor.getCourses();
        model.addAttribute("courses",courses);
        return "college/courses-list";
    }
}
