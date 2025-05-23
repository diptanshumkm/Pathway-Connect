package pathwayconnect.example.backend.DTO;

import java.util.*;

public class MentorRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String profilePicture;
    private String role;
    
    private String education;
    private Integer yearsOfExperience;
    private String currentCompany;
    private List<String> pastCompanies;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearOfExperience) {
        this.yearsOfExperience = yearOfExperience;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public List<String> getPastCompanies() {
        return pastCompanies;
    }

    public void setPastCompanies(List<String> pastCompanies) {
        this.pastCompanies = pastCompanies;
    }

    
}
    
