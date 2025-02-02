package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dtos.LessonResponseDTO;
import com.elearning.pojos.lessons;
import com.elearning.services.LessonService;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/modules/lessons/{moduleId}")
    public List<LessonResponseDTO> getLessonsByModuleId(@PathVariable Long moduleId) {
        return lessonService.getLessonsByModuleId(moduleId);
    }
    
    @GetMapping("/lessons/{lessonId}")
    public LessonResponseDTO getLessonByLessonId(@PathVariable Long lessonId) {
    	return lessonService.getLessonByLessonId(lessonId);
    }
}
