package com.elearning.services;

import java.util.List;

import com.elearning.dtos.AdminRequestDTO;
import com.elearning.dtos.AdminResponseDTO;
import com.elearning.dtos.UserRegPerMonResponseDTO;

public interface AdminService {
	
//	public List<UserRegPerMonResponseDTO> getRegisteredUserCountsPerMonth();
	
	public List<AdminResponseDTO> getEnrolledUserCountPerCourse();
	
}
