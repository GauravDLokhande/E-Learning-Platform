package com.elearning.dtos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.pojos.Lessons;

public interface lessonDao extends JpaRepository<Lessons, Long> {

}
