package com.AcademicHub.collegeInfo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@NoArgsConstructor
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "native_place")
    private String nativePlace;

    @Column(name = "degree")
    private String degree;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "instructor",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Course> courses;

    public Instructor(String firstName, String lastName, String email, String mobile, String nativePlace, String degree, String youtubeChannel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.nativePlace = nativePlace;
        this.degree = degree;
        this.youtubeChannel = youtubeChannel;
    }

    public void addCourses(Course theCourse){
        if(courses == null){
            courses = new ArrayList<>();
        }

        courses.add(theCourse);

        theCourse.setInstructor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", degree='" + degree + '\'' +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                '}';
    }
}
