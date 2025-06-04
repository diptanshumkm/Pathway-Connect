package pathwayconnect.example.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pathwayconnect.example.backend.DTO.LoginRequestDTO;
import pathwayconnect.example.backend.DTO.MenteeResponseDTO;
import pathwayconnect.example.backend.DTO.MentorResponseDTO;
import pathwayconnect.example.backend.Models.LoginCredentials;
import pathwayconnect.example.backend.Models.Mentee;
import pathwayconnect.example.backend.Models.MentorTable;
import pathwayconnect.example.backend.Models.UserTable;
import pathwayconnect.example.backend.Repository.LoginRepo;
import pathwayconnect.example.backend.Repository.MenteeRepo;
import pathwayconnect.example.backend.Repository.MentorRepo;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private MentorRepo mentorRepo;

    @Autowired
    private MenteeRepo menteeRepo;

    public MentorResponseDTO loginMentor(LoginRequestDTO loginCredentials){

        if (loginCredentials.getUserId().isEmpty() || loginCredentials.getUserId() == null 
        || loginCredentials.getPassword().isEmpty() || loginCredentials.getPassword()==null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter all the fields correctly");
        }

        LoginCredentials credential = loginRepo.findByLoginIdAndLoginPassword(loginCredentials.getUserId(), loginCredentials.getPassword());
        if (credential == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user present.");
        }


        UserTable user = credential.getUser();
        
        MentorTable mentor =  mentorRepo.findMentorTableByUser(user);

        if (mentor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mentor details not found for the user.");
        }

        // Prepare response 
        MentorResponseDTO response = new MentorResponseDTO();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setProfilePicture(user.getProfilePicture());
        response.setEducation(mentor.getProfessionalDetail().getEducation());
        response.setYearOfExperience(mentor.getProfessionalDetail().getYearOfExperience());
        response.setRole(user.getRole().name());
        response.setPastCompanies(mentor.getProfessionalDetail().getPastCompanies());
        response.setLogInId(null);
        response.setLogInPassword(null);
        
        return response;

    }
    

    public MenteeResponseDTO loginMentee(LoginRequestDTO loginCredentials){
        if (loginCredentials.getUserId() == null || loginCredentials.getUserId().isEmpty() ||
            loginCredentials.getPassword() == null || loginCredentials.getPassword().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter all the fields correctly");
        }

        LoginCredentials credential = loginRepo.findByLoginIdAndLoginPassword(loginCredentials.getUserId(), loginCredentials.getPassword());
        if (credential == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user present.");
        }

        UserTable user = credential.getUser();
        Mentee mentee = menteeRepo.findMenteeByUser(user);
        if (mentee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mentee details not found for the user.");
        }

        MenteeResponseDTO response = new MenteeResponseDTO();
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setPhone(user.getPhone());
        response.setProfilePic(user.getProfilePicture());
        response.setRole(user.getRole().name());

        if (mentee.getEducation() != null) {
            response.setEducationLevel(mentee.getEducation().getEducationLevel().name());
            response.setFieldOfStudy(mentee.getEducation().getFieldOfStudy());
            response.setInstitution(mentee.getEducation().getInstitution());
        }

        if (mentee.getGoal() != null) {
            response.setGoalType(mentee.getGoal().getGoalType().name());
            response.setGoal(mentee.getGoal().getGoal());
        }

        response.setInterests(mentee.getInterests());

        return response;
    }

}
