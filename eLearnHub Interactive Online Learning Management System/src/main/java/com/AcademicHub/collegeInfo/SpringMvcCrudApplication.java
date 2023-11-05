package com.AcademicHub.collegeInfo;

import com.AcademicHub.collegeInfo.entity.Course;
import com.AcademicHub.collegeInfo.entity.Instructor;
import com.AcademicHub.collegeInfo.entity.Review;
import com.AcademicHub.collegeInfo.service.AcademicHubService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringMvcCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AcademicHubService academicHubService){
		return runner -> {
			//findCoursesByInstructorId(academicHubService);

			//deleteCourse(academicHubService);

			//findCourseByCourseName(academicHubService);

			//findCourseByCourseId(academicHubService);
		};
	}

	private void findCourseByCourseId(AcademicHubService academicHubService) {
		int courseId = 101;
		Course course = academicHubService.findCourseByIdUsingJoinFetch(courseId);
		course.setTitle("football");
		academicHubService.updateCourse(course);
		System.out.println("done");
	}

	private void findCourseByCourseName(AcademicHubService academicHubService) {
	}

	private void deleteCourse(AcademicHubService academicHubService) {
		int courseId = 101;
		academicHubService.deleteCourse(courseId);
		System.out.println("done");
	}

	private void findCoursesByInstructorId(AcademicHubService academicHubService) {
		int instructorId = 1;
		List<Course> courses = academicHubService.findCoursesByInstructorId(instructorId);
		for(Course i:courses){
			System.out.println(i);
		}
	}


}
