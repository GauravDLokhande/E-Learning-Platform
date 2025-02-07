package com.elearning.controller;

import com.elearning.dtos.AdminRequestDTO;
import com.elearning.dtos.AdminResponseDTO;
import com.elearning.dtos.UserRegPerMonResponseDTO;
import com.elearning.services.AdminService;
import com.elearning.services.FakeInstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
    private AdminService adminService;
	
	@Autowired
	private FakeInstructorService fakeInstructorService;

//	@GetMapping("/user-count-per-month")
//	public List<UserRegPerMonResponseDTO> getUserCountsPerMonth() {
//	    return adminService.getRegisteredUserCountsPerMonth();
//	}

    @GetMapping("/enrolled-users-per-course")
    public List<AdminResponseDTO> getEnrolledUserCountPerCourse() {
        return adminService.getEnrolledUserCountPerCourse();
    }
    
    @PostMapping("/add-instructor")
    public String addInstructorAndAssignCourse(@RequestBody AdminRequestDTO requestDTO) {
        return fakeInstructorService.addInstructorAndAssignCourse(requestDTO);
    }
}
