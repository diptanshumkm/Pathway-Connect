package pathwayconnect.example.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pathwayconnect.example.backend.DTO.MentorRequestDTO;
import pathwayconnect.example.backend.DTO.MentorResponseDTO;
import pathwayconnect.example.backend.Models.MentorTable;
import pathwayconnect.example.backend.Models.UserTable;
import pathwayconnect.example.backend.Service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


   @PostMapping("/add-user")
   public ResponseEntity<UserTable> addUser(@RequestBody UserTable user) {
        return service.addUser(user);
   }

    @PostMapping("/mentor")
    public MentorTable addMentor(@RequestBody MentorRequestDTO mentorData){
        return service.addMentor(mentorData);
    }

    @GetMapping("/mentors")
    public List<MentorResponseDTO> getAllMentors(){
        return service.getAllMentors();
    }

    @GetMapping("/mentor/{id}")
    public MentorResponseDTO getMentorById(@PathVariable Long id){
        return service.getMentorById(id);
    }

    @PutMapping("/mentor/{id}")
    public ResponseEntity<String> updateMentorById(@RequestBody MentorRequestDTO mentorData, @PathVariable Long id){
        service.updateMentor(mentorData, id);
        return ResponseEntity.ok("Mentor updated successfully!");
    }

    @PatchMapping("/mentor/{id}")
    public ResponseEntity<String> patchMentor(@RequestBody MentorRequestDTO mentorData, @PathVariable Long id) {
        service.patchUpdateMentor(mentorData, id);
        return ResponseEntity.ok("Mentor data updated (partial) successfully.");
    }

    @DeleteMapping("/mentor/{id}")
    public ResponseEntity<String> deleteMentor(@PathVariable Long id) {
        service.deleteMentorById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Mentor deleted successfully!");
    }

    @PostMapping("/mentor/{id}/upload-image")
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam ("file") MultipartFile file){
        service.uploadMentorPhoto(id, file);
        return ResponseEntity.ok("Mentor Image uploaded successfully!");
    }  

}
