package com.elearning.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BaseEntity {
	
	@CreatedDate
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name = "updated_on")
	private LocalDateTime updatedOn;
	
}
