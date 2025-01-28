package com.elearning.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@Getter
@Setter
public class enrollments {
	
	@Id
	@Column(name = "enrollment_id")
	private Long enrollmentId;
	
	@Column(name = "student_id")
	private Long studentId;
	
	// in one enrollment a student can enroll in multiple courses
	@OneToMany
	@JoinColumn(name = "course_id")
	private List<courses> enrollCourses;
	
	@Column(name = "module_progress", precision = 5, scale = 2)
	private BigDecimal moduleProgress;
	
	@Column(name = "lesson_progress", precision = 5, scale = 2)
	private BigDecimal lessonProgress;
	
	@Column(name = "course_status")
	private boolean courseStatus;
	
	@CreationTimestamp
	@Column(name = "enrollment_date")
	private LocalDate enrollDate;
}
