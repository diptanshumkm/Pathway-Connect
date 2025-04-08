package pathwayconnect.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pathwayconnect.example.backend.DTO.MentorRequestDTO;
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

    @PostMapping("/add-mentor")
    public MentorTable addMentor(@RequestBody MentorRequestDTO mentorData){
        // System.out.println(mentorData);
        return service.addMentor(mentorData);
    }


}
