package com.elearning.pojos;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = { "password"})
public class Users extends BaseEntity{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(length = 50)
	private String username;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(length = 50)
	private String designation;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 50)
	private String password;
	
	@Enumerated(EnumType.STRING) // create column of type
	// varchar to store the name of constant
	@Column(length = 30) // varchar(30)
	private UserRole role;
	
	/*@Enumerated(EnumType.STRING)
@Column(nullable = false)*/
	
	@Column(length = 255)
	private String bio;
	
	@Column(name="contact_info",length = 100)
	private String contactInfo;
	
	@Lob
	@Column(name="profile_picture")
	private String profilePic;
	
//	@Column(name = "registration_date")
//    @CreatedDate
//    private LocalDateTime registrationDate;
	
	@UpdateTimestamp
	@Column(name = "registration_date")
	private Date registrationDate;
	
	@Column(name = "status", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean status = false; 
	
	public Users(String username, String email, String password, UserRole role, String bio, String contactInfo,
			String profilePic) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.bio = bio;
		this.contactInfo = contactInfo;
		this.profilePic = profilePic;
	}
}
