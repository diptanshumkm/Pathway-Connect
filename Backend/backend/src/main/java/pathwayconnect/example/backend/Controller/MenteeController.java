package pathwayconnect.example.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pathwayconnect.example.backend.DTO.MenteeRequestDTO;
import pathwayconnect.example.backend.DTO.MenteeResponseDTO;
import pathwayconnect.example.backend.Service.MenteeService;

@RestController
@RequestMapping("/users")
public class MenteeController {

    @Autowired
    private MenteeService service;

    @PostMapping("/mentee")
    public MenteeResponseDTO addMentee(@RequestBody MenteeRequestDTO menteeDetail){
        return service.addMentee(menteeDetail);
    }

    

}
