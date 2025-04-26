package pathwayconnect.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pathwayconnect.example.backend.DTO.LoginRequestDTO;
import pathwayconnect.example.backend.DTO.MentorResponseDTO;
import pathwayconnect.example.backend.Service.LoginService;

@RestController
@RequestMapping("/users/login")
public class LoginController {
    
    @Autowired
    private LoginService service;

    @PostMapping("/mentor")
    public MentorResponseDTO mentorLogin(@RequestBody LoginRequestDTO loginCredentials){
        return service.loginMentor(loginCredentials);
    } 

}
