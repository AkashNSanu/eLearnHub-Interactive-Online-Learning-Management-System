package com.AcademicHub.collegeInfo.dao;

import com.AcademicHub.collegeInfo.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AcademicHubDAOImpl implements AcademicHubDAO{

    private EntityManager entityManager;

    @Autowired
    public AcademicHubDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public void deleteTheCourse(int courseId) {
        Course course = entityManager.find(Course.class,courseId);
        entityManager.remove(course);
    }
}
