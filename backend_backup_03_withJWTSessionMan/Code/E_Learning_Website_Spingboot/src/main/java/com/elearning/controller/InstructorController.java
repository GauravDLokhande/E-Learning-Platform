package com.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.elearning.dtos.InstructorResponseDTO;
import com.elearning.services.InstructorService;

@RestController
@RequestMapping("/instructors")
@CrossOrigin(origins = "http://localhost:5173/")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/lessons/{lessonId}")
    public InstructorResponseDTO getInstructorByLessonId(@PathVariable Long lessonId) {
        return instructorService.getInstructorByLessonId(lessonId);
    }
}
