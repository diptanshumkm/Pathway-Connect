package pathwayconnect.example.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pathwayconnect.example.backend.DTO.MenteeRequestDTO;
import pathwayconnect.example.backend.DTO.MenteeResponseDTO;
import pathwayconnect.example.backend.Models.*;
import pathwayconnect.example.backend.Repository.*;
import pathwayconnect.example.backend.utils.PasswordGenerator;
import pathwayconnect.example.backend.utils.RandomIdGenerator;

@Service
public class MenteeService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MenteeRepo menteeRepo;
    @Autowired
    private EducationRepo educationRepo;
    @Autowired
    private GoalsRepo goalsRepo;
    @Autowired
    private LoginRepo loginRepo;


    private String generateUniqueUserId() {
        String loginId;
        do{
            loginId =RandomIdGenerator.generateRandomId();
        }while(loginRepo.existsByLoginId(loginId));
        return loginId;
    }
    
    private String generatePassword(){
        String password = PasswordGenerator.generateSecurePassword();
        return password;
    }

    public MenteeResponseDTO addMentee(MenteeRequestDTO menteeDetail) {
        // Basic validation
        if (menteeDetail.getEmail() == null || menteeDetail.getEmail().isEmpty() ||
            menteeDetail.getName() == null || menteeDetail.getName().isEmpty() ||
            menteeDetail.getPhone() == null || menteeDetail.getPhone().isEmpty() ||
            menteeDetail.getRole() == null || !menteeDetail.getRole().equalsIgnoreCase("MENTEE")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter all fields correctly!");
        }

        // Check if user already exists
        if (userRepo.existsByEmailAndPhone(menteeDetail.getEmail(), menteeDetail.getPhone())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mentee Already Exists!");
        }

        // Create UserTable entry
        UserTable user = new UserTable();
        user.setName(menteeDetail.getName());
        user.setEmail(menteeDetail.getEmail());
        user.setPhone(menteeDetail.getPhone());
        user.setProfilePicture(menteeDetail.getProfilePic());
        user.setRole(UserTable.UserRole.MENTEE);
        userRepo.save(user);

        // Create Education entry
        Education education = new Education();
        education.setEducationLevel(EducationLevel.valueOf(menteeDetail.getEducationLevel()));
        education.setFieldOfStudy(menteeDetail.getFieldOfStudy());
        education.setInstitution(menteeDetail.getInstitution());
        educationRepo.save(education);

        // Create Goals entry
        Goals goals = new Goals();
        goals.setGoalType(GoalType.valueOf(menteeDetail.getGoalType()));
        goals.setGoal(menteeDetail.getGoal());
        goalsRepo.save(goals);

        // Create Mentee entry
        Mentee mentee = new Mentee();
        mentee.setUser(user);
        mentee.setEducation(education);
        mentee.setGoal(goals);
        mentee.setInterests(menteeDetail.getInterests());
        menteeRepo.save(mentee);


        //Create login credentials
        LoginCredentials login = new LoginCredentials();
        login.setUser(user);
        login.setLoginId(generateUniqueUserId());
        login.setLoginPassword(generatePassword());
        loginRepo.save(login);


        // Prepare and return response DTO
        MenteeResponseDTO response = new MenteeResponseDTO();

        response.setId(mentee.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setProfilePic(user.getProfilePicture());
        response.setRole(user.getRole().name());
        response.setEducationLevel(education.getEducationLevel().name());
        response.setFieldOfStudy(education.getFieldOfStudy());
        response.setInstitution(education.getInstitution());
        response.setGoalType(goals.getGoalType().name());
        response.setGoal(goals.getGoal());
        response.setInterests(mentee.getInterests());
        response.setLogInId(login.getLoginId());
        response.setLogInPassword(login.getLoginPassword());

        return response;
    }






}
