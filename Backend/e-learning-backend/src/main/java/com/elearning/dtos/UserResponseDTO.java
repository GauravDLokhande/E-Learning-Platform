package com.elearning.dtos;

import com.elearning.pojos.UserRole;
import com.elearning.pojos.Users;

public class UserResponseDTO {
	private Long userId;
    private String username;
    private String email;
    private UserRole role;
    private String bio;
    private String contactInfo;
    private String profilePic;

    // Constructor
    public UserResponseDTO(Users user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole();  // Now using UserRole enum
        this.bio = user.getBio();
        this.contactInfo = user.getContactInfo();
        this.profilePic = user.getProfilePic();
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
