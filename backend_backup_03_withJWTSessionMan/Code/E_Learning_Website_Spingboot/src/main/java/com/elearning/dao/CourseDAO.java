package com.elearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.pojos.Courses;
import com.elearning.pojos.Users;

public interface CourseDAO extends JpaRepository<Courses, Long>{
    List<Courses> findByInstructor(Users instructor);  
}
