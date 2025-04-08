package pathwayconnect.example.backend.Service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pathwayconnect.example.backend.DTO.MentorRequestDTO;
import pathwayconnect.example.backend.DTO.MentorResponseDTO;
import pathwayconnect.example.backend.Models.*;
import pathwayconnect.example.backend.Models.UserTable.UserRole;
import pathwayconnect.example.backend.Repository.*;


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

    public List<MentorResponseDTO> getAllMentors(){

        List<MentorTable> data = mentorRepo.findAll();

        List<MentorResponseDTO> answer = new ArrayList<>();

        for(MentorTable i : data){
            MentorResponseDTO mentorResponseData = new MentorResponseDTO();
            mentorResponseData.setName(i.getUser().getName());
            mentorResponseData.setEmail(i.getUser().getEmail());
            mentorResponseData.setPhone(i.getUser().getPhone());
            mentorResponseData.setProfilePicture(i.getUser().getProfilePicture());
            mentorResponseData.setRole("MENTOR");
            mentorResponseData.setEducation(i.getProfessionalDetail().getEducation());
            mentorResponseData.setYearOfExperience(i.getProfessionalDetail().getYearOfExperience());
            mentorResponseData.setCurrentCompany(i.getProfessionalDetail().getCurrentCompany());
            mentorResponseData.setPastCompanies(i.getProfessionalDetail().getPastCompanies());
            answer.add(mentorResponseData);
        }
        return answer;

    }

    public MentorResponseDTO getMentorById(Long id){
        Optional<MentorTable> optionalMentorData =  mentorRepo.findById(id);
        if (optionalMentorData.isPresent()) {
            MentorTable data = optionalMentorData.get();
            MentorResponseDTO mentorDataById = new MentorResponseDTO();
            mentorDataById.setName(data.getUser().getName());
            mentorDataById.setEmail(data.getUser().getEmail());
            mentorDataById.setPhone(data.getUser().getPhone());
            mentorDataById.setProfilePicture(data.getUser().getProfilePicture());
            mentorDataById.setRole("MENTOR");
            mentorDataById.setEducation(data.getProfessionalDetail().getEducation());
            mentorDataById.setYearOfExperience(data.getProfessionalDetail().getYearOfExperience());
            mentorDataById.setCurrentCompany(data.getProfessionalDetail().getCurrentCompany());
            mentorDataById.setPastCompanies(data.getProfessionalDetail().getPastCompanies());

            return mentorDataById;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not present!");
        }

    }

    public void updateMentor(MentorRequestDTO mentorData, Long id){
        Optional<MentorTable> optionalMentor = mentorRepo.findById(id);

        if (!optionalMentor.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mentor not found!");
        }

        MentorTable mentor = optionalMentor.get();

        // Update User details
        UserTable user = mentor.getUser();
        user.setName(mentorData.getName());
        user.setEmail(mentorData.getEmail());
        user.setPhone(mentorData.getPhone());
        user.setProfilePicture(mentorData.getProfilePicture());
        user.setRole(UserRole.MENTOR); // optional if role is constant

        userRepo.save(user);

        // Update Professional Details
        ProfessionalDetail professionalDetail = mentor.getProfessionalDetail();
        professionalDetail.setEducation(mentorData.getEducation());
        professionalDetail.setYearOfExperience(mentorData.getYearOfExperience());
        professionalDetail.setCurrentCompany(mentorData.getCurrentCompany());
        professionalDetail.setPastCompanies(mentorData.getPastCompanies());

        professionalRepo.save(professionalDetail);
    }

    public void patchUpdateMentor(MentorRequestDTO mentorData, Long id) {
        Optional<MentorTable> optionalMentor = mentorRepo.findById(id);
    
        if (!optionalMentor.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mentor not found!");
        }
    
        MentorTable mentor = optionalMentor.get();
        UserTable user = mentor.getUser();
        ProfessionalDetail professional = mentor.getProfessionalDetail();
    
        // Update user fields only if present in DTO
        if (mentorData.getName() != null) user.setName(mentorData.getName());
        if (mentorData.getEmail() != null) user.setEmail(mentorData.getEmail());
        if (mentorData.getPhone() != null) user.setPhone(mentorData.getPhone());
        if (mentorData.getProfilePicture() != null) user.setProfilePicture(mentorData.getProfilePicture());
    
        userRepo.save(user);
    
        // Update professional details if present
        if (mentorData.getEducation() != null) professional.setEducation(mentorData.getEducation());
        if (mentorData.getYearOfExperience() != 0) professional.setYearOfExperience(mentorData.getYearOfExperience());
        if (mentorData.getCurrentCompany() != null) professional.setCurrentCompany(mentorData.getCurrentCompany());
        if (mentorData.getPastCompanies() != null) professional.setPastCompanies(mentorData.getPastCompanies());
    
        professionalRepo.save(professional);
    }
    
    public void deleteMentorById(Long id) {
        Optional<MentorTable> optionalData = mentorRepo.findById(id);
        if (optionalData.isPresent()) {
            MentorTable data = optionalData.get();
    
            // First delete child associations to avoid foreign key issues
            mentorRepo.delete(data);  // Delete Mentor entry first (has references)
            professionalRepo.delete(data.getProfessionalDetail()); // Delete Professional details
            userRepo.delete(data.getUser()); // Finally, delete User
    
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mentor not found");
        }
    }
    
}
