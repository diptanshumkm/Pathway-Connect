package pathwayconnect.example.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pathwayconnect.example.backend.DTO.MentorRequestDTO;
import pathwayconnect.example.backend.Models.MentorTable;
import pathwayconnect.example.backend.Models.ProfessionalDetail;
import pathwayconnect.example.backend.Models.UserTable;
import pathwayconnect.example.backend.Models.UserTable.UserRole;
import pathwayconnect.example.backend.Repository.MentorRepo;
import pathwayconnect.example.backend.Repository.ProfessionalRepo;
import pathwayconnect.example.backend.Repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProfessionalRepo professionalRepo;

    @Autowired
    private MentorRepo mentorRepo;

    public ResponseEntity<UserTable> addUser(UserTable user) {
        if (user.getEmail() != null && user.getPhone() != null && userRepo.existsByEmailAndPhone(user.getEmail(), user.getPhone())) {
            throw new ResponseStatusException(HttpStatus.FOUND, "User Already Exists!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepo.save(user));
    }

    public MentorTable addMentor(MentorRequestDTO mentorData) {
        if (mentorData.getEmail() == null || mentorData.getEmail().isEmpty() ||
            mentorData.getEducation() == null || mentorData.getEducation().isEmpty() ||
            mentorData.getPastCompanies() == null || mentorData.getPastCompanies().isEmpty() ||
            !"MENTOR".equals(mentorData.getRole())) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Enter all fields correctly!");
        }

        if (userRepo.existsByEmailAndPhone(mentorData.getEmail(), mentorData.getPhone())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mentor Already Exists!");
        }

        UserTable user = new UserTable();
        user.setName(mentorData.getName());
        user.setEmail(mentorData.getEmail());
        user.setPhone(mentorData.getPhone());
        user.setProfilePicture(mentorData.getProfilePicture());
        user.setRole(UserRole.MENTOR);
        userRepo.save(user);

        ProfessionalDetail professionalData = new ProfessionalDetail();
        professionalData.setYearOfExperience(mentorData.getYearOfExperience());
        professionalData.setCurrentCompany(mentorData.getCurrentCompany());
        professionalData.setPastCompanies(mentorData.getPastCompanies());
        professionalData.setEducation(mentorData.getEducation());
        professionalRepo.save(professionalData);

        MentorTable mentorTableData = new MentorTable();
        mentorTableData.setUser(user);
        mentorTableData.setProfessionalDetail(professionalData);

        return mentorRepo.save(mentorTableData);
    }
}
