package pathwayconnect.example.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pathwayconnect.example.backend.Models.UserTable;
import pathwayconnect.example.backend.Repository.UserRepo;


@Service
public class UserService {
    
    @Autowired
    private UserRepo repo;


    public UserTable addUser(UserTable user){

        if (user.getEmail() != null && user.getPhone()!=null && repo.existsByEmailAndPhone(user.getEmail(), user.getPhone())) {
            throw new ResponseStatusException(HttpStatus.FOUND, "User Already Exists!");
        }
        return repo.save(user);
    }

}
