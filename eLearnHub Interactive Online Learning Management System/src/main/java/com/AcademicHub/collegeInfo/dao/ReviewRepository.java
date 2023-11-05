package com.AcademicHub.collegeInfo.dao;

import com.AcademicHub.collegeInfo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
